package abc.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class InfosysTest {

	public static void main(String[] args) {
		
		helper();
	}
	///arr
	//
	public static void helper() {
	
		List<Integer> arr = Arrays.asList(1,4,614,62,2);
		List<Integer> ans = arr.stream().sorted(Comparator.reverseOrder()).distinct().collect(Collectors.toList());
		
		System.out.println(ans.get(2));
		
	}
	//cohariant variable

}
