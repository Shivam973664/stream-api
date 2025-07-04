package masterClass.Common.defaultStaticLearning;

import java.util.Arrays;
import java.util.List;

public class MultiplierClient {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1,24,5,1,3,6);
		Multiplier mul = new MultiplierImpl();
		System.out.println("Showing multiplication " + mul.multiply(list));
		
		//default method
		System.out.println(mul.sizeOfList(list));
		//default method can not be called by class name
//		System.out.println(Multiplier.si);
	
		//Static method
		System.out.println("Calling Static method from interface" + Multiplier.isEmptyMethod(list));
//		System.out.println("Calling static method from implemented class name" + MultiplierImpl.); not able to call it
//		System.out.println("calling static method from instance + "+ mul.e);
	}

}
