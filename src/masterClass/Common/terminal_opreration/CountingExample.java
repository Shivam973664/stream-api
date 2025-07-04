package masterClass.Common.terminal_opreration;

import java.util.stream.Collectors;

import data.StudentDataBase;

public class CountingExample {

	public static void main(String[] args) {
		System.out.println(StudentDataBase.getAllStudents().stream().filter(s-> s.getGpa()>=3.9)
				.collect(Collectors.counting()));
	}

}
