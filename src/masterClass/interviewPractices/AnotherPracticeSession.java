package masterClass.interviewPractices;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import data.StudentDataBase;
import diliptraining.entities.Student;

public class AnotherPracticeSession {

	public static void main(String[] args) {
		Supplier<Integer> sup1 = ()-> 3;
		System.out.println(sup1.get());
		StudentDataBase.getAllStudents().stream().findFirst().get();
		Map<String,List<Student>> a1 = StudentDataBase.getAllStudents().stream().collect(Collectors.groupingBy(Student::getGender));
		Map<String,List<Student>> a2 = StudentDataBase.getAllStudents().stream().collect(Collectors.groupingBy(a-> a.getGpa()>3.8 ? "OutStanding": "Average" ));
		Map<Integer,Map<String,List<Student>>> a3=StudentDataBase.getAllStudents().stream().collect(Collectors.groupingBy(Student::getGradeLevel, Collectors.groupingBy(Student:: getGender)));
		Map<Integer,Integer> a4= StudentDataBase.getAllStudents().stream().collect(Collectors.groupingBy(Student:: getGradeLevel,
				Collectors.summingInt(Student::getNoteBooks)))
		;
		LinkedHashMap<String,Set<Student>> a5= StudentDataBase.getAllStudents().stream().collect(Collectors.groupingBy(Student :: getName, LinkedHashMap:: new, Collectors.toSet()));
	} 

}
