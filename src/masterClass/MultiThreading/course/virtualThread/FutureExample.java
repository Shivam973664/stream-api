package masterClass.MultiThreading.course.virtualThread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class FutureWorker implements Callable<String>{

	@Override
	public String call() throws Exception {
		System.out.println("Callable Started Executing");
		Thread.sleep(2000);
		System.out.println("Callable Completed Executing");
		return "Result returned";
	}

}


public class FutureExample {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService exeService = Executors.newFixedThreadPool(5);
		Future<String>  future = exeService.submit(new FutureWorker());
		
		while(!future.isDone()) {
			System.out.println("Main Thread is Blocked");
		}
		
		// blocking operation it will block the task for 2 seconds
		String res= future.get();
		System.out.println("Result : "+ res);
		exeService.shutdown();
		
	}
	
}
