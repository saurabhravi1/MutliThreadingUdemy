package com.returningvalues;

import java.util.ArrayList;
import java.util.List;

public class ReturningValuesFirstTechnique {

	public static void main(String[] args) {
		String currentThreadName = Thread.currentThread().getName();
		System.out.println("[" + currentThreadName + "] Main thread starts here...");
		
		List<ValueReturningTaskA> list = new ArrayList<>();
		for(int i=0;i<3;i++) {
			list.add(new ValueReturningTaskA(i+1, i+2, i*1000));
		}
		
		list.stream().forEach(t->new Thread(t).start());
		
		list.stream().forEach(t->System.out.println("Result:"+t.getSum()));
		
		
		System.out.println("[" + currentThreadName + "] Main thread ends here...");
	}

}
