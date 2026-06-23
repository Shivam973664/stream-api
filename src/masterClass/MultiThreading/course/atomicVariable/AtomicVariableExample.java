package masterClass.MultiThreading.course.atomicVariable;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicVariableExample {

	
//	atomic variables uses low level synchronization to maintain the states
//	we don't need to depend on synchronized block
	private AtomicInteger counter= new AtomicInteger(0);
//	private AtomicInteger counter= 0; compile time error
	
	public void increment() {
//		this.counter.addAndGet(1); work fine
		this.counter.getAndIncrement();
	}
	
	
	public static void main(String[] args) {
		AtomicVariableExample atomic= new AtomicVariableExample();
		Thread t1 = new Thread(()->{
			for(int i=0;i<10000;i++) {
				atomic.increment();
			}
		});
		Thread t2 = new Thread(()->{
			for(int i=0;i<10000;i++) {
				atomic.increment();
			}
		});
		t1.start();
		t2.start();
		
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(atomic.counter);
	}
}
