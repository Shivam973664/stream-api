package masterClass.Common.parallalStream;

import java.util.stream.IntStream;

public class DrawBackPart2ValueGoneWrong {

	public static void main(String[] args) {
		Sum s = new Sum();
//		int k=1;
		
		//parallal stream use
		//2. 1000 loop run
		//3. you are setting the value which is in this scope
		//4. what if you have only one variable then see what happen
//		then you will get effective final exception
		
		
		IntStream.rangeClosed(1, 1000)
		.parallel()
//		.forEach(a-> k=a);
		.forEach(s ::setTotal);
//		.forEach(a-> s.setTotal(a));
		
		//if you keep running above code you will get different values
		System.out.println(s.getTotal());
//		System.out.println(k);
		
		
	}
}
