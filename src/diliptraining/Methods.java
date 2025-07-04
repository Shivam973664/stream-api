package diliptraining;

import java.util.List;
import java.util.stream.Collectors;

public class Methods {
	public static void main(String[] args) {

		//If we want to create list and we have values we can use List.of(
		List<String> names= List.of("Aman","Rahul","Triveni","express");
		List<Integer> numbers= List.of(1,3,5,67,3);
		/////filter(takes predicate as input)
		//predicate is an simply boolean expression or we use lambda expression which returns boolean
		///using lambda
		//e-> e>10
		//e-> {return true/false expr}

		List<String> filterout= names.stream().filter(e->{
		return e.startsWith("A"); ///e.charAt(0) =='A';
				}).collect(Collectors.toList());
		
		List<String> filterout1= names.stream().filter(e->e.startsWith("1")).collect(Collectors.toList());
		
		
		System.out.println("Filtered list :"+ filterout);
		
		////////map : we can perform operation for each elements 
		///map(takes function) function will return value
		//square the number then return the new list
		List<Integer> nummbermap = numbers.stream().map(e-> e*e).collect(Collectors.toList());;
		nummbermap.stream().sorted().forEach(System.out:: println);
		Integer maxvalue = nummbermap.stream().max((x,y) -> x.compareTo(y)).get();
		System.out.println("Max value : " + maxvalue);
		System.out.println("Mapped List : " + nummbermap);
		
		
	}

}
