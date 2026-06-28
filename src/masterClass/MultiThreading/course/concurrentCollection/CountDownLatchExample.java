package masterClass.MultiThreading.course.concurrentCollection;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//Problem :- when we use ExecutorService we don't have the reference of the threads because dynamic thread creation. So How We can 
//wait for other thread to get completed than only we can start
//Solution :- Use CountDounLatch . The waiting thread will call await method and wait till the coutdown variable to reach 0 . than only it will unblock itself.
//the thread which call countDown method will not blocked . 

class WorkerThread implements Runnable {
	private int id;
	private CountDownLatch countDownLatch;
	public WorkerThread(int id, CountDownLatch countDownLatch) {
		this.id = id;
		this.countDownLatch = countDownLatch;
	}

	@Override
	public void run() {
		doWork();
		this.countDownLatch.countDown();
		
	}

	private void doWork() {
		try {
			System.out.println("Thread with Id: " + this.id + " is started executing");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}

public class CountDownLatchExample {
	
	public static void main(String[] args) {
//		the countdownlatch should be set value equal to or less than the number of threads for which it will wait.
//		otherwise it will move to infinite loop
		CountDownLatch countDownLatch = new CountDownLatch(5);
		ExecutorService exeService = Executors.newSingleThreadExecutor();
		for(int i=0;i<5;i++) {
			exeService.execute(new WorkerThread(i+1,countDownLatch));
		}
		try {
			countDownLatch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		exeService.shutdown();
		System.out.println("Application Shutdown");
		
	}
	
}
