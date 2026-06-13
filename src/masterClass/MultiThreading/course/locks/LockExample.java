package masterClass.MultiThreading.course.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockExample {

	private static int counter = 0;
//	default value is true
	private static Lock lock = new ReentrantLock(true);

	private static void increment() {
		try {
//1. 	lock.lock();
			lock.lock();
		counter++;
//1.		lock.unlock();
		}finally {
//			it is adviced to unlock the lock here only
			lock.unlock();
		}
	}

	public static void main(String[] args) {
		Thread t1 = new Thread(() -> {
			for(int i=0;i<1000;i++) {
				increment();
			}
		});
		
		Thread t2 = new Thread(() -> {
			for(int i=0;i<1000;i++) {
				increment();
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
		System.out.println("Counter : "+ counter);
		
	}
}
