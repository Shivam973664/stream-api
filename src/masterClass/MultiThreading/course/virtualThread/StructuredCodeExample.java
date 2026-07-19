package masterClass.MultiThreading.course.virtualThread;

import java.util.concurrent.Callable;
import java.util.concurrent.StructuredTaskScope;
import java.util.concurrent.StructuredTaskScope.Subtask;
import java.util.concurrent.StructuredTaskScope.Subtask.State;

class StructuredExample implements Callable<String>{
	
	private long timestamp;
	
	private String message;
	
	

	public StructuredExample(long timestamp, String message) {
		super();
		this.timestamp = timestamp;
		this.message = message;
	}



	@Override
	public String call() throws Exception {
		Thread.sleep(timestamp);
		return message;
	}
	
}


class StructuredExampleValidationFailure implements Callable<String>{
	
	private long timestamp;
	
	private String message;
	
	private boolean fail;
	

	public StructuredExampleValidationFailure(long timestamp, String message,boolean fail) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.fail = fail;
	}



	@Override
	public String call() throws Exception {
		System.out.println("Starting of thread : " + Thread.currentThread());
		Thread.sleep(timestamp);
		if(fail) {
			System.out.println("Exception found in thread : " + Thread.currentThread());
			throw new RuntimeException("Failure due to Server down");
		}
		System.out.println("Completing Thread : " + Thread.currentThread());
		return message;
	}
	
}

public class StructuredCodeExample {

	public static void main(String[] args) throws InterruptedException {
//		firstExample();
//		falilureHandling();
		oneSuccess();
	}

	


	private static void firstExample() throws InterruptedException {

//		we don't use pool of virtual thread .we create new ones for every task and dispose them after they finish.
		try(var structuredTaskStock = new StructuredTaskScope<String>()){
//			we submit the task in parallal means each task will execute in parallal.
			Subtask<String> res =structuredTaskStock.fork(new StructuredExample(3,"thread 1"));

			var res2=structuredTaskStock.fork(new StructuredExample(5,"thread 2"));
//			combine the results
//			get() will not block because the join() waits for the thread to  finish
//			virtual threads are used due to this underlying system thread will not blocked
//			System.out.println(res.get()); you have to join to call the result
			structuredTaskStock.join();
			
//			we can also check for the state of the subtask
			if(res.state() == State.SUCCESS) {
				System.out.println(res.get());
			}
			
			if(res2.state() == State.SUCCESS) {
				System.out.println(res2.get());
			}
			
//1.			System.out.println(res.get()+ " "  + res2.get());
		}
	}
	
	private static void falilureHandling() throws InterruptedException {
		try(var structuredTaskStock = new StructuredTaskScope.ShutdownOnFailure()){
			Subtask<String> res =structuredTaskStock.fork(new StructuredExampleValidationFailure(1000,"thread 1",true));

			var res2=structuredTaskStock.fork(new StructuredExampleValidationFailure(8000,"thread 2",false));
			structuredTaskStock.join();
			try {
				System.out.println(res.get() + " - " + res2.get() );
			}catch(Exception e) {
				System.out.println("Terminating of thread : " + Thread.currentThread());
			}
		}
	}
	

	private static void oneSuccess() throws InterruptedException {
		try(var structuedTaskScope = new StructuredTaskScope.ShutdownOnSuccess<String>()) {
			var task1 = structuedTaskScope.fork(new StructuredExampleValidationFailure(2000, "thread 1", false));
			var task2 = structuedTaskScope.fork(new StructuredExampleValidationFailure(5000, "thread 1", false));
			
			structuedTaskScope.join();
			
			
		}
	}


}
