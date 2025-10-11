package abc.test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public class MagnitTestRound1 {
	final List<Integer> list = Arrays.asList(11,1,11,32,52,23);

	List<Integer> ans =list.stream().distinct().collect(Collectors.toList());



	@FunctionalInterface
	interface CustomInterface{
		
		public void getName();

	}


	class CustomImplementation implements CustomInterface{

		public void getName(){
			System.out.println("Name");

		}


		
	}


//	list.stream()
//	.filter(a-> a%2==0)
//	.map(a-> a*2)
//	.flatMap(a-> a.stream())
//	.sorted(Comparator.naturalOrder())
//	.limit(5)
//	.skip(4)
//	.collect(Collectors.toList())
//	.reduce(0,(a,b)-> a*b)



	public class CustomException extends Exception{

		public CustomException(String msg){
			super(msg);
		}

	}




///now the second test where she asked me to create counter the two threads will increment
///and decrement the counter

//	counter;

	class CounterExample{
		
		private static Integer counter=0;
		private static List<Integer> list = new CopyOnWriteArrayList<>();

		//public CounterExample(Integer count){
		//	this.counter= count;
		//}

		public synchronized static  void increment(){
			CounterExample.counter++;
		}

		public synchronized static  void decrement(){
			CounterExample.counter--;
		}

		public static Integer getCounter(){
			return CounterExample.counter;
		}

		public static synchronized void produceElement(){
			int i=1;
			while(true){
				list.add(i);
				i++;
			
			}
			
		}

		public static synchronized void consumeElement(){
			while(true){
				if(!list.isEmpty() && list.size()>1){
					System.out.println(list);	
					list.clear();
				}
			}
			
		}



	}



	 class ClientCode {
		
		class Producer extends Thread{
			
			@Override
			public void run(){
				System.out.println("Produced element");
				CounterExample.produceElement();
			}

		}



		class Consumer extends Thread{
			
			@Override
			public void run(){
				System.out.println("Consumed element");
				CounterExample.consumeElement();
			}

		}

		public  static void main(String []args){
			
			Thread t1 = new Thread(()-> {
				CounterExample.increment();	
			});
			Thread t2 = new Thread(()-> {
				CounterExample.decrement();	
			});
			t1.run();
			t2.run();
			System.out.println(CounterExample.getCounter());



			//
//			Producer p1 = new Producer();
//			Consumer c1 = new Consumer();
			
//			p1.start();
//			c1.start();

		}

	}



	



}
