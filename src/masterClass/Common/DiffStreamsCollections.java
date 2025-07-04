package masterClass.Common;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class DiffStreamsCollections {

	public static void main(String[] args) {
		//steam cannot be modified.
		List<String> names = Arrays.asList("shiv","Shankar","nilkhant");
//		names.remove(0);
//		names.forEach(System.out:: println);
		for(String name : names) {
			System.out.println(name);
		}
		for(String name : names) {
			System.out.println(name);
		}
//		names.stream().remo
		
//		+ streams can not be reitereate again
		Stream<String> s1 = names.stream();
		s1.forEach(s-> System.out.println(s));
//		s1.forEach(System.out :: println); //stream has already been operated upon or closed

		
		
	}

}
