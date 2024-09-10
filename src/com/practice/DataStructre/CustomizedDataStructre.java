package com.practice.DataStructre;

import java.util.HashMap;
import java.util.Map;

// 1. Push an element at the end of the data structure (O(1) time complexity) - void push(int element)
// 2. Pop the element from the beginning of the data structure( pop the earliest element added, O(1) time complexity) - int pop()
// 3. Seek an element at index i at any given state of the data structure. (O(1) time complexity) - int seek(int index)

public class CustomizedDataStructre {
    public static void main(String[] args) {

        MyCustomizedDataStructure ds = new MyCustomizedDataStructure();

        ds.push(1);
        ds.push(2);
        ds.push(3);

        System.out.println(ds);

        ds.pop();
        System.out.println(ds);

        System.out.println("seek " + ds.seek(1));

        ds.push(4);
        System.out.println(ds.seek(2));

    }
}

class MyCustomizedDataStructure {

    private final Map<Integer, Integer> map = new HashMap<>();
    private int headIndex = -1;
    private int endIndex = -1;

    public void push(int value) {

        if (map.isEmpty()) {
            map.put(++headIndex, value);
            ++endIndex;
        }
        map.put(endIndex++, value);

    }

    public void pop() {
        if (map.isEmpty()) {
            throw new RuntimeException("Nothing to remove as no elements present");
        }

        map.remove(headIndex++);

    }

    public int seek(int index) {
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

