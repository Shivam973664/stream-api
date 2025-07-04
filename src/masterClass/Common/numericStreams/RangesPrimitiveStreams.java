package masterClass.Common.numericStreams;

import java.util.function.Consumer;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class RangesPrimitiveStreams {

	public static void main(String[] args) {
		
//		Consumer<long> c1 = a-> System.out.print(a+ ",");
		IntStream.range(1, 50).forEach(a-> System.out.print(a+","));
		System.out.println();
		System.out.println("Total Elements : " +IntStream.range(1, 50).count());
		LongStream.range(1, 50).forEach( a-> System.out.print(a+ ","));
		System.out.println();
//		doublestream does not have range static method
//		DoubleStream.ran
//		to implement double for range use below code
		LongStream.rangeClosed(1, 50).asDoubleStream().forEach( a-> System.out.print(a+ ","));
	}
}
