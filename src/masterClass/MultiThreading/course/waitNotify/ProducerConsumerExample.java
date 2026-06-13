package masterClass.MultiThreading.course.waitNotify;

import java.util.LinkedList;
import java.util.List;

class PAndCLogic {
	private int bufferSize = 5;
	private List<Integer> list = new LinkedList<>();

//	always try to use synchronized block
	public void produce() throws InterruptedException {
		synchronized (this) {
			System.out.println("inside producer begining");
//			it is adviced to use while loop instead of if because when the other thread uses notify or notifyAll all the threads that are waiting for the lock will wake up
//			though one thread will get the lock but still to handle this we use while loop
//			The other threads must check if the condition is still true for them
//			With if, they'd proceed even if the buffer is still full → race condition
//			if (this.list.size() == bufferSize) {
			while (this.list.size() == bufferSize) {
				System.out.println("Found in producer and Buffer Size is FUll");
				wait();
			}

			Thread.sleep(1000);
			while (list.size() < bufferSize) {
				System.out.println("Adding value :=" +( list.size() + 1));
				list.add(list.size());
				Thread.sleep(1000);

			}
			notify();
			System.out.println("inside producer ending");
		}
	}

	public void consume() throws InterruptedException {
		synchronized (this) {
			System.out.println("inside Consumer begining");
			while (this.list.size() < bufferSize) {
				System.out.println("Found in Consumer and Buffer Size is Empty");
				wait();

			}

			while (list.size() > 0) {
				System.out.println("This element removed : " + list.get(0));
				list.remove(0);
				Thread.sleep(1000);
			}
			notify();

			System.out.println("inside Consumer Ending");

		}
	}
}

//this is second approach to share instances between two threads
class ForProducerTask implements Runnable {
	private PAndCLogic pandConsumer;

	ForProducerTask(PAndCLogic pandConsumer) {
		this.pandConsumer = pandConsumer;
	}

	@Override
	public void run() {
		while (true) {
			try {
				this.pandConsumer.produce();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

class ForConsumerTask implements Runnable{
	
	private PAndCLogic pandc;
	
	public ForConsumerTask(PAndCLogic pandClogic) {
		this.pandc = pandClogic;
	}

	@Override
	public void run() {
		while (true) {
			try {
				this.pandc.consume();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}

public class ProducerConsumerExample {

	public static void main(String[] args) {
		PAndCLogic pandClogic = new PAndCLogic();
		Thread t1 = new Thread(new ForProducerTask(pandClogic));
		Thread t2 = new Thread(new ForConsumerTask(pandClogic));
		
		t1.start();
		t2.start();
		
	}

}
