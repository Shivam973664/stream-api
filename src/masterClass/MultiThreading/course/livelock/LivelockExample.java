package masterClass.MultiThreading.course.livelock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LivelockExample {

	private final Lock lock1 = new ReentrantLock(true);
	private final Lock lock2 = new ReentrantLock(true);

	public void worker1() {
		while (true) {
			try {
				lock1.tryLock(50, TimeUnit.MILLISECONDS);
//				lock1.tryLock(); it will also not break livelock reason the threads both are competing for locks
				Thread.sleep(0);
				System.out.println("Worker1 acquired lock 1");
			} catch (InterruptedException intr) {
				System.out.println();
			}
			System.out.println("Worker1 tries to get lock2...");
			if (lock2.tryLock()) {
				System.out.println("Worker 1 acquired lock 2");
				break;
			} else {
				continue;
			}
		}
		lock1.unlock();
		lock2.unlock();
	}

	public void worker2() {
		while (true) {
			try {
				lock2.tryLock(50, TimeUnit.MILLISECONDS);
				System.out.println("Worker2 acquired lock 2");
			} catch (InterruptedException intr) {
				System.out.println();
			}
			System.out.println("Worker2 tries to get lock1...");
			if (lock1.tryLock()) {
				System.out.println("Worker 2 acquired lock 1");
				break;
			} else {
				continue;
			}
		}
		lock1.unlock();
		lock2.unlock();
	}

	public static void main(String[] args) {
		LivelockExample ex = new LivelockExample();
		new Thread(ex::worker1, "Worker 1").start();
		;
		new Thread(ex::worker2, "Worker 2").start();
		;
	}
}
