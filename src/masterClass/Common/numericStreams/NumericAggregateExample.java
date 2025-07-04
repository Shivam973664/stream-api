package masterClass.Common.numericStreams;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class NumericAggregateExample {

	
	
	
	public static void main(String[] args) {
		
		//sum
		System.out.println(IntStream.rangeClosed(1, 50).sum());
		
		//min
		OptionalInt optionalInt = IntStream.rangeClosed(1, 50).min();
		System.out.println(optionalInt.isPresent()? optionalInt.getAsInt() : "not found");
	
		OptionalLong optionalLong = LongStream.rangeClosed(1, 50).max();
		System.out.println(optionalLong.isPresent()? optionalLong.getAsLong(): "not found");
		
		//average
		OptionalDouble optionalDouble = IntStream.range(1, 51).average();
		System.out.println(optionalDouble.isPresent()? optionalDouble.getAsDouble(): "not found");
		
	}

}
