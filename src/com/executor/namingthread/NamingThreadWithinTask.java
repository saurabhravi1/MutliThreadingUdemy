package com.executor.namingthread;

public class NamingThreadWithinTask {

	public static void main(String[] args) {
		String currentThreadName = Thread.currentThread().getName();
		System.out.println("Main thread["+currentThreadName+"] starts here....");
		
		Thread t1 = new Thread(new LoopTaskB());
		Thread t2 = new Thread(new LoopTaskB());
		t1.start();
		t2.start();
		
		System.out.println("Main thread["+currentThreadName+"] ends here....");

	}

}
