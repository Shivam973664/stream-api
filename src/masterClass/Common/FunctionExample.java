package masterClass.Common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

import data.StudentDataBase;
import diliptraining.entities.Student;

public class FunctionExample {

	static Function<String, String> f1 = (a)-> a.toUpperCase();
	
	static Function<String, String> f2 = (a) -> a.concat("Jai");
	
//	static Consumer<Student> c1 = (a)-> 
	static Function<List<Student> ,Map<String,Double>> f3 = (a)->{
		Map<String,Double> map = new HashMap<>();
		a.forEach( (b)-> {
			
			if(PredicateAndConsumer.p1.and(PredicateAndConsumer.p2).test(b)) {
			map.put(b.getName(),b.getGpa());
			}
		});
		return map;
		};
	
//	static Function<String...,String...> f2=()
	
	public static void main(String[] args) {
		System.out.println(f1.apply("java8"));
		System.out.println(f1.andThen(f2).apply("java8"));
		System.out.println(f1.compose(f2).apply("java8"));
		System.out.println("Creating map of String and Double of StudentDatabase");
		Map<String,Double> map = f3.apply(StudentDataBase.getAllStudents());
		System.out.println("By using for each loop");
		map.forEach((a,b) -> {System.out.println(a + " " + b);});
		
//		By using below also can be done but above one is great
//		System.out.println("By using Enhance for each loop");
		
//		for(Map.Entry<String, Double> elem : map.entrySet()) {
//			System.out.println(elem.getKey() + " " + elem.getValue());
//		}
	}

}
