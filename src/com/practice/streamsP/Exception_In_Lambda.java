package com.practice.streamsP;

import java.util.function.Consumer;
import java.util.*;

public class Exception_In_Lambda {

    public static void main(String[] args) {

        // List<Integer> integers = Arrays.asList(3, 9,0, 7, 6, 10, 20);
        // integers.forEach(i -> System.out.println(50 / i));

        List<Integer> integers = Arrays.asList(3, 9, 7, 0, 10, 20);
        integers.forEach(i -> {
            try {
                System.out.println(50 / i);
            } catch (ArithmeticException e) {
                System.err.println(
                        "Arithmetic Exception occured : " + e.getMessage());
            }
        });

        /**
         * The use of try-catch solves the problem, but the conciseness of a Lambda Expression 
         * is lost and it’s no longer a small function as it’s supposed to be.
         */
      integers.forEach(lambdaWrapper(i-> System.out.println(50/i)));
      integers.forEach(consumerWrapper(i-> System.out.println(100/i), ArithmeticException.class));
        
    }

    /**
     * This is the example of Handling exception only for dividing integers by 0.
     * @param consumer
     * @return
     */
    static Consumer<Integer> lambdaWrapper(Consumer<Integer> consumer) {
        return i -> {
            try { 
                consumer.accept(i);
            } catch (ArithmeticException e) {
                System.err.println(
                  "Arithmetic Exception occured : " + e.getMessage());
            }
        };
    }

    /**
     * This is the general way to write wrapper. Now this wrapper can be used for any 
     * functionality not only to divide integers by 0.
     * @param <T>
     * @param <T>
     * @param <E>
     * @param <E>
     * @param consumer
     * @param clazz
     * @return
     */
    static  <T, E extends Exception> Consumer<T>
  consumerWrapper(Consumer<T> consumer, Class<E> clazz) {
 
    return i -> {
        try {
            consumer.accept(i);
        } catch (Exception ex) {
            try {
                E exCast = clazz.cast(ex);
                System.err.println(
                  "Exception occured : " + exCast.getMessage());
            } catch (ClassCastException ccEx) {
                throw ex;
            }
        }
    };
}
}
