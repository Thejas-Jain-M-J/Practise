package com.practice.multithreading;

public class PrintEvenOdd {

    static printer print = new printer();

    public static void main(String[] args) {

        Thread t11 = new Thread(() -> {
            print.PrintEven();
        });
        t11.setName("Even");
        t11.start();

        Thread t21 = new Thread(() -> {
            print.PrintOdd();
        });
        t21.setName("Odd");
        t21.start();
    }

}

class printer {

    boolean isOdd = false;
    int number = 0;
    int maxNumber = 20;

    void PrintOdd() {
        synchronized (this) {
            while (number < maxNumber) {
                while (number % 2 == 0) {
                    try {
                        wait();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                System.out.println(Thread.currentThread().getName() + "  " + number);
                number++;
                notifyAll();
            }
        }
    }

    void PrintEven() {
        synchronized (this) {
            while (number <= maxNumber) {
                while (number % 2 == 1) {
                    try {
                        wait();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                System.out.println(Thread.currentThread().getName() + "  " + number);
                number++;
                notifyAll();
            }
        }
    }
}
