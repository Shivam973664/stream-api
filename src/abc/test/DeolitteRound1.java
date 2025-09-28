package abc.test;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
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
//		streamq();
		byMyWay();
		
	}
	
	private static void byMyWay() {
		String input="bab";
		int left=0;
		int right =0;
		for(int i=0;i<input.length();i++){
			
			List<Integer> oddIndex= findIndex(input,i,i);
			List<Integer> evenIndex= findIndex(input,i,i+1);
			if((oddIndex.get(1)-oddIndex.get(0)) > (right-left)){
				left= oddIndex.get(0);
				right = oddIndex.get(1);
			}
			
			if((evenIndex.get(1)-evenIndex.get(0)) > (right-left)){
				left= evenIndex.get(0);
				right = evenIndex.get(1);
			}
		}
		System.out.println(input.substring(left,right+1));
		
	}
	
	public static List<Integer> findIndex(String input ,int left,int right){
		while(right<input.length() && left>=0 && input.charAt(left) == input.charAt(right)){
			left--;
			right++;
		}
		return Arrays.asList(left+1,right-1);
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
