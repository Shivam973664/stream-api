package masterClass.MultiThreading.course.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

//by using enum we promote singleton pattern 
enum Downloading{
	INSTANCE;
	
//	parameters :- count number of permits, fairness
	private Semaphore semaphore= new Semaphore(3,true);
	
	public void downloading() {
		try {
			this.semaphore.acquire();
			downloadData();
		}catch(InterruptedException exc) {
//			System.out.println(exc.printStackTrace()); compile time error
			exc.printStackTrace();
		}finally {
			this.semaphore.release();
		}
	}
	private void downloadData() throws InterruptedException {
		Thread.sleep(2000);
		System.out.println("Downloading large file completed");
	}
	
}

public class App {

//	It is used to control the shared resource that uses a counter variable
//	Semaphore maintain set of permits
//	- acquire() .... if permit is available than takes it 
//	- release() .... adds a permit
	
//	semaphore just keep a count of the number of permits availa ble
//	new semaphore(int permits , boolean fairness)
	public static void main(String[] args) {
//		by using executor Service we have created threads
		ExecutorService executorService = Executors.newCachedThreadPool();
		for(int i=0;i<10;i++) {
			executorService.submit(()->{
				Downloading.INSTANCE.downloading();
			});
		}
		executorService.shutdown();
		System.out.println("Over");
	}
	
}
