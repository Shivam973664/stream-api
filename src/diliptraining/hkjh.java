package diliptraining;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class hkjh {

	public static void main(String[] args) {
		//stream API - collection process
		//group of object
//		Arrays.stream(null)
		String[] names= {"shivam","Singh","Sujeet","Gudiya"}; 
		//best below one
		Stream<String> myNewByArraysAsStream = Arrays.stream(names);
		Stream<String> streamofstr= Stream.of(names);
		streamofstr.forEach(
				e->{
					System.out.println(e);
				}
				);
		//by using strembuilder
		Stream<Object> streambuilder=Stream.builder().build();
//		streambuilder.forEach(e);
		
		//3rd : by using 
		IntStream streamArray=Arrays.stream(new int[] {4,6,7,8});
		streamArray.forEach(e->{
			System.out.println(e);
		});
		
		//collection object
		//we can directly work on this stream
		
	}


}
