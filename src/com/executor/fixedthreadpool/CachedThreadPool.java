package com.executor.fixedthreadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.executor.namingthread.LoopTaskC;
import com.executor.namingthread.NamedThreadFactory;

public class CachedThreadPool {

	public static void main(String[] args) throws InterruptedException{
		System.out.println("Main thread starts here......");
		ExecutorService execService = 
				Executors.newCachedThreadPool(new NamedThreadFactory());
		for(int i=0;i<3;i++) {
			execService.submit(new LoopTaskC());
		}
		TimeUnit.SECONDS.sleep(4);
		for(int i=0;i<3;i++) {
			execService.submit(new LoopTaskC());
		}
		execService.shutdown();
		//execService.submit(new LoopTaskA());
		System.out.println("Main thread ends here......");
	}

}
