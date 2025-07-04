package masterClass.Common.terminal_opreration;

import java.util.stream.Collectors;

import data.StudentDataBase;
import diliptraining.entities.Student;

public class SumAvgExample {

	public static void sumExample() {
		int ans = StudentDataBase.getAllStudents().stream()
		.map(Student:: getNoteBooks)
		.collect(Collectors.summingInt(a-> a));
		
		int ans2 = StudentDataBase.getAllStudents()
				.stream()
				.collect(Collectors.summingInt(Student::getNoteBooks));
		
		System.out.println(ans2);
	}
	
	public static void averageExample() {
		double avg = StudentDataBase.getAllStudents()
		.stream()
		.collect(Collectors.averagingInt(Student:: getNoteBooks));
		System.out.println(avg);
	}
	
	public static void main(String[] args) {
		
		sumExample();
		averageExample();
	}

}
