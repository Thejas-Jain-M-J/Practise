package com.practice.multithreading;

import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * Types of Executors
 *
 * 1. newFixedThreadPool()  -> It creates fixed number of threads and it can execute any
 * number of tasks assigned to it. Just it reuses the existing threads.
 * UnBounded Queue is used to hold excessive tasks.
 *
 * 2.newCachedThreadPool()  ->It creates new thread as and when it's required. It reuses the
 * previously created threads. But we shouldn't assign that take long time to run, as it will
 * creates more number of threads as task submitted then it make take whole system down.
 * There is no upper bound for creating threads.
 *
 * 3.newSingleThreadExecutor() -> As name tells only one thread will be created. That thread
 * will sequentially execute the all tasks.
 */

public class SimpleExecutorService {

    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(5);

        Runnable r = () -> {
            synchronized (new Thread()) {
                System.out.println("It's runnable");
            }
        };

        //MyThread a = new MyThread(())
        /**
         * execute() will not return anything just it executes the transaction. only runnable
         * can be submitted 
         * 
         * submit() will execute and return future object(). Both runnable and callable can be
         * submitted.
         */
        es.execute(new MyThread("A"));
        es.execute(new MyThread("B"));
        es.execute(new MyThread("C"));
        es.execute(new MyThread("D"));
        es.execute(r);

        es.shutdown();

    }

}

class MyThread implements Runnable {

    // Class data members
    String name;
    CountDownLatch latch;

    // Constructor
    MyThread(String name) {

        // this keyword refers to current instance itself
        this.name = name;
        // this.latch = latch;

        // new Thread(this);
    }

    // Method
    // Called automatically when thread is started
    public synchronized void run() {

        for (int i = 0; i < 5; i++) {
            System.out.println(name + ": " + i);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            // latch.countDown();
        }
    }
}
