package abc.test;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HSCMangerialRound {

	public static void main(String[] args) {
		//arr[] = [0, -1, 2, -3, 1,-1], target = -2
		//set  : contain the values we traverse
		//0 , -1 , 
		// 
		
		int []arr= {0, -1, 2, -3, 1,-1};
		Set<Integer> set = new HashSet<>();
		int target= -2;
		List<List<Integer>> ans= new ArrayList<>();
		for(int i=0;i<arr.length;i++) {
			if(set.contains(target-arr[i])) {
				ans.add(Arrays.asList(arr[i],target-arr[i]));
			}else {
				set.add(arr[i]);
			}
			
		}
//		ans.forEach(System.out :: println);
//		helper();
		helper2();
				
	}
	
	public static void helper() {
		//strs = {"flower","flow","float"}
		List<String> list= Arrays.asList("aflower","flow","float");
		//flower , flow
		//i-> l ,  j-> 
		
		String firstele = list.get(0);
		int ptr=0;
		String maxRes="";
		
		
		
		
		for(int i=0;i<firstele.length();i++) {
			boolean checkingEqual = true;
			
			for(int j=1;j<list.size();j++) {
				String temp = list.get(j);
//				ptr=i;
//				for(int k=0;k<temp.length();k++) {
					
					if(firstele.charAt(i)!=temp.charAt(i)) {
//						ptr++;
						checkingEqual = false;
						break;
					}
//				}
				
			}
			if(checkingEqual) {
				maxRes= maxRes + firstele.charAt(i);
			}else {
				break;
			}
		}
		System.out.println(maxRes);
		
		
	}
	
	
	
	public static void helper2() {
		//strs = {"flower","flow","float"}
		List<String> list= Arrays.asList("flower","flow","float");
		//flower , flow
		//i-> l ,  j-> 
		String firstele = list.get(0);
		int ptr=0;
		String maxRes="";
		for(int i=0;i<firstele.length();i++) {
			for(int j=i+1;j<firstele.length();j++) {
				for(int k=1;k<list.size();k++) {
					String ele = list.get(k);
					if(!ele.contains(firstele.substring(i, j))) {
						break;
					}
					if(k==list.size()-1) {
						maxRes= maxRes.length()> firstele.substring(i,j).length() ? maxRes: firstele.substring(i,j);
					}
				}
			}
		}
		System.out.println(maxRes);
		
		
	}
}
