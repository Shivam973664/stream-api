package masterClass.MultiThreading.course.classLevelObjectLevel;
// change name to CLass locking for class level :- common sense
class ObjectLocking {
// Example :- Difference between :- class level and object level locking
//	class level-
//	all instances  of the class and there instance used at many threads have to wait for the class level lock
//	object level - independent 
	public static synchronized void instanceMethod() {
		System.out.println("Entering method Of thread :" + Thread.currentThread().getName());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("finishing method Of thread :" + Thread.currentThread().getName());
	}

}

public class ClassLevelAndObjectLevelDifference {

	public static void main(String[] args) {
		ObjectLocking ins = new ObjectLocking();
		ObjectLocking ins2 = new ObjectLocking();
//		Thread t1 = new Thread(() -> {
//			ins.instanceMethod();
//		}, "Thread 1");
//		Thread t2 = new Thread(() -> {
//			ins2.instanceMethod();
//		}, "Thread 2");
//		t1.start();
//		t2.start();

		new Thread(() -> {
			ObjectLocking.instanceMethod();
		}, "Thread 1").start();
		new Thread(() -> {
			ObjectLocking.instanceMethod();
		}, "Thread 2").start();
		
//		joins are not used if you don't need there result
//		try {
//			t1.join();
//			t2.join();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}

}
