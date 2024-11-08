package com.practice.multithreading;

import java.util.concurrent.CountDownLatch;

/**
 * 
 * @author tjainmj
 * 
 *         The use of count down latch is, it will make one thread to wait of
 *         other threads to complete it's execution
 *         Means to which thread we call await method that will wait until
 *         countdown become 0
 *         We will define the maximum value fo0r countdown latch. we decreasing
 *         value by one each time by calling countDown()
 *         Once latch value becomes 0. then thread awaiting here will start
 *         execution.
 *
 */
public class CountDownLatchExample {
    public static void main(String[] args) throws InterruptedException {
        // Create a CountDownLatch with a count of 3
        CountDownLatch latch = new CountDownLatch(3);

        // Create and start three worker threads
        WorkerThread worker1 = new WorkerThread("Worker 1", 1000, latch);
        WorkerThread worker2 = new WorkerThread("Worker 2", 2000, latch);
        WorkerThread worker3 = new WorkerThread("Worker 3", 3000, latch);

        /**
         * we can use join also to make other threads to wait until one thread finishes it's
         * execution. But here only one thread will do it's execution but other threads has to wait
         * but in case of countdown latch only one thread is waiting(main thread) and other
         * threads do their concurrent execution.
         */
        worker1.start();
        //worker1.join();
        worker2.start();
        //worker2.join();
        worker3.start();
        //worker3.join();

        latch.await();
        System.out.println("All workers have completed their tasks. Main thread resumes.");
        // Main thread waits for all workers to finish

        // latch.countDown();

    }
}

class WorkerThread extends Thread {
    private final String name;
    private final int sleepTime;
    private final CountDownLatch latch;

    public WorkerThread(String name, int sleepTime, CountDownLatch latch) {
        this.name = name;
        this.sleepTime = sleepTime;
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            // latch.await();
            System.out.println(name + " is starting its task.");
            // Simulate some task
            Thread.sleep(sleepTime);
            System.out.println(name + " has completed its task.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Count down the latch after completing the task
            latch.countDown();
        }
    }
}
