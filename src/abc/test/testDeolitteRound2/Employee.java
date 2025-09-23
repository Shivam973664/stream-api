package abc.test.testDeolitteRound2;

import java.util.Objects;

class Employee {
	
	private String name;
	private Double salary;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", salary=" + salary + "]";
	}
	public Employee(String name, Double salary) {
		super();
		this.name = name;
		this.salary = salary;
	}
//	@Override
//	public int hashCode() {
//		return Objects.hash(name, salary);
//	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(name, other.name) && Objects.equals(salary, other.salary);
	}
	
	///create index index_name for 
	///""" 
	///name : 
	///   """
	///
	
	
}