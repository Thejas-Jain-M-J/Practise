package com.practice.stack;

/**
 * encode aaabbc to a3b2c1
 */
public class EncodeString {

    public static void main(String[] args) {
        
        String str  = "aaabbc";
        int count=1;
        StringBuilder strBuilder = new StringBuilder();
        int i;
        if(str.length() == 0)
        {
            System.out.println(0);
            return;
        }
        for( i=1;i<str.length();i++)
        {
            if(str.charAt(i) == str.charAt(i-1))
            {
                count++;
            }else{
                strBuilder.append(str.charAt(i-1)).append(count);
                count = 1;
            }
        }
        strBuilder.append(str.charAt(i-1)).append(count);
        System.out.println("Encode string "+ strBuilder);
    }
}
