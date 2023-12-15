package com.dan.restone.practice.utils.multi_threading.thread_creation;

public class ThreadWithLambda {

    public static void main(String[] args) {
        Thread thread = new Thread(() -> System.out.println("Lambda thread threat!"));
        thread.start();
    }
}
