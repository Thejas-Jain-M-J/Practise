package com.practice.multithreading;

/**
 * print numbers from 1 to 100. using 10 thread. 10 threads should print
 * alternatively.
 */
public class NumberPrinter {
    private int currentNumber = 1;
    private int maxNumber;
    private int threadCount;
    private int turn = 0; // This will keep track of which thread's turn it is to print

    public NumberPrinter(int maxNumber, int threadCount) {
        this.maxNumber = maxNumber;
        this.threadCount = threadCount;
    }

    public void printNumbers() {
        for (int i = 0; i < threadCount; i++) {
            final int threadId = i;
            System.out.println("i " + i);
            /*
             * Here what happening first main thread creates 10 threads, then only it giving
             * chances to other threads to execute.
             */

            new Thread(() -> {
                while (currentNumber <= maxNumber) {

                    synchronized (this) {
                        while (turn != threadId) {
                            try {
                                wait();
                            } catch (Exception e) {

                            }
                        }

                        if (currentNumber <= maxNumber) {
                            System.out.println("Thread ID:" + threadId + " " + currentNumber++);
                            turn++;
                            turn = turn % threadCount;
                            notifyAll();
                        }
                    }
                }

            }).start();
            System.out.println("created");
        }
    }

    public static void main(String[] args) {
        int n = 100; // Number of numbers to print
        int m = 10; // Number of threads
        NumberPrinter printer = new NumberPrinter(n, m);
        printer.printNumbers();
    }
}
