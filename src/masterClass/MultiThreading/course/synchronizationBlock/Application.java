package masterClass.MultiThreading.course.synchronizationBlock;

public class Application {

	public static void main(String[] args) {
		SynchronizationBlock syn = new SynchronizationBlock();
		try {
			syn.execute();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
