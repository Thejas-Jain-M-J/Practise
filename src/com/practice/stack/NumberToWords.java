package com.practice.stack;

public class NumberToWords {
    static String convertToWords(int n) {
        if (n == 0) 
            return "Zero";
        
        // Words for numbers 0 to 19
        String[] units = {
            "",        "One",       "Two",      "Three",
            "Four",    "Five",      "Six",      "Seven",
            "Eight",   "Nine",      "Ten",      "Eleven",
            "Twelve",  "Thirteen",  "Fourteen", "Fifteen",
            "Sixteen", "Seventeen", "Eighteen", "Nineteen"
        };

        // Words for numbers multiple of 10
        String[] tens = {
            "",     "",     "Twenty",  "Thirty", "Forty",
            "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" 
        };

        String[] multiplier =
                    {"", "Thousand", "Million", "Billion"};

        String res = "";
        int group = 0;

        // Process number in group of 1000s
        while (n > 0) {
            if (n % 1000 != 0) {

                int value = n % 1000;
                String temp = "";

                // Handle 3 digit number
                if (value >= 100) {
                    temp = units[value / 100] + " Hundred ";
                    value %= 100;
                }

                // Handle 2 digit number
                if (value >= 20) {
                    temp += tens[value / 10] + " ";
                    value %= 10;
                }

                // Handle unit number
                if (value > 0) {
                    temp += units[value] + " ";
                }

                // Add the multiplier according to the group
                temp += multiplier[group] + " ";
                
                // Add this group result to overall result
                res = temp + res;
            }
            n /= 1000;
            group++;
        }
        
        // Remove trailing space
        return res.trim();
    }

    public static void main(String[] args) {
        int n = 2147483610;
        System.out.println(convertToWords(n));
    }
}
