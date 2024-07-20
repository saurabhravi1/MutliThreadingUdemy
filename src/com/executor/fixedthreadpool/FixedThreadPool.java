package com.executor.fixedthreadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPool {

	public static void main(String[] args) {
		System.out.println("Main thread starts here......");
		ExecutorService execService = 
				Executors.newFixedThreadPool(6);
		for(int i=0;i<6;i++) {
			execService.submit(new LoopTaskA());
		}
		execService.shutdown();
		//execService.submit(new LoopTaskA());
		System.out.println("Main thread ends here......");
	}

}
