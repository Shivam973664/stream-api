package masterClass.MultiThreading.course.lockWait;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Example{
	Lock lock =new  ReentrantLock(false);
	Condition condition = lock.newCondition();
	
	
	public void producer() throws InterruptedException {
		try {
			lock.lock();
			System.out.println("Producer Begining ");
			condition.await();
			System.out.println("Producer Ending ");
		}finally {
			lock.unlock();
		}
	}
	
	public void consumer() throws InterruptedException {
		try {
			lock.lock();
			System.out.println("consumer Begining ");
			condition.signal();
			System.out.println("consumer Ending ");
		}finally {
			lock.unlock();
		}
	}
}



public class ProducerConsumerLock {

	public static void main(String[] args) {
		Example instance = new Example();
		Thread t1 = new Thread(()->{
			try {
				instance.producer();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		Thread t2 = new Thread(()->{
			try {
				instance.consumer();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		t1.start();
		t2.start();
//		System.out.println("Ends here");
		
	}
}
