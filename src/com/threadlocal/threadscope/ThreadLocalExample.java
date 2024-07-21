package com.threadlocal.threadscope;

public class ThreadLocalExample {

	public static void main(String[] args) {
		A a = new A();
		Thread t1 = new Thread1(a);
		Thread t2 = new Thread2(a);
		t1.setName("t1");
		t2.setName("t2");
		t1.start();
		t2.start();		
	}
}
class ThreadScope extends ThreadLocal<String>{
	@Override
	protected String initialValue() {//overriding this to provide default values in case values or not available/not set 
		//before calling getMethod
		return "Value not available in this scope";
	}
}

class A{
	public void m1() {
		System.out.println("m1() "+Thread.currentThread().getName()+" scope"+Thread1.threadScope.get());
		System.out.println("m1() t2 Scope"+Thread2.threadScope.get());//Null/Initialized value because thread2 scope is 
		//not availabel for m1, because Thread2 is not accessing m1
	}
	public void m2() {
		System.out.println("m2() "+Thread.currentThread().getName()+" scope"+Thread2.threadScope.get());
		System.out.println("m2() t1 Scope"+Thread1.threadScope.get());
		//Null/Initialized value because thread1 scope is 
				//not available for m2, because Thread2 is not accessing m2
	}
}
class Thread1 extends Thread{
	static ThreadScope threadScope = new ThreadScope();
	A a;
	Thread1(A a){
		this.a=a;
	}
	
	public void run() {
		threadScope.set("AAA");
		a.m1();
	}
}

class Thread2 extends Thread{
	static ThreadScope threadScope = new ThreadScope();
	A a;
	Thread2(A a){
		this.a=a;
	}
	
	public void run() {
		threadScope.set("BBB");
		a.m2();
	}
}