package masterClass.Common;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;

import data.StudentDataBase;
import diliptraining.entities.Student;

public class PredicateAndConsumer {
///order matters
	static Predicate<Student> p1 = (s)-> s.getGradeLevel()>=3;
	static Predicate<Student> p2 = (s)-> s.getGpa() >=4;
	static Consumer<Student> c2 = (s)-> System.out.println(s.getName() +" " + s.getActivities());
	//bipredicate means which can take two inputs
	static BiPredicate<Integer, Double> bp = (a,b) -> a>=3 && b>=4;
	
	
	static Consumer<Student> c1 = (s)-> {
		if(p1.and(p2).test(s)) {
			c2.accept(s);
		}
	};
	static BiConsumer<String, List<String>> bc3 =(a,b)-> System.out.println(a+ " "+ b);
	static Consumer<Student> bipredicateConsuemr = (s)->{
		if(bp.test(s.getGradeLevel(), s.getGpa())) {
			bc3.accept(s.getName(),s.getActivities());
		}
	};
	
	
	

	public static void main(String[] args) {
		StudentDataBase.getAllStudents().forEach(c1);
		System.out.println("Bipredicate Consumer");
		StudentDataBase.getAllStudents().forEach(bipredicateConsuemr);
	}
}
