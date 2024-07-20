package com.returningvalues;

public class ResultObserver implements ResultListner<Integer> {

	@Override
	public void notifyResult(Integer sum) {
		System.out.println("notifyResult : "+sum);		
	}

}
