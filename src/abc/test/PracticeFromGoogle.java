package abc.test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PracticeFromGoogle {

	public static void main(String[] args) {
//		firstNonRepeatingCharacterByStream();
		firstNonRepeatingCharacterbyOptimized();
	}

	private static void firstNonRepeatingCharacterByStream() {
		String word = "sdssd";
		Character c= word.chars().mapToObj(a-> (char) a)
				.collect(Collectors.groupingBy(Function.identity(),LinkedHashMap:: new,Collectors.counting()))
				.entrySet().stream().filter(a-> a.getValue()==1).map(a-> a.getKey()).findFirst()
				.orElseThrow();
		System.out.println(c);
	}
	
	private static void firstNonRepeatingCharacterbyOptimized() {
		String word = "djaskd";
		Map<Character,Integer> map = new HashMap<>();
		for(Character c : word.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0)+1);
		}
		for(Character c : word.toCharArray()) {
			if(map.get(c)==1) {
				System.out.println(c);
				return;
			}
		}
		System.out.println("-1");
	}

	
}
