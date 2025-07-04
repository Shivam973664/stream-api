package masterClass.Common;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import data.StudentDataBase;
import diliptraining.entities.Student;

public class IntroductionStreams {

	static Function<Student,String> f1 = (s) -> s.getName();
	public static void main(String[] args) {
		creatingStreams();
	}

	public static void creatingStreams() {
		Predicate<Student> p1 = s-> s.getGradeLevel()>3;
		//so we can pass anything like functional interface . 
		//+++Streams api are lazy means no intermediate operation will be invoked 
		//until an terminal operation is invoked.
		Map<String,List<String>> map = StudentDataBase.getAllStudents().stream()
				.filter(IntroductionStreams:: filterListbasedOnGPA)
				.filter(p1)
//		.collect(Collectors.toMap((s) -> s.getName(),(s) -> s.getActivities()));
		.collect(Collectors.toMap(Student:: getName, Student :: getActivities));
//		f1.app
		System.out.println(map);
		
		
	}
	
	public static boolean filterListbasedOnGPA(Student student) {
		return student.getGpa()>3.9;
	}
	
	
	
}
