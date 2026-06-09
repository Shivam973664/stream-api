package masterClass.MultiThreading.course.synchronization;

public class SynchronizationExample {

	public static int counter = 0;

//	if we don't synchronize this method due to race condtion the value will be wrongly updated . therefore we have to use synchronized keyword in this method
	public synchronized static void increment() {
		counter++;
	}

	public static void main(String[] args) {

		Thread t1 = new Thread(() -> {
			for (int i = 0; i < 1000; i++) {
				increment();
			}
		});
		Thread t2 = new Thread(() -> {
			for (int i = 0; i < 1000; i++) {
				increment();
			}
		});

		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (Exception e) {

		}

		System.out.println(counter);

	}

}
