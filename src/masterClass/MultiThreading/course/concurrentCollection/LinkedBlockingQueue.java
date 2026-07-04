package masterClass.MultiThreading.course.concurrentCollection;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

// uses two independent lock one for put and other one for take
// doesn't use intrinsic lock due to which faster than blockingarraylist
// *** this is best way to implement producer consumer problem
public class LinkedBlockingQueue {

	public static void main(String[] args) {
		// unbounded
//		BlockingQueue<Integer> lbq = new LinkedBlockingDeque<Integer>();
		// BOunded
//		BlockingQueue<Integer> lbq1= new LinkedBlockingDeque<Integer>(10);
		//second example if producer is fast but consumer is slow
		BlockingQueue<Integer> lbq= new LinkedBlockingDeque<Integer>(5);

		Runnable producer = () -> {
			int count = 0;
			while (true) {
				try {
					lbq.add(++count);
					System.out.println("Produced Item : " + count);

					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		Runnable consumer = () -> {
			while (true) {
				try {
					System.out.println("Consumed Item : " + lbq.take());

					Thread.sleep(4000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		new Thread(producer).start();
		new Thread(consumer).start();
	}
}
