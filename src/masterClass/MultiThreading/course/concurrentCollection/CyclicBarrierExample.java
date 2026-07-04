package masterClass.MultiThreading.course.concurrentCollection;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class WorkerThreadCYB implements Runnable{
	
	private int id;
	private CyclicBarrier cyclicBarrier;
	
	public WorkerThreadCYB(int id, CyclicBarrier cyb) {
		this.id =id;
		this.cyclicBarrier = cyb;
	}
	

	@Override
	public void run() {
		
		System.out.println("Started the Thread " + this.id);
		try {
			Thread.sleep(1000);
//			if number of  parties === number of thread call await than barrier will broken
			this.cyclicBarrier.await();
//			if the barrier broken all will execute below line of codes
			System.out.println("Task has completed : " + this.id);
		} catch (InterruptedException | BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}


public class CyclicBarrierExample {

	public static void main(String[] args) {
//		whatIRemembered();
		ExecutorService exe= Executors.newFixedThreadPool(5);
		CyclicBarrier barrier= new CyclicBarrier(5,new Runnable() {
			@Override
			public void run() {
				System.out.println("All task is completed");
				
			}
		});
		
		for(int i=0;i<5;i++) {
			exe.execute(new WorkerThreadCYB(i+1,barrier));
		}
		exe.shutdown();
	}

	private static void whatIRemembered() {
		CyclicBarrier cyb = new CyclicBarrier(5);
		ExecutorService exes = Executors.newFixedThreadPool(5);
				
		for(int i=0;i<5;i++) {
			exes.submit(new WorkerThreadCYB(i+1, cyb));
		}
		
		
		System.out.println("Application shutdown");
		exes.shutdown();
		
	}
	
}
