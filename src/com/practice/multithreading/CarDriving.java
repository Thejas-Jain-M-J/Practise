package com.practice.multithreading;
class Car {
    private int currentDriverId = 1; // Keeps track of the driver whose turn it is

    public synchronized void drive(int driverId) {
        while (driverId != currentDriverId) {
            if(currentDriverId == 2)
                System.out.println("yes");
            try {
                wait(); // Wait if it's not this driver's turn
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        // Simulate driving
        System.out.println("Driver " + driverId + " is driving the car.");
        try {
            Thread.sleep(2000); // Simulate driving for 10 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Driver " + driverId + " has finished driving the car.");
        
        
        // Move to the next driver
        currentDriverId++;
      
        notifyAll(); // Notify all waiting threads
    }
}

class Driver implements Runnable {
    private Car car;
    private int driverId;

    public Driver(Car car, int driverId) {
        this.car = car;
        this.driverId = driverId;
    }

    @Override
    public void run() {
        car.drive(driverId);
    }
}

public class CarDriving {
    public static void main(String[] args) {
        Car car = new Car();
        Thread[] drivers = new Thread[5];

        // Create and start driver threads
        for (int i = 0; i < 5; i++) {
            drivers[i] = new Thread(new Driver(car, i + 1));
            drivers[i].start();
        }

        // // Wait for all driver threads to finish
        // for (int i = 0; i < 5; i++) {
        //     try {
        //         drivers[i].join();
        //     } catch (InterruptedException e) {
        //         e.printStackTrace();
        //     }
        // }

        System.out.println("All drivers have finished driving.");
    }
}


