package masterClass.MultiThreading.course.lockWait;

import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ExampleLogic{
	private int []arr;
	private int capacity;
	private int count;
	private int head = 0;
	private int tail = 0;
	private final Lock lock = new ReentrantLock();
	private final Condition full = lock.newCondition();
	private final Condition empty = lock.newCondition();
	public ExampleLogic(int []arr,int capacity) {
		this.arr = arr;
		this.capacity= capacity;
		count=0;
	}
//	public 
	public void produce(int element) throws InterruptedException {
		try {
			lock.lock();
			while(count==capacity) {
				System.out.println("Queue is full please . production is stoped");
				full.await();
			}
			Thread.sleep(1000);
			tail= (tail+1)% capacity;
			arr[tail] = element;
			
			System.out.println("Element produced succesfully: " + element);
			count++;
			empty.signal();
			
		}finally {
			lock.unlock();
		}
	}
	
	public void consume() throws InterruptedException {
		try {
			lock.lock();
			while(count==0) {
				System.out.println("Queue is empty . Consumption is stoped ");
				empty.await();
			}
			Thread.sleep(1000);
			System.out.println("Consumed Element : " + arr[tail]);
			arr[head]=0;
			head= (head+1)%capacity;
			count--;
			full.signal();
			
		}finally {
			lock.unlock();
		}
	}
	
	
}


public class ProducerConsumerGPT {
	
	public static void main(String[] args) {
		ExampleLogic examplLogic = new ExampleLogic(new int[5],5);
		Thread t1 = new Thread(()->{
			while(true) {
				try {
					examplLogic.produce(new Random().nextInt());
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		Thread t2 = new Thread(()->{
			while(true) {
				try {
					examplLogic.consume();
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		t1.start();
		t2.start();
	}
	
	
	
}
