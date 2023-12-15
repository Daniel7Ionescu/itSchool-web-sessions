package com.dan.restone.practice.utils.multi_threading.thread_creation;

public class MyThread extends Thread{

    @Override
    public void run() {
        System.out.println("My thread is working");
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
    }
}
