package masterClass.MultiThreading.course.virtualThread;

import java.lang.Thread.Builder.OfVirtual;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

//import jdk.internal.misc.VirtualThreads;

//VT cannot unmount( remove from the platform thread ) when below two conditions:-
//1. synchronized block or method . you can use locks
//2. VT runs native (or foreign) method



class VirtualWorkerThread implements Runnable{

	@Override
	public void run() {
		System.out.println("Thread Start Working: " + Thread.currentThread().getName());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Thread Finished: " + Thread.currentThread().getName());
	}
	
}
class VirtualWorkerThreadMethodReference {
	public static void runAny() {
		System.out.println("Thread Start Working: " + Thread.currentThread().getName());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Thread Finished: " + Thread.currentThread().getName());
	}
	
}


public class VirtualThread1Example {

	public static void main(String[] args) throws InterruptedException {
//		createDifferentWaysPP();
		createVirtualThreadByCourse();
	}

	private static void createVirtualThreadByCourse() throws InterruptedException {

//		approach1();
		approach2();
		
	}

	private static void approach2() throws InterruptedException {
//		here we are going to use factory approach
		ThreadFactory factory = Thread.ofVirtual().name("Virtual-",0).factory();
		Thread t1 = factory.newThread(new VirtualWorkerThread());
		Thread t2 = factory.newThread(VirtualWorkerThreadMethodReference::runAny);
		t1.start();
		t2.start();
		t1.join();
		t2.join();
	}

	private static void approach1() throws InterruptedException {
//		first of creating by builder
//		OfVirtual builder= Thread.ofVirtual().name("Virtual-",0); return type is OfVirtual
//		here we are using builder approach
		var builder= Thread.ofVirtual().name("Virtual-",0);  //we are using variable argument operator
		Thread t1= builder.start(new VirtualWorkerThread());
		var t2 =builder.start(new VirtualWorkerThread());
//		all virtual thread are daemon threads !!
		t1.join();
		t2.join();
		
	}

	private static void createDifferentWaysPP() throws InterruptedException {
//		for simple virtual thread creation 
		Thread t1=Thread.startVirtualThread(new VirtualWorkerThread());
//		for creating using of operator
		Thread t2 = Thread.ofVirtual().start(new VirtualWorkerThread());
//		if we don't want to start the thread on the same line
		Thread t3 = Thread.ofVirtual().unstarted(new VirtualWorkerThread());
		t3.start();
//		by executor service it is unbound means it will create n number of virtual thread as per task available there.
		ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor();
		executorService.submit(new VirtualWorkerThread());
//		by Executor
		ThreadFactory tf = Thread.ofVirtual().factory();
		Executor executor = Executors.newThreadPerTaskExecutor(tf);
		executor.execute(new VirtualWorkerThread());
//		by Completable future
		try(ExecutorService exeService = Executors.newVirtualThreadPerTaskExecutor()) {
			CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
				System.out.println("Starting of Completable future virtual thread");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return "Completable Future completed";
			},exeService);
			String res=completableFuture.join();
			System.out.println(res);
		}
//		we don't need to use finally here reason :- the try() will close the resource automatically
//		finally{
//			exeService.shutdown();
//		}
		
		
		
		
		t1.join();
		t2.join();
		t3.join();
		executorService.shutdown();
	}
}
