package com.practice.lambda.Optional;

import java.util.Optional;

public class Java {

    public static void main(String[] args) {
        

        Optional<String> empty = Optional.empty(); //empty optional

        Optional<String> name = Optional.of("John");  // Throws NullPointerException if argument is null.

        Optional<String> nullableName = Optional.ofNullable(null);  // Works with null values.


        if (name.isPresent()) {
            System.out.println(name.get());  // Prints "John" if present
        }

        
        String result = nullableName.orElse("Default Name");  // Returns "Default Name" if empty


        String result1 = nullableName.orElseGet(() -> "Generated Default");

        /**
         * If not used isPresent() before using optional then if value is null or empty then
         * we will get NoSuchElementException. So it's good to use isPresent.
         */

    }
}
