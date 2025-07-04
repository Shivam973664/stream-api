package masterClass.Common.terminal_opreration;

import java.util.stream.Collectors;

import data.StudentDataBase;
import diliptraining.entities.Student;

public class JoiningExample {

	// period should before the method called
	//it doesn't look good if we just use this
	public static String joining_1() {
		return StudentDataBase.getAllStudents().stream().
				map(Student:: getName).
				collect(Collectors.joining());
				
	}
	//if we want to separate with coma then
	public static String joining_2() {
		return StudentDataBase.getAllStudents().stream().
				map(Student:: getName).
				collect(Collectors.joining(", "));
	}

	
	public static String joining_3() {
		return StudentDataBase.getAllStudents().stream().
				map(Student:: getName).
				collect(Collectors.joining(", ","+","."));
	}
	
	public static void main(String[] args) {
		System.out.println(joining_1());
		System.out.println(joining_2());
		System.out.println(joining_3());
	}

}
