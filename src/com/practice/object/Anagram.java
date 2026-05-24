package com.practice.object;

import java.util.Arrays;
import java.util.*;

public class Anagram {
    
       public static void main(String[] args) {
        String[] arr = {"CAT","ACT","EAT","ATE"};
        
        HashMap<String, List<String>> hashMap = new HashMap<>();
        for(String str : arr) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);
            
            if(!hashMap.containsKey(sortedStr)) {
                hashMap.put(sortedStr, new ArrayList<>());
            }
            hashMap.get(sortedStr).add(str);
        }
        System.out.println("Anagrams: " + hashMap.values());

    }

}
