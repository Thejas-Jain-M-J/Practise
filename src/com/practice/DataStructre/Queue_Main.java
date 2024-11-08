package com.practice.DataStructre;

import java.util.HashMap;
import java.util.Map;

// 1. Push an element at the end of the data structure (O(1) time complexity) - void push(int element)
// 2. Pop the element from the beginning of the data structure( pop the earliest element added, O(1) time complexity) - int pop()
// 3. Seek an element at index i at any given state of the data structure. (O(1) time complexity) - int seek(int index)

public class Queue_Main {
    public static void main(String[] args) throws InterruptedException {

        Queue<Integer> ds = new Queue<>();

        ds.push(1);
        ds.push(2);
        ds.push(3);

        System.out.println(ds);

        ds.pop();
        System.out.println(ds);

        System.out.println("seek " + ds.seek(1));

        ds.push(4);
        System.out.println(ds);
        System.out.println("seek " +ds.seek(0));

        // Queue<String> str = new Queue<>();

        // str.push("Thejas");
        // str.push("Shreyas");
        // str.push("Rishika");
        // str.push("Swasthi");

        // System.out.println(str);

        // Queue<Integer> q =new Queue<>();

        // Thread t1 =new Thread(() -> {
        //     for(int i=0;i<5;i++)
        //     {
        //         q.push(i);
        //         System.out.println("Thread 1 pushed: " + i);
        //         //q.pop();
        //     }
        // });
        // t1.start();

        
        // Thread t2 =new Thread(() -> {
        //     for(int i=0;i<5;i++)
        //     {
        //         q.push(i);
        //       //  q.pop();
        //         System.out.println("Thread 2 pushed: " + i);
        //     }
        // });
        // t2.start();
        // Thread.sleep(2000);
        // System.out.println(q);





    }
}

class Queue<T> {

    private final Map<Integer, T> map = new HashMap<>();
    private int headIndex = -1;
    private int endIndex = -1;

    public  void push(T value) {

        if (map.isEmpty()) {
            map.put(++headIndex, value);
            ++endIndex;
        }
        map.put(++endIndex, value);

    }

    public synchronized void pop() {
        if (map.isEmpty()) {
            throw new RuntimeException("Nothing to remove as no elements present");
        }

        map.remove(headIndex++);

    }

    public T seek(int index) {
        if (map.isEmpty()) {
            throw new RuntimeException(" Nothing to seek as map is empty");
        }
        int actualIndex = headIndex + index;

        if (actualIndex > endIndex) {
            throw new ArrayIndexOutOfBoundsException("Index " + index + " is out of bound");
        }

        return map.get(actualIndex);
    }

    @Override
    public String toString() {
        return map.toString();
    }
}

