package com.executor.namingthread;

import java.util.concurrent.TimeUnit;

public class LoopTaskC implements Runnable{
	private static int count = 0;
	private int instanceNumber;
	private String taskId;
	@Override
	public void run() {
		
		String currentThreadName = Thread.currentThread().getName();
		System.out.println("#######"+currentThreadName+" TASK ID "+taskId+"STARTING######");
		for(int i=10;i>0;i--) {
			System.out.println(Thread.currentThread().getName()+" TASK - "+taskId+ "VALUE - "+i);
			try {
				TimeUnit.MILLISECONDS.sleep((long) (Math.random()*1000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("#######"+Thread.currentThread().getName()+"TASK ID "+taskId+" ENDING######");

	}
	
	public LoopTaskC() {
		this.instanceNumber=++count;
		this.taskId = "LoopTaskB" + instanceNumber; 
	}
}
