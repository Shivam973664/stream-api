package masterClass.runnableandCompartor;

import java.util.Comparator;

public class ComparatorExample {

	public static void main(String[] args) {
		//by using old methodology
		Comparator<Integer> cl = new Comparator<Integer>() {
			

			@Override
			public int compare(Integer i1, Integer i2) {
				return i1.compareTo(i2);
			}
		};
		System.out.println(cl.compare(1, 2));
		Comparator<Integer> cm = ( a, b)-> a.compareTo(b);
		
		System.out.println(cm.compare(2, 1));
	}

}
