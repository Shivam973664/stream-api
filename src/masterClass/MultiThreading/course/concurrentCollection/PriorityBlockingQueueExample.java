package masterClass.MultiThreading.course.concurrentCollection;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;


class Person implements Comparable<Person>{

	private String name;
	private int age;
	
	
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	


	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}


	


	@Override
	public int compareTo(Person o) {
		
		return Integer.compare(this.age, o.getAge());
	}
	
}

class PriorityFirstWorker implements Runnable{
	
	private BlockingQueue<String> pq ;
	private BlockingQueue<Person> personpq;
	
	PriorityFirstWorker(BlockingQueue<String> pq,BlockingQueue<Person> personpq){
		this.personpq = personpq;
		this.pq = pq;
	}

	@Override
	public void run() {
		
		
		try {
			pq.add("Z");
			Thread.sleep(1000);
			pq.add("A");
			pq.add("C");
			Thread.sleep(1000);
			pq.add("E");
			Thread.sleep(1000);
			pq.add("D");
			personpq.add(new Person("Ram", 10));
			personpq.add(new Person("Shayam", 1));
			personpq.add(new Person("GhanSHayam", 15));
			personpq.add(new Person("Rohan", 9));
			personpq.add(new Person("Rakesjh", 90));
			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
}
class PrioritySecondWorker implements Runnable{
	
	private BlockingQueue<String> pq ;
	private BlockingQueue<Person> personpq;
	
	PrioritySecondWorker(BlockingQueue<String> pq, BlockingQueue<Person> personpq){
		this.pq = pq;
		this.personpq = personpq;
	}

	@Override
	public void run() {
		
		
		try {
			Thread.sleep(5000);
			while(!pq.isEmpty()) {
				System.out.println(pq.take());
				Thread.sleep(2000);
			}
			while(!personpq.isEmpty()) {
				System.out.println(personpq.take());
				Thread.sleep(2000);
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
}


public class PriorityBlockingQueueExample {

	public static void main(String[] args) {
		BlockingQueue<String> pq = new PriorityBlockingQueue<String>();
		BlockingQueue<Person> personPq = new PriorityBlockingQueue<Person>();
		new Thread(new PriorityFirstWorker(pq,personPq)).start();
		ExecutorService exe = Executors.newFixedThreadPool(2);
		exe.submit(new PrioritySecondWorker(pq,personPq));
		exe.submit(new PrioritySecondWorker(pq,personPq));
		exe.shutdown();
	}
}
