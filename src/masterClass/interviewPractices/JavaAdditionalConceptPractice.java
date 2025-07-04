package masterClass.interviewPractices;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class JavaAdditionalConceptPractice {

	//*AllThread Related Concepts
	private static void allThreadRelated() {
		howTOCreateThreadPool();
	}
	
	private static void howTOCreateThreadPool() {
		//by using ExecutorService interface
		//Executors class
		//creating thread of fixed size
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		for(int i=0;i<10;i++) {
			final int taskId = i;
			executorService.submit(
					()-> {
						System.out.println("Task Id " + taskId+" Thread Name "+ Thread.currentThread().getName());
						try {
							Thread.sleep(1000);
						}catch(Exception e) {
							Thread.currentThread().interrupt();
						}
					}
					);
		}
		executorService.shutdown();
		
		//*By Using ThreadPoolExecutor
		
		int corePoolSize= 2;
		int maxPoolSize = 4;
		long keepAliveTime= 10;
		TimeUnit timeunit = TimeUnit.SECONDS;
		BlockingQueue<Runnable> queue = new LinkedBlockingQueue<Runnable>(10);
		ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize, maxPoolSize, keepAliveTime, timeunit, queue);
		for(int i=0;i<10;i++) {
			final int taskId=1;
			executor.execute(()->{
				System.out.println("Task " + taskId + " executed by " + Thread.currentThread().getName());
			
				try {
					Thread.sleep(1000);
				}catch(Exception e) {
					Thread.currentThread().interrupt();
				}
			});
		}
		executor.shutdown();
		
		
		
	}
	
	private static void aboutExecutor() {
		//this is Executor interface 
		// we have to use ExecutorService which implement executor class
		
//		Executor executor = Executors.newSingleThreadExecutor();
//		executor.execute(()-> System.out.println("Task Executed"));
//		executor.
	}
	
	private static void scheduledExecutorService() {
		ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
		ScheduledFuture<?> future = scheduler.schedule(()-> System.out.println("Delayed Task"), 5, TimeUnit.SECONDS);
		try {
			future.get();// Waits for task to complete
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally{
			scheduler.shutdown();
		}
		
		
	}
	
	
	public static void main(String[] args) {
		allThreadRelated();
		
		aboutExecutor();
		scheduledExecutorService();
	}

	
}
