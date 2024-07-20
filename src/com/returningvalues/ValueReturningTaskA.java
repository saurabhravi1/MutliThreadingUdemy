package com.returningvalues;

import java.util.concurrent.TimeUnit;

public class ValueReturningTaskA implements Runnable{

	private int a;
	private int b;
	private int sum;
	private long sleepTime;
	
	private int instance;
	private static int count;
	private String taskId;
	
	private volatile boolean done=false;
	
	
	@Override
	public void run() {
		System.out.println("START=========="+Thread.currentThread().getName()+"==========");
		try {
			TimeUnit.MILLISECONDS.sleep(sleepTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		sum=a+b;
		done=true;
		System.out.println("END=========="+Thread.currentThread().getName()+"==========");
		synchronized (this) {
			System.out.println("NOTIFY=========="+Thread.currentThread().getName()+"==========");
			this.notify();			
			
		}
		
	}


	public ValueReturningTaskA(int a, int b, long sleepTime) {
		super();
		this.a = a;
		this.b = b;
		this.sleepTime = sleepTime;
		instance=++count;
		taskId="ValueReturningTaskA-"+instance;
		
	}


	public int getSum() {
		
		synchronized (this) {
			if(!done) {
				try {
					System.out.println("WAIT=========="+Thread.currentThread().getName()+"==========");
					this.wait();					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
			}
		}
		
		return sum;
	}
	
	

}
