package masterClass.Common;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import data.StudentDataBase;
import diliptraining.entities.Student;

public class ReduceExample {
	
	public static void mapfilterreduceExample() {
		Optional<Integer> totalNotebooks =StudentDataBase.getAllStudents().stream().
				filter(a-> a.getGpa()>3.9).
				map(Student::getNoteBooks).reduce(
				Integer::sum);
		System.out.println(totalNotebooks);
		
	}

	public static void getHighestStudentGpa() {
		Optional<Student> highestStudent = StudentDataBase.getAllStudents().stream()
				.reduce((a,b)->{
//					if(a.getGpa()>b.getGpa()) {
//						return a;
//					}
//					return b;
					return a.getGpa()>b.getGpa() ? a : b;
				});
		if(highestStudent.isPresent()) {
			System.out.println(highestStudent);
		}
	}
	
	public static void firstReduceExample() {
//		List<Integer> nums = Arrays.asList(1,23,52,1,5,34);
		List<Integer> nums = new ArrayList<>();
		Integer mulRes = nums.stream().
				//1
				// 1(res),1 -> 1
				// 1, 23 -> 23
				// 23, 52 -> 
				reduce(1,(a,b) -> a*b);
		
		Optional<Integer> mulResWithoutIdentity = nums.stream().reduce( (a,b)-> a*b);
		if(mulResWithoutIdentity.isPresent()) {
			System.out.println(mulResWithoutIdentity + " "+ mulResWithoutIdentity.get());
		}else {
			System.out.println(mulResWithoutIdentity);
		}
		System.out.println(mulRes);
	}
	
	public static void main(String[] args) {
//		firstReduceExample();
//		getHighestStudentGpa();
		mapfilterreduceExample();
		
	}

}
