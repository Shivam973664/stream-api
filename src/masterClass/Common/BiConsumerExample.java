package masterClass.Common;

import java.util.function.BiConsumer;

public class BiConsumerExample {

	
	public static void main(String[] args) {
		BiConsumer<String, String> bc1 = (a,b)-> System.out.println(a.toUpperCase()+" " + b.toUpperCase());
		bc1.accept("Shivam", "Singh");
		
		BiConsumer<Integer,Integer> bvm = (a,b) -> System.out.println("Mulply "+ a*b);
		BiConsumer<Integer,Integer> bvd = (a,b) -> System.out.println("Divide" + a/b);
		BiConsumer<Integer,Integer> bva =(a,b) -> System.out.println("Add" + (a+b));
		bvm.andThen(bva).andThen(bvd).accept(10, 2);
		
		
	}

}
