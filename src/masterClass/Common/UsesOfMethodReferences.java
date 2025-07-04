package masterClass.Common;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class UsesOfMethodReferences {

	
	public static void main(String[] args) {
		//MR can be used anywhere lambda expression used.
		//MR can be used wherever lambda expression is used
		
		//+Example 1 : Sorting an list
		List<String> foods = Arrays.asList("apple","Banana" ,"Orange","Guavava");
//		foods.sort(String :: );
		Collections.sort(foods,(a,b) -> a.length()<b.length() ? 1 :0);
//		by using method reference
//		what exactly is compare to method in string
		System.out.println("Compare to method " + "Shivam".compareToIgnoreCase("abc"));
		foods.forEach(System.out :: println);
		foods.sort(String :: compareToIgnoreCase);
		foods.forEach(System.out :: println);
		
		
		
		
	}
}
