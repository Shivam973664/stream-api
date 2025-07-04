package masterClass.Common.numericStreams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumericStreamBoxingAndUnboxingExample {

	public static List<Integer> boxingExampel(){
		//converts from int to Integer /// primitive type to wrapper class 
		return IntStream.rangeClosed(1, 10).
				//intstream
				boxed()
				//Stream<Integer>
				.collect(Collectors.toList());
	}
	
	public static int unboxingExample(List<Integer> integers) {
		return integers.stream().
				//Stream<Integer>
//				mapToInt(Integer::intValue)
				mapToInt(a-> a.intValue())
				//IntStream
				.sum();
	}
	
	public static void main(String[] args) {
		System.out.println(boxingExampel());
		System.out.println(unboxingExample(boxingExampel()));
	}

}
