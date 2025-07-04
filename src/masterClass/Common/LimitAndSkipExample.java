package masterClass.Common;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class LimitAndSkipExample {

	public static void limitExample(List<Integer> integers) {
		Optional<Integer> sum =integers.stream().limit(4).reduce(Integer::sum);
		
		if(sum.isPresent()) {
			System.out.println("Sum : " + sum.get());
		}else {
			System.out.println("No value found");
		}
	}
	
	public static void skipExample(List<Integer> list) {
		Optional<Integer> value = list.stream().skip(2).reduce(Integer::max);
		if(value.isPresent()) {
			System.out.println(value.get());
		}else {
			System.out.println("No value found");
			
		}
	}
	
	public static void main(String[] args) {
//		List<Integer> integers = List.of(6,3,4,2);
		List<Integer> integers = Arrays.asList(60,7,8,9,10);
		limitExample(integers);
		skipExample(integers);
	}

}
