package masterClass.MultiThreading.course.virtualThread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

//import jdk.internal.misc.VirtualThreads;

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


public class VirtualThread1Example {

	public static void main(String[] args) throws InterruptedException {
		createDifferentWaysPP();
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
