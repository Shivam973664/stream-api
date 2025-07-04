package masterClass.Common.numericStreams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import diliptraining.entities.Student;

public class NSMapExample {

	public static List<Integer> maptoObject(){
		return IntStream.rangeClosed(1,10).
//				mapToObj(i-> new Integer(i)) depreciated
				mapToObj(i -> Integer.valueOf(i)).
				collect(Collectors.toList());
	}
	
	public static List<Student> realmapToObject(List<String> names){
		return names.stream().map(a-> new Student(a))
				.collect(Collectors.toList());
	}
	
	public static long maptoLong() {
		return IntStream.rangeClosed(1, 10).
				mapToLong(i-> i).
//				mapToLong().
				sum();
	}
	
	
	public static double maptoDouble() {
		return IntStream.rangeClosed(1, 10).
				mapToDouble(i-> i).
//				mapToLong().
				sum();
	}
	
	
	public static void main(String[] args) {
		System.out.println(maptoObject());
		System.out.println(maptoLong());
		System.out.println(maptoDouble());
		System.out.println(realmapToObject(Arrays.asList("Shivam","Singh")));
	}
}
