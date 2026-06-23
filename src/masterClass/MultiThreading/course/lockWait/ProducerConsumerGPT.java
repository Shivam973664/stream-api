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
	private final Condition notFull = lock.newCondition();
	private final Condition notEmpty = lock.newCondition();
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
				System.out.println("Queue is notFull please . production is stoped");
				notFull.await();
			}
			Thread.sleep(1000);
		
			arr[tail] = element;
			tail= (tail+1)% capacity;
			
			System.out.println("Element produced succesnotFully: " + element);
			count++;
			notEmpty.signal();
			
		}finally {
			lock.unlock();
		}
	}
	
	public void consume() throws InterruptedException {
		try {
			lock.lock();
			while(count==0) {
				System.out.println("Queue is notEmpty . Consumption is stoped ");
				notEmpty.await();
			}
			Thread.sleep(1000);
			System.out.println("Consumed Element : " + arr[head]);
			arr[head]=0;
			head= (head+1)%capacity;
			count--;
			notFull.signal();
			
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
