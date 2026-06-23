package masterClass.MultiThreading.course.deadlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLockExample {

	Lock lock1 = new ReentrantLock(true);
	Lock lock2 = new ReentrantLock(true);
	
	public void worker1() {
		lock1.lock();
		System.out.println("Worker 1 acquire the lock 1");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lock2.lock();
		System.out.println("Worker 1 acquire the lock 2");
		lock1.unlock();
		lock2.unlock();
		
	}
	public void worker2() {
		lock2.lock();
		System.out.println("Worker 2 acquire the lock 2");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lock1.lock();
		System.out.println("Worker 2 acquire the lock 1");
		lock1.unlock();
		lock2.unlock();
		
	}
	
	public static void main(String[] args) {
		DeadLockExample dl = new DeadLockExample();
		new Thread(dl::worker1).start();
		new Thread(dl::worker2).start();
		
	}
	
	
}
