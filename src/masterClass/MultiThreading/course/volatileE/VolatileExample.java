package masterClass.MultiThreading.course.volatileE;

//ideal way to stop the thread 
public class VolatileExample {

	

	private volatile int counter;
	
	public void increment() {
		counter++;
	}
	
	public static void main(String[] args) {
//		Example 1 : volatile will not help you to synchronize multiple threads using the same variable.
//		VolatileExample ve = new VolatileExample();
//		Thread t1 = new Thread(()-> {
//			for(int i=0;i<10000;i++) {
//				ve.increment();
//			}
//		});
//		Thread t2=new Thread(()-> {
//			for(int i=0;i<10000;i++) {
//				ve.increment();
//			}
//		});
//		t1.start();
//		t2.start();
//		
//		try {
//			t1.join();
//			t2.join();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		System.out.println(ve.counter);
//		Example 1 end
		Worker exa= new Worker();
		Thread t1 = new Thread(exa);
		t1.start();
		try {
			Thread.sleep(30);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		exa.isTerminated();
		
		
		
	}
	
	
}


class Worker implements Runnable{

	private volatile  boolean terminated;
	@Override
	public void run() {
		
		while(!terminated) {
			System.out.println("Worker thread is executing");
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void isTerminated() {
		this.terminated=true;
	}
	
}
