package com.producer.consumer.problem;

/**
 * 
 * @author DevilJin
In Producer Consumer problem, Both producer and consumer are two threads, where producer has to product an item and consumer
has to consume an item. It has to perform upto an infinite no of times.

Producer should not produce am item untill consuming previous item.
Logic: 
boolean flag: If flag is true then producer must be producing an item and consumer must be in waiting state.
				producer: 
					a) Producing an item
					b) Giving turn to consumer [flag = false]
					c) Notifying consumer to consume
					d) Going to waiting state
				consumer:
					waiting state
			  If flag is false then consumer must be consuming an item and pruducer must be in waiting state.
				producer:
					waiting state
				consumer :
					a) consumer and item
					b) giving turn to producer[flag = true]
					c) notifying producer to produce
					d) Going to waiting state
int count : It will manage the item count.
 *
 */

public class ProducerConsumerExample {

	public static void main(String[] args) {
		A a = new A();
		new ProducerThread(a).start();
		new ConsumerThread(a).start();
	}
}
class A{
	boolean flag = true;
	int count=0;
	
	public synchronized void produce() {
		
		try {
			while(true) {
				if(flag==true) {
					System.out.println("Produced Item"+(++count));
					flag=false;
					System.out.println(Thread.currentThread().getName()+":notify");
					notify();
					System.out.println(Thread.currentThread().getName()+":wait");
					wait();
				}else {
					System.out.println(Thread.currentThread().getName()+":wait");
					wait();
				}
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public synchronized void consumer() {
		try {
			while(true) {
				if(flag==false) {
					System.out.println("Consumer Item"+(--count));		
					flag=true;
					System.out.println(Thread.currentThread().getName()+":notify");
					notify();
					System.out.println(Thread.currentThread().getName()+":wait");
					wait();
				}else {
					System.out.println(Thread.currentThread().getName()+":wait");
					wait();
				}
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
class ProducerThread extends Thread{	
	A a;	
	ProducerThread(A a){
		this.a=a;
		super.setName("ProducerThread");
	}	
	public void run() {
		a.produce();
	}	
}
class ConsumerThread extends Thread{	
	A a;	
	ConsumerThread(A a){
		this.a=a;
		super.setName("ConsumerThread");
	}	
	public void run() {
		a.consumer();
	}	
}