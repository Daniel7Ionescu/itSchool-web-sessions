package com.dan.restone.practice.utils.multi_threading.thread_creation;

public class MyRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println("My runnable is running!");
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new MyRunnable());
        thread.start();
    }
}
