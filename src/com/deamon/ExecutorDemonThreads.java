package com.deamon;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.executor.fixedthreadpool.LoopTaskA;

public class ExecutorDemonThreads {

	public static void main(String[] args) {
		System.out.println("Main thread starts here......");
		ExecutorService execService = 
				Executors.newFixedThreadPool(6,new NamedDeamonThreadFactory());
//				Executors.newFixedThreadPool(6);
		execService.submit(new LoopTaskC(2));
		execService.submit(new LoopTaskC(4));
		execService.submit(new LoopTaskC(2));
		execService.submit(new LoopTaskC(4));
		
		execService.shutdown();
		
		System.out.println("Main thread ends here......");

	}

}
