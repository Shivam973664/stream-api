package abc.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class qthreetest {

	public static void main(String[] args) {
		String input = "hello world";
		helper2(input);
	}

	public static void helper1(String input) {
		List<Character> inputchar = new ArrayList<>();
		for (int i = 0; i < input.length(); i++) {
			inputchar.add(input.charAt(i));
		}
//		for(Character ele : input.toCharArray()) {
//			
//		}
		// Character []ch = input.tocharArray();
		Map<Character, Long> map = inputchar.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		map.forEach((a, b) -> System.out.println(a + " - " + b));
	}
	
	
	public static void helper2(String input) {
		input.chars().mapToObj(a-> (char)a).collect(Collectors.groupingBy(Function.identity(),
				Collectors.counting())).forEach((a,b)-> System.out.println(a + " " + b));
	}
	
}
