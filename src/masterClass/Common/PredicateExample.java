package masterClass.Common;

import java.util.List;
import java.util.function.Predicate;

import data.StudentDataBase;
import diliptraining.entities.Student;

public class PredicateExample {

	static Predicate<Student> filterByGrade = (s)-> s.getGradeLevel()>=3;
	static Predicate<Student> filterByGpa= (s)-> s.getGpa()>=4;
	
	public static void main(String[] args) {
//		basicExample();
//		filterStudentList();
		filterByGroupPredicate();
		
	}

	private static void basicExample() {
		// IN between angle we take type of the input we can take
		Predicate<Integer> even = (s) -> s % 2 == 0;
		System.out.println(even.test(10));
		System.out.println(even.test(5));
	}

	public static void filterStudentList() {
		List<Student> studentList = StudentDataBase.getAllStudents();
		studentList.forEach(s->{
			if(filterByGrade.test(s)) {
				System.out.println(s);
			}
		});
	}
	
	public static void filterByGroupPredicate() {
		StudentDataBase.getAllStudents().forEach(
				s->{
					if(filterByGpa.and(filterByGrade).test(s)) {
						System.out.println(s);
					}
				}
				);
	}
}
