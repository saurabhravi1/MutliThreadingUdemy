package com.deamon;

import java.util.concurrent.TimeUnit;

public class LoopTaskC implements Runnable{
	private static int count = 0;
	private int instanceNumber;
	private String taskId;
	private int sleep;
	@Override
	public void run() {
		
		String currentThreadName = Thread.currentThread().getName();
		String threadType = Thread.currentThread().isDaemon()?"DEMON":"USER";
		System.out.println("#######"+currentThreadName+threadType+" TASK ID "+taskId+"STARTING######");
		try {
			TimeUnit.SECONDS.sleep(sleep);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("#######"+Thread.currentThread().getName()+threadType+"TASK ID "+taskId+" ENDING######");

	}
	
	public LoopTaskC(int sleep) {
		this.instanceNumber=++count;
		this.taskId = "LoopTaskB" + instanceNumber; 
		this.sleep=sleep;
	}
}
