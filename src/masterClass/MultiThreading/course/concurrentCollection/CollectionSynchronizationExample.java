package masterClass.MultiThreading.course.concurrentCollection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionSynchronizationExample {

	public static void main(String[] args) {
		
//		List<Integer> list = new ArrayList<>(); // result ::- different size of an array.
//		synchronizedlist :- below it will create wrapper object around arraylist so the wrapper object is having static method with synchronized
//		and they use intrinsic lock.
		List<Integer> list = Collections.synchronizedList(new  ArrayList<>()); 
		Thread t1 = new Thread(()->{
			for(int i=0;i<1000;i++) {
				list.add(i);
			}
		});
		Thread t2 = new Thread(()->{
			for(int i=0;i<1000;i++) {
				list.add(i);
			}
		});
		t1.start();
		t2.start();
		
		
		try {
			t1.join();
			t2.join();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(list.size());
	}
	
	
}
