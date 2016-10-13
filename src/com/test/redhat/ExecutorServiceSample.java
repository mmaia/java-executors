package com.test.redhat;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

/**
 * This class demonstrates the most common case of executor's implementation - ThreadPool
 */
public class ExecutorServiceSample {

    public static void main(String[] args) {
        System.out.println("entering ExecutorServiceSample - main, thread: " + Thread.currentThread().getName());
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        executorService
                .execute(new Runnable() {
                    public void run() {
                        System.out.println("Asynchronous task, thread: " + Thread.currentThread().getName());
                    }
                });
        System.out.println("exiting ExecutorServiceSample - main, thread: " + Thread.currentThread().getName());
        executorService.shutdown();
    }
}
