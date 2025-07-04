package masterClass.SortingConcepts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import data.StudentDataBase;
import masterClass.SortingConcepts.Employee;
import diliptraining.entities.Student;

public class SortingLearn {

	public static void main(String[] args) {
		//+ by conventional way
		//using Comparator interface
		List<Student> list1 = StudentDataBase.getAllStudents();
		System.out.println(list1);
		Collections.sort(list1,new StudentComparator());
//		Collections.sort(list1); //getting exception if we use this
		System.out.println(list1);
		
		//using Comparable Interface
		List<Employee> l2 = employeesList();
		Collections.sort(l2);
		System.out.println(l2);
		
		//using stream api
		List<Student> l3 = StudentDataBase.getAllStudents();
		l3.stream().sorted(Comparator.comparing(Student:: getGpa).reversed()).
//		l3.stream().sorted((a,b)-> a.getGpa() <b.getGpa() ? 1 : 0).
		forEach(System.out :: println);
		
		
		
	}
	
	public static List<Employee> employeesList() {
		List<Employee> employeeList = new ArrayList<>();
		employeeList.add(new Employee(1, "Six", "Security City", 43, "Male", "Security", 2016, 55000.0));
        employeeList.add(new Employee(2, "Seven", "Finance City", 35, "Male", "Finance", 2010, 70000.0));
        employeeList.add(new Employee(3, "three", "bareilly", 23, "Male", "Security", 2016, 5000.0));
        employeeList.add(new Employee(4, "four", "pilibhit", 55, "Male", "Finance", 2010, 72000.0));

		return employeeList;
		
	}

}
