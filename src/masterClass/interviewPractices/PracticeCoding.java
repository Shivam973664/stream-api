package masterClass.interviewPractices;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PracticeCoding {

	public static void main(String[] args) {
//		findDuplicateElements();
//		findDuplicateSecondApproach();
//		reverseString();
		findFirstNonRepeatedCharacter();
	}
	
	//4. Sort an array (without using library sort function)
	public static void mergeSort(List<Integer> list) {
		
	}
	
//	public static merge(int )
	
	//3.Find the first non-repeating character in a string
	public static void findFirstNonRepeatedCharacter() {
		String input = "yoyoskl";
		Map<Character,Integer> map = new LinkedHashMap<>();
		int []freq= new int[26];
		for(Character c : input.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) +1);
			freq[c-'a']++;
		}
		for(int i=0;i<26;i++)
		System.out.print(freq[i] + " ");
		for(Map.Entry<Character,Integer> bean : map.entrySet()) {
			if(bean.getValue()==1) {
				System.out.println(bean.getKey());
				break;
			}
		}
	}
	
	//2. Reverse a string without using built-in functions
	public static void reverseString() {
		String input= "hero";
		StringBuilder str = new StringBuilder();
//		System.out.println(new StringBuilder(input).reverse());
		for(int i=input.length()-1;i>=0;i--) {
			str.append(input.charAt(i));
		}
		System.out.println(str.toString());
	}
	//1.Find duplicates in an array or list
	public static void findDuplicateElements() {
		int []arr= {1, 2, 3, 2, 4, 5, 1};
		Set<Integer> set = new HashSet<>();
		Set<Integer> res = new HashSet<>();
		for(Integer ele : arr){
			if(set.contains(ele)){
				res.add(ele);
			}
			set.add(ele);
		}
		
		res.forEach(System.out :: println);
	}
	
	public static void findDuplicateSecondApproach() {
		int []arr= {1, 2, 3, 2, 4, 5, 1};
		Map<Integer,Integer> map = new HashMap<>();
		for(Integer ele : arr) {
//			map.putIfAbsent(ele,map.getOrDefault(ele, 0));
			map.put(ele, map.getOrDefault(ele, 0) +1);
		}
		for(Map.Entry<Integer, Integer> bean : map.entrySet()) {
			if(bean.getValue()==1) {
				continue;
			}
			System.out.println(bean.getKey()+ " " + bean.getValue());
		}
		
	}
}
