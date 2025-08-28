package abc.test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Rssolution {

	
//	more than ⌊n / 2⌋ times.
//	 
//	Input: [3, 3, 4, 2, 3]
//	Output: 3
//	 
//	note: n = length of Array
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(3, 3, 4, 2, 3);
		findValue(list,list.size());
		helper();
	}
	
	public static void findValue(List<Integer> input,int n) {
		Map<Integer, Long> map = input.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		for(Map.Entry<Integer, Long> bean : map.entrySet()) {
			if(bean.getValue()>=(n/2)) {
				System.out.println(bean.getKey());
				break;
			}
		}
	}
	
	public static void helper() {
		List<String> empName= Arrays.asList("Shivam","Shivam", "Ravi");
		Set<String> set= new HashSet<>();
		for(String bean : empName){
			set.add(bean);
		}
		set.forEach(System.out :: println);
	}

}
