package com.dan.restone.practice.utils.multi_threading.thread_creation;

public class MyAnonymousClass {

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("omg anonymous class, so mysterious!");
            }
        });

        thread.start();
    }
}
