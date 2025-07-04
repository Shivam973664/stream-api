package masterClass.Common;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class MaxExample {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1,4,62,43,321,2);
//		Optional<Integer> value =  numbers.stream().max(Integer::max);
//		using reduce
		Optional<Integer> value = numbers.stream().reduce(Integer::max);
		
		System.out.println(value);
		findMaxByStream();
	}
	
	public static void findMaxByStream() {
		List<Integer> numbers = Arrays.asList(1,4,62,43,321,2);
		Integer result= numbers.stream().max(Comparator.comparing(Function.identity())).get();
		System.out.println(result);
	}
}
