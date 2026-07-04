package masterClass.MultiThreading.course.concurrentCollection;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

class WorkerCopy implements Runnable {

	private List<Integer> list;
	private Random random;

	public WorkerCopy(List<Integer> list) {
		this.list = list;
		this.random = new Random();
	}

	@Override
	public void run() {

		try {
			while (true) {

				Thread.sleep(1000);
				list.set(random.nextInt(list.size() ), random.nextInt(1000));
				System.out.println(list);
			}

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

public class CopyOnWriteArraysExample {
	public static void main(String[] args) {
		List<Integer> copy = new CopyOnWriteArrayList<Integer>();
		copy.addAll(Arrays.asList(0,0,0,0,0,0,0,0,0,0));
		new Thread(new WorkerCopy(copy)).start();
		new Thread(new WorkerCopy(copy)).start();
		new Thread(new WorkerCopy(copy)).start();
	}
}
