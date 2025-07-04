package masterClass.Common.parallalStream;

import java.util.List;
import java.util.stream.Collectors;

import data.StudentDataBase;
import diliptraining.entities.Student;

public class ParallalStreamExample1 {

	public static void sequentialExample() {
		
		long startTime = System.currentTimeMillis();
		List<String> list =StudentDataBase.getAllStudents().stream()
//				.parallel()
		.map(Student:: getActivities)
		.flatMap(List:: stream)
		.distinct()
		.sorted()
		.collect(Collectors.toList());
		long endTime = System.currentTimeMillis();
		
		System.out.println(endTime-startTime);
		
	}
	
public static void parallalExample() {
		
		long startTime = System.currentTimeMillis();
		List<String> list =StudentDataBase.getAllStudents().parallelStream()
				//.stream().parallal()
		.map(Student:: getActivities)
		.flatMap(List:: stream)
		.distinct()
		.sorted()
		.collect(Collectors.toList());
		long endTime = System.currentTimeMillis();
		
		System.out.println(endTime-startTime);
		
	}
	
	public static void main(String[] args) {
		
		sequentialExample();
		parallalExample();
	}

}
