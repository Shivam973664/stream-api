package masterClass.MultiThreading.course.callable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class Processor implements Callable<String> {

	private int id;

	Processor(int id) {
		this.id = id;
	}

	@Override
	public String call() throws Exception {
		Thread.sleep(2000);
		return "Thread has been completed with Id " + id;
	}

}

public class CallableExample {

	public static void main(String[] args) {
		courseWay();
//		ifWeTriedWithThread();
	}

//	not possible for thread it requires only runnable as parameter
//	private static void ifWeTriedWithThread() {
//		Thread t1= new Thread(new Processor(1));
//		
//	}

	private static void courseWay() {
		ExecutorService exe = Executors.newFixedThreadPool(2);
		List<Future<String>> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			Future<String> future = exe.submit(new Processor(i + 1));
			list.add(future);
		}
		for (Future<String> f : list) {
			try {
				String ans = f.get();
				System.out.println(ans);
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
