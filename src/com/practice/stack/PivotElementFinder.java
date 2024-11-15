package com.practice.stack;

import java.util.Arrays;

public class PivotElementFinder {

    public static int findPivot(int[] arr) {
        int n = arr.length;
        if (n == 0) return -1;

        boolean[] leftAscend = new boolean[n];
        boolean[] rightDescend = new boolean[n];
        boolean[] leftDescend = new boolean[n];
        boolean[] rightAscend = new boolean[n];

        // Fill leftAscend
        leftAscend[0] = false;
        for (int i = 1; i < n; i++) {
            leftAscend[i] =  (arr[i] >= arr[i - 1]);
        }

        // Fill rightDescend
        rightDescend[n - 1] = false;
        for (int i = n - 2; i >= 0; i--) {
            rightDescend[i] =  (arr[i] >= arr[i + 1]);
        }

        // Fill leftDescend
        leftDescend[0] = false;
        for (int i = 1; i < n; i++) {
            leftDescend[i] =  (arr[i] <= arr[i - 1]);
        }

        // Fill rightAscend
        rightAscend[n - 1] = false;
        for (int i = n - 2; i >= 0; i--) {
            rightAscend[i] =  (arr[i] <= arr[i + 1]);
        }

        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("Left Ascend: " + Arrays.toString(leftAscend));
        System.out.println("Right Descend: " + Arrays.toString(rightDescend));
        System.out.println("Left Descend: " + Arrays.toString(leftDescend));
        System.out.println("Right Ascend: " + Arrays.toString(rightAscend));
        // Check each element to see if it's a pivot
        for (int i = 0; i < n; i++) {
            if ((leftAscend[i] && rightDescend[i]) || (leftDescend[i] && rightAscend[i])) {
                return arr[i];
            }
        }

        return -1; // No pivot element found
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {5, 4, 3, 2, 1};
        int[] arr3 = {5, 4, 1, 2, 3};
        int[] arr4 = {1, 2, 5, 4, 3};

        System.out.println(findPivot(arr1)); // Output: -1
        System.out.println(findPivot(arr2)); // Output: -1
        System.out.println(findPivot(arr3)); // Output: 1
        System.out.println(findPivot(arr4)); // Output: 5
    }
}

