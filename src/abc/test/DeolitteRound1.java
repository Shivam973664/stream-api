package abc.test;

import java.util.LinkedHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DeolitteRound1 {

//	Input: s = "babad"
//
//			Output: "bab"
//			 
	public static void main(String[] args) {
//		String input = "cbbd";
//		String result="";
//		for(int i=0;i<input.length();i++) {
//			for(int j=i+1;j<input.length();j++) {
//				if(isPalindrome(input, i, j)) {
//					result= result.length() < input.substring(i,j+1).length() ? input.substring(i,j+1) :result;
//				}
//			}
//		}
//		System.out.println(result);
		streamq();
		
	}
	
	public static boolean isPalindrome(String str,int l,int r) {
		while(l<r) {
			if(str.charAt(l)!=str.charAt(r)) {
				return false;
			}
			l++;
			r--;
		}
		return true;
	}
	
	public static void streamq() {
		String input= "cbbd";
		Character ans= input.chars().mapToObj(c-> (char) c).collect(
				Collectors.groupingBy(Function.identity(),LinkedHashMap :: new ,
						Collectors.counting()))
		.entrySet().stream().filter(a-> a.getValue()==1).findFirst().get().getKey();
		
		System.out.println(ans);
	}
	
}
