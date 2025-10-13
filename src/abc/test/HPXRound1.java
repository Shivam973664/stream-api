package abc.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


/*
 * 
 * 1. You are given a list of integers that may contain duplicate elements: 
Write a Java 8 Stream API program to find the third largest unique number from this list.
(1, 3, 2, 1, 4,6, 3, 5, 2, 1, 4).
 */


public class HPXRound1 {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 3, 2, 1, 4,6, 3, 5, 2, 1, 4);
		Integer ans = list.stream().
				distinct().
				sorted(Comparator.reverseOrder()).skip(2).findFirst().orElseThrow();
		
		System.out.println(ans);
	}
}