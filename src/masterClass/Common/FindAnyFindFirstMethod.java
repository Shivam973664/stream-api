package masterClass.Common;

import java.util.Optional;

import data.StudentDataBase;
import diliptraining.entities.Student;

public class FindAnyFindFirstMethod {

	
	public static void findFirstExample() {
		Optional<Student> student = StudentDataBase.getAllStudents().stream()
				.filter(s-> s.getGpa()>=3.9)
				.findFirst();
		System.out.println(student);
	}
	
	public static void findAnyExample() {
		Optional<Student> student = StudentDataBase.getAllStudents().stream()
				.filter(s-> s.getGpa()>=3.9)
				.findAny();
		System.out.println(student);
	}
	
	
	public static void main(String[] args) {
		findFirstExample();
		findAnyExample();
		
	}
}
