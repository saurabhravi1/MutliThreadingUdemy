package com.future.learning;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class FutureLearning {

	public static void main(String[] args) {
		
		FutureTask<String> fx = new FutureTask<>(new Task(),"");
		//fx.run();
		
		FutureTask<String> futureTask1 = new FutureTask<>(new Task(),"futureTask1");
		FutureTask<String> futureTask2 = new FutureTask<>(new Task(),"futureTask2");
		ExecutorService ex = Executors.newFixedThreadPool(2);
		Future<?> future1 = ex.submit(futureTask1);
		Future<?> future2 = ex.submit(futureTask2);
		
		while(true) {
			try {
				if(futureTask1.isDone() && futureTask2.isDone()){
					System.out.println("Done");
					//shut down executor service
					ex.shutdown();
					return;
				}else {
					try {
						System.out.println(Thread.currentThread().getName()+": waiting");
						TimeUnit.SECONDS.sleep(2);
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
					
				}
				
				
			} catch (Exception e) {
				e.printStackTrace();
			
			}
		}
		
	}

}

class Task implements Runnable{
	
	public String call() {
		try {
			System.out.println(Thread.currentThread().getName()+": start");
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+": end");
		return Thread.currentThread().getName();
	}
	
	
	public void run() {
		try {
			System.out.println(Thread.currentThread().getName()+": start");
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+": end");
		
	}
}
