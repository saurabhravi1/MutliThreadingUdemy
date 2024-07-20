package com.executor.namingthread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.executor.fixedthreadpool.LoopTaskA;

public class NamingExecutorThreads {

	public static void main(String[] args) {
		System.out.println("Main thread starts here......");
		ExecutorService execService = 
				Executors.newFixedThreadPool(6,new NamedThreadFactory());
//				Executors.newFixedThreadPool(6);
		for(int i=0;i<6;i++) {
			execService.submit(new LoopTaskC());
		}
		execService.shutdown();
		
		System.out.println("Main thread ends here......");

	}

}
