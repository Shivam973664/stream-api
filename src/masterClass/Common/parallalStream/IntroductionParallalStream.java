package masterClass.Common.parallalStream;

import java.util.function.Supplier;
import java.util.stream.IntStream;

public class IntroductionParallalStream {

	public  static long checkPerformanceOfStreams(Supplier<Integer> supplier,Integer numnerOftimes) {
		long startTime = System.currentTimeMillis();
		for(int i=0;i<numnerOftimes;i++) {
			supplier.get();
		}
		long endTime = System.currentTimeMillis();
		return endTime-startTime;
	}
	
	public static int withoutPS() {
		return IntStream.rangeClosed(1, 100000)
				.sum();
	}
	
	public static int withPS() {
		return IntStream.rangeClosed(1, 100000)
				.parallel()
				.sum();
	}
	
	public static void main(String[] args) {
		
//		System.out.println(withoutPS());
//		System.out.println(withPS());
//		why it is taking time when we call the parallal stream first
		System.out.println(Runtime.getRuntime().availableProcessors());
		System.out.println(checkPerformanceOfStreams(IntroductionParallalStream:: withPS, 20));
		System.out.println(checkPerformanceOfStreams(IntroductionParallalStream:: withoutPS, 20));
		
	}
}
