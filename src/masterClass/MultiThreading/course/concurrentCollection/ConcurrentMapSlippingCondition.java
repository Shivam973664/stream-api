package masterClass.MultiThreading.course.concurrentCollection;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentMapSlippingCondition {

	public static void main(String[] args) {
		ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<Integer, Integer>();
//		to avoid slipping condition use putIfAbsent
		map.putIfAbsent(1, 1);
	}
}
