package com.dan.restone.practice.utils.multi_threading;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadLifecycle extends Thread {

    @Override
    public void run() {
        System.out.println("Thread is running and going to sleep for 2 seconds");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadLifecycle thread = new ThreadLifecycle();
        log.info("thread state after creation: " + thread.getState());

        thread.start();
        log.info("Thread state after was started: " + thread.getState());

        Thread.sleep(2000);
        log.info("Thread state while sleeping: " + thread.getState());

    }
}
