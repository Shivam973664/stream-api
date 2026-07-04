package masterClass.MultiThreading.course.concurrentCollection;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class ProducerABQ implements Runnable{
	
	private BlockingQueue<Integer> abq;
	
	public ProducerABQ(BlockingQueue<Integer> abq) {
		this.abq = abq;
	}

	@Override
	public void run() {
		int count=1;
		while(true) {
			
			try {
				abq.add(count++);
				Thread.sleep(1000);
				System.out.println("Production of element "+ count + " is completed");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}

class ConsumerABQ implements Runnable{
	
	private BlockingQueue<Integer> abq;
	
	public ConsumerABQ(BlockingQueue<Integer> abq) {
		this.abq = abq;
	}

	@Override
	public void run() {
		int ele ;
		while(true) {
			try {
				Thread.sleep(5000);
				ele = abq.take();
				System.out.println("Consumption of element "+ ele + " is completed");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}


public class ArrayBlockingQueueExample {

	public static void main(String[] args) {
		BlockingQueue<Integer> abq = new ArrayBlockingQueue<Integer>(10);
		new Thread(new ProducerABQ(abq)).start();
		new Thread(new ConsumerABQ(abq)).start();
		
	}
}
