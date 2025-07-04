package masterClass.Common;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

import data.StudentDataBase;
import diliptraining.entities.Student;

public class SupplierExample {

	static Supplier<Student> supp = () -> {
		return new Student("Emily",3,4.0,"female", 12,Arrays.asList("swimming", "gymnastics","aerobics"));
	};
	
	static Supplier<List<Student>> listOfStudent = ()-> {
		return StudentDataBase.getAllStudents();
		};
	
	public static void main(String[] args) {
		System.out.println(supp.get());
		System.out.println(listOfStudent.get());
	}

}
