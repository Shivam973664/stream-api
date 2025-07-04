package masterClass;

import data.StudentDataBase;

public class FilterLearing {

	public static void main(String[] args) {
		StudentDataBase.getAllStudents().stream().filter(a-> a.getGender().equals("male"))
		.forEach(System.out :: println);
		
	}
}
