package masterClass.MultiThreading.course.forkJoinPool;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

class FaboniciExampleOpt extends RecursiveTask<Integer> {

	int n;

	public FaboniciExampleOpt(int n) {
		this.n = n;
	}

	@Override
	protected Integer compute() {
		if (n <= 1) {
			return n;
		} else {
			System.out.println("Parallaly working on number: " + n);
			FaboniciExample left = new FaboniciExample(n - 1);
			FaboniciExample right = new FaboniciExample(n - 2);
//			left.fork();
			right.fork();
//			so instead of calling join on first thread we are calling compute directly
//			so we execute the left using the current thread and created new thread right
			return left.compute() + right.join();

		}
	}

}

public class ThreadOptimizationRecursive {
	
	public static void main(String[] args) {
		fibonaciExample();
	}

	private static void fibonaciExample() {
		ForkJoinPool pool = new ForkJoinPool();
		FaboniciExampleOpt fe = new FaboniciExampleOpt(6);
		System.out.println(pool.invoke(fe));
	}
}
