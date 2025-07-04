package masterClass.Common;

import data.StudentDataBase;

public class MatchMethodsExample {

	public static void allMatch() {
		boolean ans = StudentDataBase.getAllStudents().stream().
		allMatch(s -> s.getGpa()>=3.3);
		System.out.println(ans);
		
		System.out.println(StudentDataBase.getAllStudents().stream().anyMatch(a-> a.getGpa()>=3.1));
		
		System.out.println(StudentDataBase.getAllStudents().stream().noneMatch(a-> a.getGpa()>=4.1));
	
	}
	
	public static void main(String[] args) {
		
		allMatch();
		
	}

}
