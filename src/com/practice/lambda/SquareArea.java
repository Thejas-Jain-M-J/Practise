package com.practice.lambda;

/**
 * InnerSquareArea
 */
@FunctionalInterface
 interface InnerSquareArea {

    double calculateSquareArea(double side);

}
public class SquareArea {

    public static void main(String[] args) {
        InnerSquareArea iarea = (side) -> {
            if(side<1.0)
                return 0.0;
           return side*side;
        };

    double result = iarea.calculateSquareArea(3.0);
    System.out.println("result "+result);
    }
    
    

}
