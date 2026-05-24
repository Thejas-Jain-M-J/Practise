package com.practice.multithreading;

import java.util.*;
import java.util.concurrent.*;

class CustomThreadPool {

    private final BlockingQueue<Runnable> taskQueue;
    private final List<Worker> workers;
    private volatile boolean isShutdown = false;

    // Constructor
    public CustomThreadPool(int poolSize) {
        taskQueue = new LinkedBlockingQueue<>();
        workers = new ArrayList<>();

        // create worker threads
        for (int i = 0; i < poolSize; i++) {
            Worker worker = new Worker("Thread-" + i);
            worker.start();
            workers.add(worker);
        }
    }

    // Submit new task to queue
    public void submit(Runnable task) {
        if (!isShutdown) {
            taskQueue.offer(task);
        } else {
            throw new IllegalStateException("Thread pool is shutting down");
        }
    }

    // Graceful shutdown
    public void shutdown() {
        isShutdown = true;
        for (Worker worker : workers) {
            worker.interrupt(); // stop waiting threads
        }
    }

    // Inner class: Worker
    private class Worker extends Thread {
        public Worker(String name) {
            super(name);
        }

        @Override
        public void run() {
            try {
                if(!isShutdown || !taskQueue.isEmpty()) {
                    Runnable task = taskQueue.poll(100, TimeUnit.MILLISECONDS);
                    if (task != null) {
                        task.run();
                    }
                }
            } catch (InterruptedException e) {
                // Exit gracefully when interrupted
            }
        }
    }
}

public class CustomThreadPoolMain {
    public static void main(String[] args) throws InterruptedException {
        CustomThreadPool pool = new CustomThreadPool(3);

        // Submit 10 tasks
        for (int i = 0; i < 10; i++) {
            int taskId = i;
            pool.submit(() -> {
                System.out.println(Thread.currentThread().getName() +
                        " executing task " + taskId);
                try { Thread.sleep(500); } catch (InterruptedException ignored) {}
            });
        }

        Thread.sleep(3000);
        pool.shutdown();
    }
}
