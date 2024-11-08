package com.practice.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ArrayList_example {

    public static void main(String[] args) {
        
        /**
         * How to make collections synchronized.
         * -> we can make collections synchronized by passing list to Collections.synchronizedList(list);
         * that will make list as thread safe.
         *-> But there is cache like it will be thread safe for only single operations or method call.
         *   If we are iterating over list then that code need to enclose in synchronized block. 
         * 
         */

         List<String> list = new ArrayList<>();

         List<String> synchronizedList = Collections.synchronizedList(new ArrayList<>());
         synchronizedList.add("Hello"); 
         synchronizedList.add("One");
         synchronizedList.add("Two");
         synchronizedList.add("Three"); // Thread-safe


         /**
          * But while iterating one thread is iterating and if other thread modifies the collection
            then we will get concurrent modification exception.
          */
         synchronized (synchronizedList) {
            for (String item : synchronizedList) {
                System.out.println(item);
            }
        }

        /**
         *  This concurrent modification one thread is access and other thread is modified
         *  the collection. that why while iterating we need to make that block as synchronized.
         */

        synchronizedList.remove("one");

        Thread thread1 = new Thread(() -> {
            synchronized (list) {
                for (String item : list) {
                    System.out.println("Thread 1: " + item);
                    try { Thread.sleep(100); } catch (InterruptedException e) { e.printStackTrace(); }
                }
            }
        });
        
        Thread thread2 = new Thread(() -> {
            synchronized (list) {
                list.add("Four");
                System.out.println("Thread 2 added Four");
            }
        });
        
        thread1.start();
        thread2.start();
    }

}
