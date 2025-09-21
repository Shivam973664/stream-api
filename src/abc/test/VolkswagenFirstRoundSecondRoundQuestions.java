package abc.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;





//sssss*
//ssss**
//sss***
//ss****
//s*****
public class VolkswagenFirstRoundSecondRoundQuestions {
	public static void main(String[] args) {
//		helper2();
//		round1Question2();
		round1Question1();
	}
	
	private static void round1Question1() {
		List<Integer> list = Arrays.asList(1,2,3,3,3,4,4,5,6);
		Optional<Integer> value=
				list.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
				.entrySet().stream().sorted((a,b) -> b.getValue().compareTo(a.getValue())).map(a-> a.getKey()).findFirst();

		System.out.println(value.get());
	}

	private static void round1Question2() {
		List<Integer> list = Arrays.asList(1,2,3,3,3,4,4,5,6);
		List<Integer> result =list.stream().distinct().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		result.forEach(System.out :: println);
	}
	
	

	public static void helper() {
		int input =5;
		
		
		for(int i=0;i<=5;i++) {
			for(int j=0;j<=5;j++) {
				if(j>i) {
					System.out.print("S");
				}else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
	}
	public static void helper2() {
		int input =6;
		
		for(int i=0;i<input-1;i++) {
			int frs= input-(1+i);
			int frstart= i+ 1;
			while(frs>0) {
				System.out.print("S");
				frs--;
			}
			while(frstart>0) {
				System.out.print("*");
				frstart--;
			}
			System.out.println();
			
		}
		
	}
}

