package com.practice;

import java.io.*;

public class GFG {
    public static void main(String[] args)
    {
        // Number of terms to print
        int n = 10;
        int[] memo = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            System.out.print(fibonacci(i, memo) + " ");
        }
    }

    public static int fibonacci(int n, int[] memo)
    {
    	System.out.println();
    	System.out.println("n "+n);
//        if (memo[n] != 0)
//            return memo[n];
        if (n == 1 || n == 2)
            return 1;
        else {
        	System.out.println("memo[n] "+memo[n]);
            memo[n] = fibonacci(n - 1, memo)
                      + fibonacci(n - 2, memo);
            return memo[n];
        }
    }
}