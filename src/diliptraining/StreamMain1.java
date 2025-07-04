package diliptraining;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMain1 {
	public static void main(String [] args) {
		//Creating list  
		//1st method by me
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		//2nd method by using List.of
		//this list is immutable 
		List<Integer> list2= List.of(1,2,4,5,6);
		
		//3rd method by using Arrays.asList
		//this list is immutable
		List<Integer> list3 = Arrays.asList(1,4,6,7,8,9);
		
		List<Integer> resultWO = new ArrayList<>();
		//without stream
		for(Integer val : list) {
			if(val%2==0) {
				resultWO.add(val);
			}
		}
		//with stream
		//stream is an interface we can't create object of the stream
		//we can get the object of the stream . some where internally class is there whicch is implementing
		Stream<Integer> stream = list.stream();
//		List<Integer> resultw= stream.filter(i->i%2==0).collect(Collectors.toList());
		 List<Integer> resultw = list.stream().filter(i-> i>3).collect(Collectors.toList());
		System.out.println("Without strea :" +resultWO);
		System.out.println("with stream : " + resultw);
		
	}

}
