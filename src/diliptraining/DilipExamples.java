package diliptraining;

import java.util.ArrayList;
import java.util.List;

import diliptraining.entities.Employee;

public class DilipExamples {
	public static void main(String[] args) {
		List<Employee> employees = employeesList();
		
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
