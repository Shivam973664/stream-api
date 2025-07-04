package masterClass.Common.parallalStream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DrawbackParallalStream {

	public static void parallalStreamExample(List<Integer> list) {
		long startTime = System.currentTimeMillis();
		list.parallelStream().reduce(0,Integer:: sum);
		
		long duration = System.currentTimeMillis()-startTime;
		System.out.println("Duration in Parallal Stream : "+ duration);
	}
	
	public static void sequentioalStreamExample(List<Integer> list) {
		long startTime = System.currentTimeMillis();
		list.stream().reduce(0,Integer:: sum);
		
		long duration = System.currentTimeMillis()-startTime;
		System.out.println("Duration in Sequential Stream : "+ duration);
	}
	
	
	
	public static void main(String[] args) {
		List<Integer> list = IntStream.rangeClosed(1, 10000)
				.boxed()
				.collect(Collectors.toList());
		
		sequentioalStreamExample(list);
		parallalStreamExample(list);
	}

}
