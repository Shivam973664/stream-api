package masterClass.Common.defaultStaticLearning;

import java.util.List;

public class MultiplierImpl implements Multiplier{

	@Override
	public int multiply(List<Integer> list) {
		return list.stream().reduce(1, (a,b)-> a*b);
	}

	@Override
	public int sizeOfList(List<Integer> list) {
		// TODO Auto-generated method stub
		System.out.println("Inside implemented class");
		return list.size();
	}
	
	//the only difference between default and static method is default method can be override in the implemented class
	
}
