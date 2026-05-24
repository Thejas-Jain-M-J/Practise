package com.practice.stack;
import java.util.*;
import java.util.stream.*;

public class FindPrefix {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("abcd", "abcc", "abee");

        String prefix = IntStream.rangeClosed(1, list.stream().mapToInt(String::length).min().orElse(0))
                .mapToObj(i -> list.get(0).substring(0, i))
                .takeWhile(pref -> list.stream().allMatch(s -> s.startsWith(pref)))
                .reduce((a, b) -> b)
                .orElse("");

        System.out.println("Common prefix: " + prefix);
    }
}


// import java.util.*;

// public class Main {
//     public static void main(String[] args) {
//         List<String> list = Arrays.asList("abcd", "abcc", "abee");

//         String prefix = findCommonPrefix(list);
//         System.out.println("Common prefix: " + prefix);
//     }

//     public static String findCommonPrefix(List<String> words) {
//         if (words == null || words.isEmpty()) return "";

//         String prefix = words.get(0);

//         for (int i = 1; i < words.size(); i++) {
//             while (words.get(i).indexOf(prefix) != 0) { // check if prefix is at start
//                 prefix = prefix.substring(0, prefix.length() - 1);
//                 if (prefix.isEmpty()) return "";
//             }
//         }
//         return prefix;
//     }
// }
