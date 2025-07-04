package masterClass.Common;

import java.util.function.Function;
import java.util.function.Supplier;

import diliptraining.entities.Student;

public class ConstructorReference {

	static Supplier<Student> fn = Student:: new;
	
	static Function<String,Student> ffn = Student :: new;
	
//	static Function<String,Student> ffn = (str) -> new Student();
	
	public static void main(String[] args) {
		System.out.println(fn.get());
		System.out.println(ffn.apply("shivvam"));
	}
}
