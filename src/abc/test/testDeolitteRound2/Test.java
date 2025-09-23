package abc.test.testDeolitteRound2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test {
	
	public static void main(String[] args) {
		helper();
	}
	
	public static void helper2() {
		
	}
	
	 public static  void helper() {
		List<Employee> list = new ArrayList<>();
		Employee emp1 = new Employee("Shivam",19d);
		Employee emp2 = new Employee("Sourabh",29d);
		Employee emp3 = new Employee("Abhishek",19d);
		Employee emp4 = new Employee("Santosh",39d);
		
		list.add(emp1);
		list.add(emp2);
		list.add(emp3);
		list.add(emp4);
		
		Map<Double,List<Employee>> map=list.stream().
				collect(Collectors.groupingBy(Employee :: getSalary));
		map.forEach((a,b)-> System.out.println(a + " " + b));
	}
	
	
	

}

