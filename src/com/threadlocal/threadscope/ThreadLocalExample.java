package com.threadlocal.threadscope;
/**
 * 
 * @author DevilJin
 * 
 * ThreadLocal:

There are 4 types of scopes in java:
private: data is available upto the present class only.
<default>: Data is available upto the present package only.
protected: Data is available upto the present package and child classes of other packages.
public: Data is available throughout the application.

I want to make available data upto all resources which are accessed by a particular thread, for this we have to define a new scope , that is called as ‘ThreadScope’.

If we want to define a ‘ThreadScope’ for the data, Java has provided a predefined class as ‘java.lang.ThreadLocal’.

Method Provided by ThreadLoca:
public void set(Object object): To set data to threadscope
public Object get(): To get Data for threadscope
public void remove(): To remove data from thread scope
public void initialValues: It will provide the initial values in threadscope. It will be called automatically when we try to access the data without setting the data.

 *
 */
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
