package com.practice.stack;

import java.util.Arrays;

/**
 * Problem Statement-This method should return an integer array with two elements that 
 * correctly identifies thelocation of the longestuniform substring within the input string.
 *  The first element of the array should be thestarting index of the longestsubstring and 
 * the second element should be the length.input: “abbbccda" the longest uniform substring 
 * is “bbb” (which starts at index 1 and is 3characters. Test Cases –
 * Input :aabbbbbCdAA
 * Output – [2,5]
 */
public class LongestUniformSubstring {

    public static void main(String[] args) {
        
        int[] arr = new int[2];
        String str = "aaaCdAAAAA";
        int startIndex = 0;
        int count = 1;
        int maxCount = 0;
        int i;
        for( i=1;i<str.length();i++)
        {
            if(str.charAt(i) == str.charAt(i-1))
            {
                count++;
            }else{
                if(count>maxCount)
                {
                    maxCount = count;
                    count = 1;
                    arr[0] = startIndex;
                    arr[1] = i-1;
                    startIndex = i;
                }else{
                    startIndex = i;
                }
            }
        }

        if(count>maxCount)
        {
            arr[0] = startIndex;
            arr[1] = i-1;
        }

        System.out.println(Arrays.toString(arr));
    }

}
