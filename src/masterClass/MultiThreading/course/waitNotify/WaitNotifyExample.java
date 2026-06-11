package masterClass.MultiThreading.course.waitNotify;

import java.util.LinkedList;
import java.util.List;

class TemporaryClass {
	private int bufferSize = 5;
	private List<Integer> list = new LinkedList<>();

//	always try to use synchronized block
	public void produce() throws InterruptedException {
		synchronized (this) {
			System.out.println("inside producer begining");
			if (this.list.size() == bufferSize) {
				wait();
			}

			Thread.sleep(1000);
			while (list.size() <= bufferSize) {
				System.out.println("Adding value :=" + list.size());
				list.add(list.size());

			}
			notify();
			System.out.println("inside producer ending");
		}
	}

	public void consume() {
		synchronized (this) {
			System.out.println("inside Consumer begining");
			if (this.list.size() < list.size()) {
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			while (list.size() > 0) {
				System.out.println("This element removed : " + list.get(0));
				list.remove(0);
//			list.add(list.size());
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			notify();

			System.out.println("inside Consumer Ending");

		}
	}
}

public class WaitNotifyExample {

	public static void main(String[] args) {
		TemporaryClass temp = new TemporaryClass();
		new Thread(() -> {
			try {
				temp.produce();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}).start();
		;

		new Thread(() -> {
			temp.consume();
		}).start();
	}

}
