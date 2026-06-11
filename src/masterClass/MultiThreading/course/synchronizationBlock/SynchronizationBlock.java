package masterClass.MultiThreading.course.synchronizationBlock;

public class SynchronizationBlock {

	private  int counter1 = 0;
	private  int counter2 = 0;
	
//	in this example we have two threads which are accessing same instance but they are accessing different variables .below the problem we are facing 
//	we can use synchronized keyword on method  but it will stop other thread from accesing variables and 
//	  will wait for this thread to complete 
//	therefore we will create two object level lock and use that variable as lock
//	**** always prefer using synchronized block instead of synchronized method
// ** Object level locing
	private Object lock1 = new Object();
	private Object lock2 = new Object();
	
	
	public  void increment1() {
		synchronized(lock1) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Current counter 1 :" + counter1);
			counter1++;
		}
		
	}
	
	public  void increment2() {
		synchronized(lock2) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Current counter 2 :" + counter2);
			counter2++;
		}
	}
	
	public void execute() throws InterruptedException {
		Thread t1 =new Thread( ()-> {
			for(int i=0;i<1000;i++) {
				this.increment1();
			}
			
		});
		Thread t2 =new Thread( ()-> {
			for(int i=0;i<1000;i++) {
				this.increment2();
			}
			
			
		});
		t1.start();
		t2.start();
		t1.join();
		System.out.println("Counter 1: "+ counter1);
		t2.join();
		System.out.println("Counter 2: "+ counter2);
		
	}
	
}
