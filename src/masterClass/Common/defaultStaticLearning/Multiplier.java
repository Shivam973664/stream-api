package masterClass.Common.defaultStaticLearning;

import java.util.List;

public interface Multiplier {

	public int multiply(List<Integer> list);
	
	//so we are creating one default method size which will simply give the size of the list
	public default int sizeOfList(List<Integer> list) {
		System.out.println("Inside Interface ");
		return list.size();
	}
	
	//static method: we can only call this method using name of interface/class not instance
	public static boolean isEmptyMethod(List<Integer> list) {
		return list !=null && list.size()>=1;
	}
}
