package diliptraining;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class LearningFromThis {
	public static void main(String[] args) {
		/// how to create Stream
		//1. From Collection Object
		List<String> values = List.of("One","Two");
		List<String> values5= Arrays.asList("one");
//		List<Long> values3 = List.of(1L,2L);
//		List<String> values2 = Arrays.asList("Shivam","Singh");
		Stream<String> stream1 = values.stream();
		
		//2. Arrays of Values
		String[] names = {"One","Two","Three"};
		int []arr = {1,2,3,4};
		Stream<String> stream2 = Arrays.stream(names);
		
		//3. Stream Methods
		Stream<String> stream3 = Stream.of("One","Two");
		
		//4. generate method provided by stream
		Stream<String> stream4 = Stream.generate(()->"One");
		
		//5. builder() - builder design pattern
		Stream.Builder<String> streamBuilder = Stream.builder();
		Stream<String> stream5=streamBuilder.add("one").add("Two").add("Three").build();
		
		//6. Empty Stream
		//empty()
		Stream<String> stream6 = Stream.empty();
		
		///famous way to create lis
		List<Integer> famousWay = List.of(4,3,2,1);
		famousWay.stream().
		forEach(System.out:: println);
//		List<Integer> result = streamFamousWay.sorted()
//				.forEach(System.out :: println);
//				collect(Collectors.toList());
//		 streamFamousWay.sorted()
//				.forEach(System.out :: println);
				
		
		
	} 

}
