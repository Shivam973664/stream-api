package masterClass.Common.terminal_opreration;

import java.util.Comparator;
import java.util.stream.Collectors;

import data.StudentDataBase;
import diliptraining.entities.Student;

public class MinByMaxByExample {

	public static Student minByExample() {
		return StudentDataBase.getAllStudents()
				.stream()
//				.collect(Collectors.minBy((a,b)-> a.getGpa() >b.getGpa()? 1 :-1)).get();
				.collect(Collectors.minBy(Comparator.comparing(Student :: getGpa))).get();
	}
	
	public static Student maxByExample() {
		return StudentDataBase.getAllStudents()
				.stream()
				.collect(Collectors.maxBy(Comparator.comparing(Student::getGpa))).get();
	}
	
	public static void main(String[] args) {
		
		System.out.println(minByExample());
		System.out.println(maxByExample());
		
	}

}
