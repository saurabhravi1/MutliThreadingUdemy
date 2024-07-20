package com.returningvalues;

import java.util.concurrent.TimeUnit;

public class ValueReturningTaskB implements Runnable{

	private int a;
	private int b;
	private int sum;
	private long sleepTime;
	
	private int instance;
	private static int count;
	private String taskId;
	private ResultListner<Integer> resultListner;
	
	@Override
	public void run() {
		System.out.println("START=========="+Thread.currentThread().getName()+"==========");
		try {
			TimeUnit.MILLISECONDS.sleep(sleepTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		sum=a+b;
		resultListner.notifyResult(sum);
		System.out.println("END=========="+Thread.currentThread().getName()+"==========");
		
		
	}

	public ValueReturningTaskB(int a, int b, long sleepTime, ResultListner<Integer> resultListner) {
		super();
		this.a = a;
		this.b = b;
		this.sleepTime = sleepTime;
		instance=++count;
		this.taskId="ValueReturningTaskA-"+instance;
		this.resultListner=resultListner;
		Thread.currentThread().setName(taskId);
		
	}

}
