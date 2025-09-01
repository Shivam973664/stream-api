package masterClass.java9;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class VarExample {

	//3. var in the class variable is not allowed
//	var inpu= " a" ;
	
	public static void main(String[] args) {
//		List<Integer> list = Arrays.asList(1,3,5);
//		in above case on left hand side again we need to declare type 
//		to prevent this we use lvti (local variable type inference)
		var list = Arrays.asList(1,3,5);
		list.get(0).toString();
		
		//var can also be used for variable type : iterating the for loop
		for(var ele : list) {
			System.out.println(ele);
		}
		
		//ofEntries are factory method to create immutable map
		var map = Map.ofEntries(Map.entry("a", List.of("Apple","Anar")),Map.entry("b", List.of("Banana","Bagan")));
//		for(Map.Entry<String, List<String>> ele : map.entrySet()) {
		for(var ele : map.entrySet()) {
			System.out.println(ele.getKey() + " " + ele.getValue());
		}
		var result = transForm(map.get("a").get(0));
		System.out.println(result);
		
		//limitation Of Using var
		limitationOfVar();
	}
	public static void limitationOfVar() {
//		var input = null; var variable cannot be assigned to null since null can be of any type.
		//2.we can not change the type of the variable created by var 
//		var input = "a";
//		input = 4;
		
		//5. var is not the reserved keyWord in java
		var var  = "no compiler issue";
	}
	
	//4. we can not use var in the function parameter
//	public static String transForm(var str) {
	public static String transForm(String str) {
		return str.toUpperCase();
	}

}
