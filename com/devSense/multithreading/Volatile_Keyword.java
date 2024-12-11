package com.devSense.multithreading;

class SharedResource{

    private volatile boolean flag = false ;

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public boolean isFlag() {
        return flag;
    }
}

public class Volatile_Keyword {

    public static void main(String []args) throws Exception{

        SharedResource sharedResource = new SharedResource();

        //Thread1
        new Thread(() -> {
            System.out.println("Thread1 started");
            try {
                System.out.println("Thread1 logic started");
                Thread.sleep(1000);
                System.out.println("Thread1 logic completed");
                sharedResource.setFlag(true);
                System.out.println("Flag set by Thread 1 ");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

        //Thread2
        new Thread(() -> {
            System.out.println("Thread2 started");
            while (!sharedResource.isFlag()){
                //it will run until the flag value is true
//                System.out.println("Inside while in thread 2 waiting for the flag to be set ");
            }
            System.out.println("Thread2 logic completed");
        }).start();

    }
}
