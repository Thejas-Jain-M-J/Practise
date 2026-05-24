package com.practice.stack;

public class IndianNumberToWords {

    private static final String[] units = {
            "", "One", "Two", "Three", "Four", "Five",
            "Six", "Seven", "Eight", "Nine", "Ten",
            "Eleven", "Twelve", "Thirteen", "Fourteen",
            "Fifteen", "Sixteen", "Seventeen",
            "Eighteen", "Nineteen"
    };

    private static final String[] tens = {
            "", "", "Twenty", "Thirty", "Forty",
            "Fifty", "Sixty", "Seventy",
            "Eighty", "Ninety"
    };

    private static final String[] multipliers = {
            "", "Thousand", "Lakh", "Crore", "Arab", "Kharab"
    };

    public static String numberToWords(long num) {

        if (num == 0) return "Zero";

        StringBuilder result = new StringBuilder();

        // Handle last 3 digits separately
        int lastThree = (int)(num % 1000);
        if (lastThree != 0) {
            result.insert(0, convertBelowThousand(lastThree));
        }

        num /= 1000;
        int group = 1;

        // Now process 2-digit groups
        while (num > 0) {
            int twoDigits = (int)(num % 100);

            if (twoDigits != 0) {
                String groupWord = convertBelowHundred(twoDigits)
                        + multipliers[group] + " ";
                result.insert(0, groupWord);
            }

            num /= 100;
            group++;
        }

        return result.toString().trim();
    }

    private static String convertBelowThousand(int num) {

        StringBuilder sb = new StringBuilder();

        if (num >= 100) {
            sb.append(units[num / 100])
              .append(" Hundred ");
            num %= 100;
        }

        if (num > 0) {
            sb.append(convertBelowHundred(num));
        }

        return sb.toString();
    }

    private static String convertBelowHundred(int num) {

        if (num < 20) {
            return units[num] + " ";
        }

        return tens[num / 10] + " " +
                units[num % 10] + " ";
    }

    public static void main(String[] args) {
        System.out.println(numberToWords(12345678));
    }
}
