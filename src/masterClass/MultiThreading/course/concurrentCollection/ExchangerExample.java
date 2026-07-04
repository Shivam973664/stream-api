package masterClass.MultiThreading.course.concurrentCollection;

import java.util.concurrent.Exchanger;

//when we are using excahnger there has to be two threads not more than that each will
// call exchange than only it will work 
class FirstThreadExchanger implements Runnable{

	private Exchanger<Integer> exchanger;
	private int count;
	
	public FirstThreadExchanger(Exchanger<Integer> exc) {
		this.exchanger = exc;
	}
	
	@Override
	public void run() {
		while(true) {
			System.out.println("First Thread Incremented the counter " + ++count);
			try {
				this.count = exchanger.exchange(count);
				System.out.println("After Exchanginig in first Thread " + count);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}


class SecondThreadExchanger implements Runnable{

	private Exchanger<Integer> exchanger;
	private int count;
	
	public SecondThreadExchanger(Exchanger<Integer> exc) {
		this.exchanger = exc;
	}
	
	@Override
	public void run() {
		while(true) {
			System.out.println("Second Thread Decremented the counter " + --count);
			try {
				this.count = exchanger.exchange(count);
				System.out.println("After Exchanginig in Second Thread " + count);
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}

public class ExchangerExample {

	public static void main(String[] args) {
		Exchanger<Integer> exh = new Exchanger<Integer>();
		new Thread(new FirstThreadExchanger(exh)).start();
		new Thread(new SecondThreadExchanger(exh)).start();
	}
}
