package com.executor.namingthread;

import java.util.concurrent.TimeUnit;

public class NamingThreadWhileCreation {

	public static void main(String[] args) {
		String currentThreadName = Thread.currentThread().getName();
		System.out.println("Main thread["+currentThreadName+"] starts here....");
		
		Thread t1 = new Thread(new LoopTaskC(),"Worker 1");
		Thread t2 = new Thread(new LoopTaskC());
		
		
		t1.start();
		t2.start();
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t2.setName("Worker 2");
		System.out.println("Main thread["+currentThreadName+"] ends here....");

	}

}
