package com.deamon;

import java.util.concurrent.ThreadFactory;

import com.executor.namingthread.NamedThreadFactory;

public class NamedDeamonThreadFactory extends NamedThreadFactory{
	private static int instanceNumber;

	
	@Override
	public Thread newThread(Runnable r) {
		Thread t = super.newThread(r);
		if(++instanceNumber%2==0)
			t.setDaemon(true);
		return t;
	}
	 
}
