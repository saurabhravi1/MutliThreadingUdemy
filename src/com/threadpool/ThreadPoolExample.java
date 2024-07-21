package com.threadpool;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/**
 * 
 * @author DevilJin
 In Java, a thread pool is a group of threads that are created and managed by the Java Runtime Environment (JRE) to execute tasks concurrently. Thread pools are useful when you need to perform multiple tasks simultaneously, and creating a new thread for each task would be inefficient.

Why Use Thread Pools?

Improved Performance: Creating a new thread for each task can be expensive in terms of resources and time. Thread pools allow you to reuse existing threads, reducing the overhead of thread creation and termination.
Better Resource Utilization: Thread pools help to optimize resource utilization by limiting the number of threads created, which can prevent resource starvation and improve system stability.
Simplified Code: Thread pools provide a simpler way to manage threads, as you don't need to worry about creating, starting, and managing individual threads.
Java Thread Pool Implementations

Java provides several thread pool implementations, including:

java.util.concurrent.Executor: A basic interface for executing tasks asynchronously.
java.util.concurrent.ExecutorService: An interface that extends Executor and provides additional methods for managing the thread pool.
java.util.concurrent.ThreadPoolExecutor: A concrete implementation of ExecutorService that provides a flexible thread pool implementation.

Configuring Thread Pool Parameters

When creating a thread pool, you can configure various parameters to control its behavior, such as:

Core pool size: The minimum number of threads to maintain in the pool.
Maximum pool size: The maximum number of threads to allow in the pool.
Keep-alive time: The time to wait before terminating idle threads.
Work queue: The queue used to store tasks submitted to the thread pool.
 */
public class ThreadPoolExample {
    public static void main(String[] args) {
        // Create a thread pool with 5 threads
        ExecutorService threadPool = new ThreadPoolExecutor(5, 10, 60L, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10));

        // Submit tasks to the thread pool
        threadPool.execute(new Runnable() {
            public void run() {
                System.out.println("Task 1 executed");
            }
        });

        threadPool.execute(new Runnable() {
            public void run() {
                System.out.println("Task 2 executed");
            }
        });

        // Shut down the thread pool
        threadPool.shutdown();
    }
}