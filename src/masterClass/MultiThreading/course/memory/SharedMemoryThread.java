package masterClass.MultiThreading.course.memory;

//correct this example
class ThreadExample extends Thread{

	@Override
	public void run() {
		int count = 1;
		String name = "Rakesh";
	}
}


class CustomClass{
	Integer count = 1;
	String name= "Rohan";
}


public class SharedMemoryThread {

//	both the thread have separate stack memory where they have local variable stored and they are not shared
//	but if we create a CustomClass variable and the threads use this CustomClass Variable than it is used by both threads . 
	public static void main(String[] args) {

		Thread t1 = new Thread(new ThreadExample());
		Thread t2 = new Thread(new ThreadExample());
		
	}
	
	
	
}
