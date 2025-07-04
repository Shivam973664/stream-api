package masterClass.Common;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import data.StudentDataBase;
import diliptraining.entities.Student;

public class test {
	
	public static void leftShifttheNumber() {
		int n= 108;
		int temp=0;
		temp= n<<1; /// means we are multipllying by 2
		System.out.println(temp); /// dividing by 2
		temp = n>>1;
		System.out.println(temp);
		
	}
	
	public static int findSecondLargest(List<Integer> list) {
		int firstLargest=Integer.MIN_VALUE;
		int secondLargest=Integer.MIN_VALUE;
		
		for(Integer el : list) {
			if(el>firstLargest) {
				secondLargest= firstLargest;
				firstLargest= el;
			}else if(el> secondLargest && el<firstLargest) {
				secondLargest= el;
			}
		}
		return secondLargest;
	}
	
	public static void checkcity() {
		Map<String,List<String>> map = StudentDataBase.getAllStudents().stream().
				collect(Collectors.groupingBy(Student:: getGender,Collectors.mapping(Student :: getName, Collectors.toList())));

		map.forEach((a,b) -> System.out.println(a + " - " + b));
		
		Map<String,Long> map1 = StudentDataBase.getAllStudents().stream().
				collect(Collectors.groupingBy(Student :: getGender,
						Collectors.counting()));
//						));
		map1.forEach((a,b)-> System.out.println(a + " " + b));
		//				.entrySet().stream().map()
	}
	
	public static void main(String[] args) {
		List<Integer> list = List.of(1,23,521,521,01,30,33,32);
//		System.out.println(findSecondLargest(list));
		checkcity();
		StudentDataBase.getAllStudents().stream().
		map(Student::getActivities).
		flatMap(List::stream).
//		flatMap((s) -> {
//			return s.get
//		}).
		collect(Collectors.toList());
		
		
		leftShifttheNumber();
	}

}
