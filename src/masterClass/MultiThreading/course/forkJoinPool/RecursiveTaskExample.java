package masterClass.MultiThreading.course.forkJoinPool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

class RecursiveTaskWorker extends RecursiveTask<Double>{
	private double num;
	
	RecursiveTaskWorker(double num){
		this.num = num;
	}

	@Override
	protected Double compute() {
		
		if(num>100) {
			System.out.println("Computing number " + num);
			RecursiveTaskWorker left= new RecursiveTaskWorker(num/2);
			RecursiveTaskWorker right= new RecursiveTaskWorker(num/2);
			
			left.fork();
			right.fork();
			
			return left.join() + right.join();
		}else {
			System.out.println("Processing this number :" + num);
			return num*2;
		}
		
	}
	
	
}

class FaboniciExample extends RecursiveTask<Integer>{
	
	int n;
	
	public FaboniciExample(int n) {
		this.n = n;
	}

	@Override
	protected Integer compute() {
//		if( n==0) {
//			return 0;
//		}
//		else if(n==1 ) {
////			System.out.println("Come to lowest value");
//			return 1;
//		}
		if(n<=1) {
			return n;
		}
		else {
			System.out.println("Parallaly working on number: " + n);
			FaboniciExample left = new FaboniciExample(n-1);
			FaboniciExample right = new FaboniciExample(n-2);
			left.fork();
			right.fork();
			return left.join() + right.join();
			
		}
	}
	
}

public class RecursiveTaskExample {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
//		courseExample();
//		
		fibonaciExample();
		
	}

	private static void fibonaciExample() {
		ForkJoinPool pool = new ForkJoinPool();
		FaboniciExample fe = new FaboniciExample(6);
		System.out.println(pool.invoke(fe));
	}

	private static void courseExample() {
		ForkJoinPool forkPool = new ForkJoinPool();
		RecursiveTaskWorker task = new RecursiveTaskWorker(10000);
		System.out.println("Result = " + forkPool.invoke(task));
//		task.get(); it fails because the task is never submited
	}
}
