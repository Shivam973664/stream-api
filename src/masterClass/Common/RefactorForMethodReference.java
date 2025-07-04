package masterClass.Common;

import java.util.function.Predicate;

import data.StudentDataBase;
import diliptraining.entities.Student;

public class RefactorForMethodReference {
	
//	static Predicate<Student> pred = (s) -> s.getGradeLevel()>=3;
	static Predicate<Student> pred =RefactorForMethodReference :: ReferenceMethod;
	
	public static boolean ReferenceMethod (Student std) {
		return std.getGradeLevel()>=3;
	}
	
	
	public static void main(String[] args) {
		System.out.println(pred.test(StudentDataBase.getAllStudents().get(0)));
	}

}
