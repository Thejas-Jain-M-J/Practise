package com.practice.stack;

import java.util.Arrays;
import java.util.Stack;

public class NGE_With_Distance {
    static int[] nums = { 71, 90, 76, 69, 70, 50, 78, 80 };

    static int[] result = new int[nums.length];
    static Stack<Integer> stk = new Stack<>();

    public static void main(String[] args) {
        Arrays.fill(result, 0);

        for (int i = 0; i < nums.length; i++) {
            while (!stk.isEmpty() && nums[stk.peek()] < nums[i]) {

                int pop = stk.pop();
                result[pop] = i - pop;
            }
            stk.push(i);
        }

        for (int a : result) {
            System.out.print(a + " ");
        }

        // o/p: 1, 0, 4, 1, 2, 1, 1, 0
    }

}
