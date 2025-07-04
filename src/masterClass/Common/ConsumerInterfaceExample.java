package masterClass.Common;

import java.util.List;
import java.util.function.Consumer;

import data.StudentDataBase;
import diliptraining.entities.Student;

public class ConsumerInterfaceExample {
	static Consumer<Student> c1= (a)-> System.out.println(a);
	static Consumer<Student> c2 = (b) -> System.out.println(" last :"+b);
	static Consumer<Student> c3 = p-> System.out.println(p.getName().toUpperCase());
	static Consumer<Student> c4 = p-> System.out.println(p.getActivities());

	public static void main(String[] args) {
//		List<Student> list = StudentDataBase.getAllStudents();
//		list.forEach(c2);
		
//		list.forEach(c1.andThen(c2));
//		c1.andThen(c2).accept(list.get(0));
		
		
//		c1.accept(5);
//		exampples by sir
		Consumer<String> c1 = p -> System.out.println(p.toUpperCase());
		c1.accept("shiv");
		printName();
		System.out.println("calling printnameActivities");
		printNameActivities();
		System.out.println("*** calling printNameAndActivitiesConditional");
		printNameAndActivitiesConditional();
		
	}

	private static void printName() {
		// TODO Auto-generated method stub
		StudentDataBase.getAllStudents().forEach(c3);
		
	}

	private static void printNameActivities() {
		StudentDataBase.getAllStudents().forEach(c3.andThen(c4));
	}
	
	private static void printNameAndActivitiesConditional() {
		StudentDataBase.getAllStudents().forEach(c->{
			if(c.getGpa()>3.9) {
				c3.andThen(c4).accept(c);
			}
		});
	}
}
