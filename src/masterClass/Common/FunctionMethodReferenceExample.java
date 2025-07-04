package masterClass.Common;

import java.util.function.Consumer;
import java.util.function.Function;

import data.StudentDataBase;
import diliptraining.entities.Student;

public class FunctionMethodReferenceExample {

	static Function<String, String> function = (s) -> s.toUpperCase();
	static Function<String,String> fun2= String :: toUpperCase;
	
	static Consumer<Student> cons = System.out :: println;
	
	public static void main(String[] args) {
		
		System.out.println(fun2.apply("har har mahadev"));
		StudentDataBase.getAllStudents().forEach(cons);
	}
}
