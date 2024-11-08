package com.practice.stack;

public class CaesarCipher {
    // Encrypts text using a shift of s
    public static StringBuffer encrypt(String text, int s) {
        StringBuffer result = new StringBuffer();

        // Traverse through the text
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            // Check if the character is uppercase
            if (Character.isUpperCase(ch)) {
                char encryptedChar = (char) (((int) ch + s - 65) % 26 + 65);
                result.append(encryptedChar);
            }
            // If the character is lowercase
            else {
                char encryptedChar = (char) (((int) ch + s - 97) % 26 + 97);
                result.append(encryptedChar);
            }
        }
        return result;
    }

    // Driver code
    public static void main(String[] args) {
        String text = "ATTACKATONCEZ";
        int s = 4;
        System.out.println("Text : " + text);
        System.out.println("Shift : " + s);
        System.out.println("Cipher: " + encrypt(text, s));
    }
}
