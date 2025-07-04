package masterClass.Common;

import java.util.Comparator;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class UnaryOperatorExample {
	static UnaryOperator<String> uo = (a) -> a.toUpperCase();
	
	static BinaryOperator<Integer> bo = (a,b)-> a*b;
	
	static Comparator<Integer> comp = (a,b) -> a>b ?0:1; 
	
	
	public static void main(String[] args) {
		System.out.println(uo.apply("shivam"));
		System.out.println(bo.apply(5, 32));
		System.out.println(BinaryOperator.maxBy(comp).apply(5, 7));
	}
}
