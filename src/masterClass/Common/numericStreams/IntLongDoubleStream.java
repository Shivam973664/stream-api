package masterClass.Common.numericStreams;

import java.util.Arrays;
import java.util.List;

public class IntLongDoubleStream {

	public static int numericStream(List<Integer> list) {
		return list.stream().reduce((a,b)-> a*b).get(); //there is unboxing of the type will take place here
	}
	
	public static int usingIntStream() {
		return java.util.stream.IntStream.range(1, 6).reduce(1, (a,b) -> a*b);
	}
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1,5);
		System.out.println(numericStream(list));
		//what is the use if we can't even send custom list
		System.out.println(usingIntStream());
		
	}

}
