package masterClass.MultiThreading.course.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

//Reuses threads, so less creation overhead.
//Keeps a fixed number of active threads.
//Queues extra tasks instead of overloading the system.
//Gives better performance stability under load
class ThreadLogic implements Runnable {
	private int id;

	public ThreadLogic(int id) {
		this.id = id;
	}

	@Override
	public void run() {
		System.out.println(
				"Inside this thread with Id : " + Thread.currentThread().getId() + " and with task id : " + this.id);
		long duration = (long)( Math.random() * 5);
		try {
			TimeUnit.SECONDS.sleep(duration);
		} catch (InterruptedException e) {
//			we have to interrupt this thread := 
			System.out.println("Thread Interrupted : "+ this.id);
			Thread.currentThread().interrupt();
		}
		System.out.println("Thread Execution completed for thread Id :" + Thread.currentThread().getId());

	}
}

public class FixedThreadPool {

	public static void main(String[] args) {
		ExecutorService exeService = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 10; i++) {
			exeService.execute(new ThreadLogic(i + 1));
		}
//		all previous task will be completed but no new task will be executed if we use below line
		 exeService.shutdown();
//		 + if i will use below code it will not wait for above thread to complete execution
//		 try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		 + if i will use below code it will not wait for above thread to complete execution end
//		 what if i want to stop task that are currently running .
//		 to terminate actual (running )tasks
		
		 try {
//			 In the if (!exeService.awaitTermination(...)) block, you call it when the pool did not finish in time.
			 
//			 ************
//			 shutdown() stops new task submission.
//
//			 awaitTermination(...) waits for running tasks to finish.
//
//			 If they still do not finish, shutdownNow() forces interruption.
//
//			 If waiting is interrupted, shutdownNow() is called again as cleanup.
//			 ************
			 if(!exeService.awaitTermination(1000, TimeUnit.MILLISECONDS)) {
				 System.out.println("in the termination now ");
				 exeService.shutdownNow();
			 }
		 }catch(InterruptedException exc) {
			 System.out.println("Inside the catch block of interupted exception");
			 exeService.shutdownNow();
		 }
//		 exeService.shutdown(); if i will place here than above code will not execute .
	}

}
