package masterClass.Common;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class StreamOfGenerateIterateExample {

	public static void main(String[] args) {
		
		Stream<String> stream = Stream.of("Shivam","Karthik","Sujeet");
		stream.forEach(System.out :: println);
		//if we again use the same stream we will get exception
//		 reduce uses binary operator as parameter
//		stream.reduce((a,b)-> a.concat(b));
		
		//*iterateExample
//		it runs infinite times . therefore we use limit method.
//		we use unary operator(input output param type are same) in the paramater 
		Stream.iterate(1, x-> x*2)
		.limit(5)
		.forEach(System.out :: println);
		
		//*generateExample
//		It also runs infinite times therefore we use limit method
//		we use supplier in the parameter
//		Supplier<Integer> supplier = new Random():: nextInt;
		Supplier<Integer> supplier = ()-> new Random().nextInt();
		
		Stream.generate(supplier)
		.limit(5).forEach(System.out :: println);;
		
		
	}

}
