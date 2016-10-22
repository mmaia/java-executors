package com.test.mmaia;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * This class demonstrates the most common case of executor's implementation that creates a single thread executor.
 * The verbose System.out.println calls in this class helps to understand that the executor service will be executed
 * in a new thread that was created with the helper factory method Executors.newSingleThreadExecutor
 * @see <a href="http://docs.oracle.com/javase/8/docs/api/java/util/concurrent/Executors.html">Executors<a/>
 */
public class ExecutorServiceSample {

    public static void main(String[] args) {
        System.out.println("entering ExecutorServiceSample - main, thread: " + Thread.currentThread().getName());
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        executorService
                .execute(() -> System.out.println("Asynchronous task, thread: " + Thread.currentThread().getName()));

        System.out.println("exiting ExecutorServiceSample - main, thread: " + Thread.currentThread().getName());
        executorService.shutdown();
    }
}
