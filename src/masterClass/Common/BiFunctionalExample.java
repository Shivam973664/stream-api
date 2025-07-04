package masterClass.Common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Predicate;

import data.StudentDataBase;
import diliptraining.entities.Student;

public class BiFunctionalExample {

	static BiFunction<List<Student>, Predicate<Student>, Map<String,Double>> bf1 =
			(students,studentPredicate)->{
				Map<String,Double> map= new HashMap<>();
				students.forEach(
						student->{
							if(studentPredicate.test(student)) {
								map.put(student.getName(), student.getGpa());
							}
						}
						);
				return map;
			};
	
	public static void main(String[] args) {
		System.out.println(bf1.apply(StudentDataBase.getAllStudents(), PredicateAndConsumer.p1));
		
	}

}
