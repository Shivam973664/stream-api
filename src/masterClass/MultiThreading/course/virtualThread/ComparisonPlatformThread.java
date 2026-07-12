package masterClass.MultiThreading.course.virtualThread;

import java.time.Duration;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ComparisonPlatformThread {

	public static void main(String[] args) {
		
//		creatingPlatformThread();
		creatingVirtualTread();
	}

	private static void creatingVirtualTread() {
		ExecutorService exeService= Executors.newVirtualThreadPerTaskExecutor();
		for(int i=0;i<10000;i++) {
			exeService.submit(()-> {
				System.out.println("Thread Started " + Thread.currentThread());
				try {
					Thread.sleep(Duration.ofSeconds(5));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			});
		}
		System.out.println("Method is ended");
		
		
	}

	private static void creatingPlatformThread() {
//		in below example we should get Memory Out of Exception but i am not getting it
		for(int i=0;i<10000;i++) {
			Thread.ofPlatform().start(()->{
				System.out.println("Thread Started : "+ Thread.currentThread());
				try {
					Thread.sleep(Duration.ofSeconds(50));
//					throw new RuntimeException("Honey singh"); //exception is working fine
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			});
		}
	}
	
	
}
