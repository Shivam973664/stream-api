package masterClass.Common;

import java.util.function.Consumer;

public class LambdaVariable {

	private static String Rk = "RK";
	public static void main(String[] args) {
		String s = "Shivam";
		
		Consumer<String> c1 = (si) -> {
			System.out.println(s);
			Rk = "djsdkj";
//			s="k";
//			String sk = "K";
		};
		
		c1.accept("Shiv");
		System.out.println(Rk);
	}

}
