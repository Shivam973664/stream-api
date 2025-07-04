package masterClass.Common.terminal_opreration;

import java.util.List;
import java.util.stream.Collectors;

import data.StudentDataBase;
import diliptraining.entities.Student;

public class MappingExample {

	
	
	public static void main(String[] args) {
		List<String> names = StudentDataBase.getAllStudents()
				.stream()
				.collect(Collectors.mapping(Student:: getName, Collectors.toList()));
		System.out.println(names);
	}
}
