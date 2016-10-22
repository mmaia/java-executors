package com.test.mmaia;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * This class demonstrates the  case of executor's implementation that creates a thread pool.
 * The verbose System.out.println calls in this class helps to understand that the executor service will be executed
 * in a new thread that was created with the helper factory method Executors.newFixedThreadPool
 * @see <a href="http://docs.oracle.com/javase/8/docs/api/java/util/concurrent/Executors.html">Executors<a/>
 */
public class ExecutorPoolServiceSample {
    public static void main(String[] args) {
        System.out.println("entering ExecutorPoolServiceSample.main thread: " + Thread.currentThread().getName());
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.execute(() -> {
            System.out.println("This code executes in a new thread from the created pool..." + Thread.currentThread().getName());
            // will block first executor thread for 5 sec.. so next call from the execute will pick up second thread from pool...
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("After slepping for 5 sec this thread will resume... " + Thread.currentThread().getName());
        });

        executorService.execute(() -> System.out.println("This code executes in a new thread from pool " + Thread.currentThread().getName()));

        System.out.println("ExecutorPoolServiceSample.main thread exiting: " + Thread.currentThread().getName());
    }
}
