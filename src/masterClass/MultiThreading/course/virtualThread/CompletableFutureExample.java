package masterClass.MultiThreading.course.virtualThread;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// gave us the advantage that 
// 1. callback :- there is no explicit get() method instead of that it notifies the main thread
// by which we can chain multiple callbacks/operations
// 2. exception handling is provided under the asynchronous method execution.
public class CompletableFutureExample {

	public static void main(String[] args) {
		ExecutorService mainExecutor = Executors.newFixedThreadPool(5);
//		mainExecutor.submit(()->completableFutureExample1());
//		mainExecutor.submit(()->completableFutureExample2());
		mainExecutor.submit(()-> completableFutureExample3());
		mainExecutor.shutdown();
		System.out.println("main thread ended");
	}

	private static void completableFutureExample3() {
		try(var service = Executors.newVirtualThreadPerTaskExecutor()){
//			we are using multiple COmpletable Future due to this
//			both the operation executing Simultaneously
			String res=CompletableFuture.supplyAsync(CompletableFutureExample::dbQuerryOperation,service)
			.thenCombine(CompletableFuture.supplyAsync(CompletableFutureExample::httpOperation,service), (a,b)-> a + b)
//			.thenAccept(System.out :: println);
			.join(); // other example of using join but not reommended since we are stoping the main thread
			System.out.println("Answer : " + res);
		}
	}
	
	private static String dbQuerryOperation() {
		System.out.println("Db Querry Start Executing");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Db Querry Fetched Successfully");
		return "Db querry Result :"+ new Random().nextInt();
		
	}
	
	private static String httpOperation() {
		System.out.println("http Operation Start Executing");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("http Operation Fetched Successfully");
		return "http Operation Result :"+ new Random().nextInt();
		
	}

	private static void completableFutureExample2() {
		System.out.println("\nExample 2:- started");
		CompletableFuture.supplyAsync(()-> "Hello")
		.thenCombine(CompletableFuture.supplyAsync(()-> "World"), (a,b)-> "2:-"+a + " - " + b)
		.thenApply(s-> s.toUpperCase())
		.thenAccept(System.out :: println);
		
	}

	private static void completableFutureExample1() {
		ExecutorService cpuExecutor= Executors.newFixedThreadPool(5);
		ExecutorService ioExecutor = Executors.newCachedThreadPool();
		
		///finding: exectution order will always be same in the when we are using one CompletableFuture
		CompletableFuture<Void> cf=CompletableFuture.supplyAsync(()->{
			try {
				System.out.println("1:-Thread that is Executing supplyAsync: " + Thread.currentThread());
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return "1:-Hello World";
		},cpuExecutor)
		.thenApplyAsync(s-> {
			System.out.println("1:-in the apply async.We are changing case in thread :" + Thread.currentThread());
			try {
				Thread.sleep(400);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return s.toUpperCase();
		
		}
				
				,ioExecutor)
		.thenApply(s-> {
			System.out.println("1:-in the only apply method" + s);
			
			return s.concat("! there is somethings ");})
		.thenAccept(System.out :: println);
		cf.join(); // we have to add it so executorService pool will not close before 
//		providing threads.
		cpuExecutor.shutdown();
		ioExecutor.shutdown(); //if i will comment only this than everything works since
//		the new task we are providing after service ends

	}
	

}
