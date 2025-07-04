package masterClass.Common.defaultStaticLearning;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import data.StudentDataBase;
import diliptraining.entities.Student;

public class DefaultExampleTwo {
	
	static Consumer<Student> c1 = (student) -> System.out.println(student);
	
	public static void  listWithNullValueSort() {
		
		Comparator<Student> comparator = Comparator.nullsLast(Comparator.comparing(Student::getName));
//		Comparator<Student> comparator = Comparator.comparing(Student::getName);
		
		List<Student> list = StudentDataBase.
				getAllStudents();
//		list.sort(Comparator.comparing(Student::getName));
		list.sort(comparator);
		list.forEach(c1);
		
	}
	
	public static void comparatorComparingChain() {
		//so it will first sort the list by gpa then if the gpa are equal
		//it will sort using grade level
		List<Student> list = StudentDataBase.getAllStudents();
		list.sort(Comparator.comparing(Student::getGpa).thenComparing(Comparator.comparing(Student::getGradeLevel)));
		list.forEach(c1);
	}

	
	
	
	public static void main(String[] args) {
		//Different ways of sorting 
		//1. using Collections.sort()
		//2. by using stream api
		//list.stream().sort().collect(Collectors.toList());
//		List<Student> byStreamApi = list.stream().sorted(Comparator.comparing(Student:: getGpa)).collect(Collectors.toList());
//		byStreamApi.forEach(c1);
		//3. by using Comparator interface and then one  Class implement this.
		//4. by using comparable interface the main class will implement this.
		//5. best way is use default method in the list.
		
		List<Student> list = StudentDataBase.getAllStudents();
		listWithNullValueSort();

		//sort by there name
//		list.sort(Comparator.comparing(Student:: getName));
		
		//sort by there gpa
		//we will get exception the moment we call the sort method when we have one null value in the list
		list.sort(Comparator.comparingDouble(Student::getGpa));
		list.sort(Comparator.comparing(Student:: getGradeLevel));

		//so in this case it just mean we first sort using gpa . then we just sort using gradelevel
		//it doesn't refer to the previous list.
		
		list.forEach(c1);
		
		//sort by chainging 
		System.out.println();
		comparatorComparingChain();
		
		//we have added null in the list and then try to sort 
		
	}

}
