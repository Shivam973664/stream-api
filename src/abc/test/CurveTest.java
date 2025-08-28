package abc.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class CurveTest {

	public static void helper(String input) {
		String []words = input.split(" ");
		List<String> res = new ArrayList<>();
		StringBuilder str = new StringBuilder();
		for(int i=words.length-1;i>=0;i--) {
			
			str.append(words[i] + " ");
//			res.add(words[i]);
		}
//		res.forEach(System.out :: print);
		System.out.println(str.toString());
		
	}
	
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1,1,2,2,2,3);
		//1,2,3,5,6,9,61
//		findKthLargest(list, 2);
//		helper("Hello World");
		findKthLargestByMinHeap(list, 19);
		
	}
	
	public static void findKthLargest(List<Integer> list, Integer k) {
		
		TreeSet<Integer> set= new TreeSet<Integer>((a,b)-> b.compareTo(a));
		set.addAll(list);
		int i=1;
		for(Integer ele : set) {
			if(i==k) {
				System.out.println(ele);
			}
			i++;
		}
		
		//2nd way to iterate treeset
		Iterator<Integer> iterator = set.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
	
	public static void findKthLargestByMinHeap(List<Integer> list, Integer k) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for(Integer ele : list) {
			pq.offer(ele);
			if(pq.size()>k) {
				pq.poll();
			}
		}
		System.out.println(pq.peek());
	}

}
