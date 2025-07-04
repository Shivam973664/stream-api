package masterClass;

import java.util.List;
import java.util.stream.Collectors;

import data.StudentDataBase;
import diliptraining.entities.Student;

//whenever we want to perform some operation on all the elements of the list 
public class LearningMapMethod {
	
	public static List<String> getAllStudentName(){
//		return StudentDataBase.getAllStudents().stream().map(Student::getName)
//				.collect(Collectors.toList());
		return StudentDataBase.getAllStudents().stream().map(Student:: getName)
				.collect(Collectors.toList());
	}

	public static List<String> getUpperName(){
		return StudentDataBase.getAllStudents().stream().map(Student::getName).
				map(String::toUpperCase).
				collect(Collectors.toList());
	}
	public static void main(String[] args) {
		System.out.println(getAllStudentName());
		System.out.println(getUpperName());
	}
}
