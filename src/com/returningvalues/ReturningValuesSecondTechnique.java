package com.returningvalues;

import java.util.ArrayList;
import java.util.List;

public class ReturningValuesSecondTechnique {

	public static void main(String[] args) {
		String currentThreadName = Thread.currentThread().getName();
		System.out.println("[" + currentThreadName + "] Main thread starts here...");
		ResultListner<Integer> resultListner = new ResultObserver();
		List<ValueReturningTaskB> list = new ArrayList<>();
		for(int i=0;i<3;i++) {
			list.add(new ValueReturningTaskB(i+1, i+2, i*1000,resultListner));
		}
		
		list.stream().forEach(t->new Thread(t).start());
		
		//list.stream().forEach(t->System.out.println("Result:"+t.getSum()));
		
		
		System.out.println("[" + currentThreadName + "] Main thread ends here...");
	}

}
