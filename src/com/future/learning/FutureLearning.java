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
		
		FutureTask<String> fx = new FutureTask<>(new Task());
		fx.run();
		
		FutureTask<String> futureTask1 = new FutureTask<>(new Task());
		FutureTask<String> futureTask2 = new FutureTask<>(new Task());
		ExecutorService ex = Executors.newFixedThreadPool(2);
		Future<String> future1 = ex.submit(new Task());
		Future<String> future2 = ex.submit(new Task());
		
		while(true) {
			try {
				if(future1.isDone() && future2.isDone()){
					System.out.println("Done");
					//shut down executor service
					ex.shutdown();
					return;
				}else {
					System.out.println("waiting");
				}
				
				if(!future1.isDone()){
				//wait indefinitely for future task to complete
				System.out.println("FutureTask1 output="+futureTask1.get());
				}
				
				System.out.println("Waiting for FutureTask2 to complete");
				String s = future2.get(200L, TimeUnit.MILLISECONDS);
				if(s !=null){
					System.out.println("FutureTask2 output=");
				}
			} catch (InterruptedException | ExecutionException | TimeoutException e) {
				e.printStackTrace();
			
			}
		}
		
	}

}

class Task implements Callable<String>{
	
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
	
}
