package masterClass.Common;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import data.StudentDataBase;
import diliptraining.entities.Student;

public class DistinctCountSortedExample {

	public static void distinctExample() {
		List<String> allActivities =StudentDataBase.getAllStudents().stream().map(Student::getActivities)
		.flatMap(List::stream).distinct().collect(Collectors.toList());
		System.out.println(allActivities);
	}
	
	public static void sortExample() {
		List<String> allActivities =StudentDataBase.getAllStudents().stream().map(Student::getActivities)
				.flatMap(List::stream).distinct().sorted((a,b) -> b.compareTo(a))
		.collect(Collectors.toList());
		System.out.println(allActivities);
	}
	
	public static void customsortExample() {
		List<Student> list = StudentDataBase.getAllStudents();
//		Collections.sort(list,(a,b)-> a.getName().compareTo(b.getName()));
		List<Student> list2 = list.stream().sorted((a,b)-> a.getName().compareTo(b.getName()))
				.collect(Collectors.toList());
		System.out.println(list);
		System.out.println(list2);
	}
	public static void countExample() {
//		Function<String, Integer> f1 = (a,b) -> a.com
		long count =StudentDataBase.getAllStudents().stream().map(Student::getActivities)
//				.flatMap(List::stream).distinct().sorted((a,b) -> b.compareTo(a))
				.flatMap(List::stream).distinct().sorted(Comparator.comparing(String::toString))
				.count();
//		.collect(Collectors.toList());
		System.out.println(count);
	}
	public static void main(String[] args) {
		
//		distinctExample();
//		sortExample();
//		countExample();
		customsortExample();
		
	}
}
