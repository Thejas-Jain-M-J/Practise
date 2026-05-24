package com.practise.test.RaceWinner;

import java.util.ArrayList;
import java.util.List;

/**
 * This program prints a matrix in a specific pattern:
 * 1  2  3  4  5
 * 11 12 13 14 15
 * 21 22 23 24 25
 * 16 17 18 19 20
 * 6  7  8  9  10
 */
public class Matrix {


    public static void main(String[] args) {
        int n=5;
      for (int row = 0; row < n; row += 2) {
            int start = row * n + 1;
            for (int j = 0; j < n; j++) {
                System.out.printf("%-4d", start + j);
            }
            System.out.println();
        }

        // Then print odd rows in reverse: ..., 3, 1
        int lastOdd = (n % 2 == 0) ? (n - 1) : (n - 2);

        for (int row = lastOdd; row >= 1; row -= 2) {
            int start = row * n + 1;
            for (int j = 0; j < n; j++) {
                System.out.printf("%-4d", start + j);
            }
            System.out.println();
        }
    }
}
