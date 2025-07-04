package masterClass.Common.terminal_opreration;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import data.StudentDataBase;
import diliptraining.entities.Student;

public class GroupingBy_1Example {

	//i am writing questions for below solutions
	// Q : group the students based on there Gender.
	public static void groupingByExample() {
		Map<String, List<Student>> map= StudentDataBase.getAllStudents()
		.stream()
		.collect(Collectors.groupingBy(Student:: getGender));
//		Map<String,List<Student>> map = StudentDataBase.getAllStudents().stream()
//				.collect(Collectors.groupingBy(a-> a.getGender()));
				
				
		for(Map.Entry<String, List<Student>> m : map.entrySet()) {
			System.out.println("key :" + m.getKey() +" value : "+ m.getValue());
		}
		map.forEach((a,b)-> System.out.println(a + " "+ b));
	}
	
	//group the student based on there gpa and if the student gpa is 3.8 and more give him tag outstanding otherwise average
	public static void groupingByCustomKey() {
		Map<String,List<Student>> map = StudentDataBase.getAllStudents()
		.stream()
		.collect(Collectors.groupingBy(student -> student.getGpa()>3.8 ? "OUTSTANDING": "AVERAGE"));
		map.forEach((a,b)-> System.out.println(a + " "+ b));
	}
	
	//Q : group the student first there gradelevel then group them by tagging them outstanding adn average
	public static void groupingBy_second() {
		Map<Integer,Map<String,List<Student>>> map =StudentDataBase.getAllStudents()
		.stream()
		.collect(Collectors.groupingBy(Student:: getGradeLevel, Collectors.groupingBy(
				s-> s.getGpa() >=3.8 ? "OUTSTANDING" : "GOOD"
				)));
		map.forEach((a,b)-> {System.out.println(a + " " );
		b.forEach((c,d)-> System.out.println(c + " "+ d));
			});
		
		
	}
	//Q : group the student with grade level and find the sum of there notebooks
	public static void groupingBy_Second_sum() {
		Map<Integer,Integer> map =StudentDataBase.getAllStudents()
		.stream()
		.collect(Collectors.groupingBy(Student :: getGradeLevel, Collectors.summingInt(Student ::getNoteBooks)));
		map.forEach((a,b)-> System.out.println(a + " "+ b));
	}
	//give linkedhashmap as output and the value should be set as we might contain duplicates.
	//group them by name.
	public static void groupingBy_thirdExample() {
		LinkedHashMap<String, Set<Student>> hashmap = 
		StudentDataBase.getAllStudents()
		.stream()
		.collect(Collectors.groupingBy(Student :: getName, LinkedHashMap:: new, Collectors.toSet()));
		hashmap.forEach((a,b)-> System.out.println(a+ " " + b));
	}
	
	//Q: find the highest and lowest in the grade level
	public static void groupByGradeLevelMaxByMinBy() {
		Map<Integer, Optional<Student>> map =StudentDataBase.getAllStudents().stream()
		.collect(Collectors.groupingBy(Student::getGradeLevel, 
				Collectors.minBy(Comparator.comparing(Student :: getGpa))));
		
		map.forEach((a,b)-> System.out.println(a + " " + b.get()));
		
	}
	
	//Q : same but remove optional student and return highest student by gpa
	public static void groupByGradeLevelMaxByExampleRemoveOptional() {
		Map<Integer,Student> map =StudentDataBase.getAllStudents().stream()
		.collect(Collectors.groupingBy(Student::getGradeLevel, 
				Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Student::getGpa)), Optional::get)));
		map.forEach((a,b)-> System.out.println(a+ " "+ b));
	}
	
	
	public static void main(String[] args) {
		groupingByExample();
//		System.out.println();
//		groupingByCustomKey();
//		groupingBy_second();
//		groupingBy_Second_sum();
//		groupingBy_thirdExample();
//		groupByGradeLevelMaxByMinBy();
//		groupByGradeLevelMaxByExampleRemoveOptional();
	}

}
