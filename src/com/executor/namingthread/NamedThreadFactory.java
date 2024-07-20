package com.executor.namingthread;

import java.util.concurrent.ThreadFactory;

public class NamedThreadFactory implements ThreadFactory{
	private static int instanceNumber;
	private static String name="PoolWorker";
	@Override
	public Thread newThread(Runnable r) {
		Thread t = new Thread(r);
		t.setName(name+(++instanceNumber));
		return t;
	}
	 
}
