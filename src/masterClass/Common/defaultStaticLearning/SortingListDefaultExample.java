package masterClass.Common.defaultStaticLearning;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortingListDefaultExample {

	public static void main(String[] args) {
		List<String>  list = Arrays.asList("shivam","singh","abhishek","rakesh");
		
		//before java 8
//		Collections.sort(list);
//		System.out.println(list);
		
		//now in java 8. list interface have sort default method which we can use to sort
		list.sort(Comparator.naturalOrder());
		System.out.println(list);
		
		//reversing a list
		list.sort(Comparator.reverseOrder());
		System.out.println(list);
		
		
	}
}
