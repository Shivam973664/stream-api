package masterClass.MultiThreading.course.waitNotify;

class Process {
//	its just an example to show wait and notify
//	don't confuse with producer consumer problem

	public void produce() throws InterruptedException {
		synchronized (this) {
			System.out.println("In the Produce method begining");
			wait();
			System.out.println("In the Produce method ending");
		}
	}

	public void consumer() throws InterruptedException {
		Thread.sleep(1000);
		synchronized (this) {
			System.out.println("In the Consumer Method Begining ");
			Thread.sleep(2000);
			notify();
//			other process in the synchronized block will execute than only lock will be provided to other threads
			System.out.println("In the consumer Method ending");

		}
	}
}

public class WaitNotifyExample1 {
	public static void main(String[] args) {
		Process instance = new Process();
		Thread t1 = new Thread(() -> {
			try {
				instance.produce();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

		Thread t2 = new Thread(() -> {
			try {
				instance.consumer();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		t1.start();
		t2.start();
	}

}
