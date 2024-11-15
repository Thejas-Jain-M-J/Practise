package com.practice.stack;

public class StringToInteger {

    public static int convertStringToInt(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Input string is null or empty");
        }

        int result = 0;
        int startIndex = 0;
        boolean isNegative = false;

        // Check if the number is negative
        if (str.charAt(0) == '-') {
            isNegative = true;
            startIndex = 1; // Start from the next character
        } else if (str.charAt(0) == '+') {
            startIndex = 1; // Skip the '+' sign
        }

        // Convert each character to the corresponding integer
        for (int i = startIndex; i < str.length(); i++) {
            char c = str.charAt(i);

            // Ensure the character is a valid digit
            if (c < '0' || c > '9') {
                throw new IllegalArgumentException("Invalid character found: " + c);
            }

            int digitValue = c - '0';
            result = result * 10 + digitValue;
        }

        // Apply the sign if the number is negative
        return isNegative ? -result : result;
    }

    public static void main(String[] args) {
        System.out.println(convertStringToInt("1234"));   // Output: 1234
        System.out.println(convertStringToInt("-1234"));  // Output: -1234
        System.out.println(convertStringToInt("0"));      // Output: 0
        System.out.println(convertStringToInt("+567"));   // Output: 567
    }
}

