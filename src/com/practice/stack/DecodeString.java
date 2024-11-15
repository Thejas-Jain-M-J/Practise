package com.practice.stack;

/**
 * decode a3b2c1 to aaabbc
 */
public class DecodeString {

    public static void main(String[] args) {
        String str =  "a3b2c1";
        char c ='0';
        StringBuilder resultString = new StringBuilder();
        for(int i=0;i<str.length();i++)
        {
            if(str.charAt(i) >=48 && str.charAt(i) <= 57 )
            {
                int n = str.charAt(i)- '0';
                for(int j=0;j<n;j++)
                {
                    resultString.append(c);

                }

            }else
            {
                c = (str.charAt(i));
            }
        }
        System.out.println("Decoded String "+resultString);
    }
}
