package masterClass;

import java.util.List;
import java.util.stream.Collectors;

import data.StudentDataBase;
import diliptraining.entities.Student;
//about flatmap , distinct , sorted, count
public class FlatMapMethod {

	public static List<String> getAllActivities(){
		return StudentDataBase.getAllStudents().stream().map(Student::getActivities)
				.flatMap(a-> a.stream()).collect(Collectors.toList());
//				.flatMap(List::stream).collect(Collectors.toList());
	}
	
	public static List<String> getAllUniqueActivites(){
		return StudentDataBase.getAllStudents().stream().map(Student::getActivities)
				.flatMap(List::stream).distinct().toList();
	}
	
	public static Long getCount(){
		return StudentDataBase.getAllStudents().stream().count();
	}
	
	public static List<String> getSortedList(){
		
		return StudentDataBase.getAllStudents().stream().map(Student:: getActivities)
				.flatMap(List::stream)
				.distinct()
				.sorted()
//				.
				.toList();
	}
	
	public static void main(String[] args) {
		
		System.out.println(getAllActivities());
		System.out.println(getAllUniqueActivites());
		System.out.println(getCount());
		System.out.println(getSortedList());
		
	
	}
}
