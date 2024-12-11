package com.devSense.multithreading.atomicity;


class SharedCounter {

    private int count;

    public SharedCounter(int count) {
        this.count = count;
    }

    public SharedCounter() {

    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void increment() {
        count++;
    }
}

public class Atomic {

    public static void main(String[] args) {

        SharedCounter sharedCounter = new SharedCounter();

        new Thread(() -> {
            System.out.println("Thread 1 started");
            for (int i = 0; i < 50000; i++){
                sharedCounter.increment();
            }
//            Thread.sleep(1000);
            System.out.println("Thread 1 Completed");
        }).start();


        new Thread(() -> {
            System.out.println("Thread 2 started");
            for (int i = 0; i < 50000; i++){
                sharedCounter.increment();
            }
//            Thread.sleep(1000);
            System.out.println("Thread 2 Completed");
        }).start();

        System.out.println("Final Count is : " + sharedCounter.getCount());
    }
}
