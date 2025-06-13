package com.practice.stack;

/**
 * You are given a binary array consisting of 0s and 1s. You are allowed to flip exactly 
 * one subarray, meaning you can change all 0s in that subarray to 1s and all 1s to 0s. 
 * Your task is to find the maximum possible number of 1s in the entire array after 
 * performing exactly one flip.
 * int[] arr = {1,0,1,0,1,1,0,0,1,0,0,0,1,0,1}; 
 * output :  max number of 1s is 11
 * {1,0,1,0,1,1,1,1,0,1,1,1,1,0,1}   flip index = 6-11, flipped window is {1,1,0,1,1,1}
 */
public class SubArrayFlip_SlidingWindow {

    public static void main(String[] args) {
    
        //o/p : 11
        //int[] arr = {1,0,1,0,1,1,0,0,1,0,0,0,1,0,1};

        //o/p: 9
        int[] arr = {1,0,1,0,1,1,0,0,1,0,1,0,1};

        int originalOnes = 0;

        for(int num : arr)
        {
            if(num ==1)
                originalOnes++;
        }

        for(int i=0;i<arr.length;i++)
        {
            arr[i] = arr[i] == 1 ? -1 : 1;
        }

        int maxEnding = 0;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++)
        {
            
            maxEnding = maxEnding+arr[i];
            System.out.println(arr[i] +"    maxEnding "+maxEnding);
            if(maxEnding <= 0)
            maxEnding = 0;
            max= Math.max(max,maxEnding);
        }

  
        System.out.println("max ones is " +(max+originalOnes) );
    }
}
