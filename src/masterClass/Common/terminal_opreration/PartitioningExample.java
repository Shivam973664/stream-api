package masterClass.Common.terminal_opreration;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import data.StudentDataBase;
import diliptraining.entities.Student;

public class PartitioningExample {

	public static Predicate<Student> p1 = (student) -> student.getGpa()>=3.8;
	
	public static void partitioningOneParameter() {
		Map<Boolean,List<Student>> map = StudentDataBase.getAllStudents().stream()
		.collect(Collectors.partitioningBy(p1));
		map.forEach((a,b)-> System.out.println( a+ " " + b));
	}
	
	public static void partitioningTwoParameter() {
		//which take two parameters one is predicate and other one is downstream which is a collector
		Map<Boolean,Set<Student>> map = StudentDataBase.getAllStudents().stream()
		.collect(Collectors.partitioningBy(p1, Collectors.toSet()));
		
		map.forEach((a,b)-> System.out.println(a + " " + b));
	}
	
	public static void main(String[] args) {
//		partitioningOneParameter();
		partitioningTwoParameter();
	}

}
