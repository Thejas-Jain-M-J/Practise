package com.practice.stack;

import java.util.HashMap;

public class Minimum_SubArray_With_Different_KIntegers {

    public static void main(String[] args) {
        int arr[] = { 1, 1, 2, 2, 3, 3, 4, 5 };
        int n = arr.length;
        int k = 3;

        int start = 0;
        int end = n;

        int i = 0, j = 0;
        HashMap<Integer, Integer> hMap = new HashMap<>();
        while (i < n) {
            hMap.put(arr[i], hMap.getOrDefault(arr[i], 0) + 1);

            while (hMap.size() == k) {
                System.out.println("i -> "+i +" j -> "+j + " arr[i] -> "+arr[i] + "arr[j] -> "+arr[j]);
                int windowLength = i - j ;
                int subArrayLength = end - start ;

                if (windowLength < subArrayLength) {
                    start = j;
                    end = i;
                }

                if (hMap.get(arr[j]) == 1)
                {
                    hMap.remove(arr[j]);
                }
                else
                {
                    hMap.put(arr[j], hMap.get(arr[j]) - 1);
                }

                j++;
            }
            i++;
        }
        System.out.println("start " + start + " end " + end);

    }

}
