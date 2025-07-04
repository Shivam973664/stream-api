package masterClass.runnableandCompartor;

public class RunnableExample {

	public static void main(String[] args) {
		//using legacy way creating anonymous class 
		Runnable rl = new Runnable() {
			@Override
			public void run() {
				System.out.println("using legacy way ");
			}
		};
		Thread t1 = new Thread(rl);
		t1.start();
		
		//using java 8 way or modern way
		Runnable rn = ()-> System.out.println("using modern way");
		new Thread(rn).start();
	}

}
