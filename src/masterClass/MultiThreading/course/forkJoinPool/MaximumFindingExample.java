package masterClass.MultiThreading.course.forkJoinPool;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

//  thread optimization complete within 3 mili where as not thread optimized :1 - 4
class ParallalMaxFinding extends RecursiveTask<Long> {

	private long[] nums;
	private int left;
	private int right;

	public ParallalMaxFinding(long[] nums, int left, int right) {
		this.nums = nums;
		this.left = left;
		this.right = right;
	}

	@Override
	protected Long compute() {
		if (right - left < 1000) {
			return sequentialMaxFinding();
		} else {
//			we will use parallalization
			int mid = left + (right - left) / 2;
			ParallalMaxFinding task1 = new ParallalMaxFinding(nums, left, mid);
			ParallalMaxFinding task2 = new ParallalMaxFinding(nums, mid + 1, left);

//	1.		invokeAll(task1,task2); 
//	1.		return Math.max(task1.join(),task2.join()); 
			task2.fork();
			return Math.max(task1.compute(), task2.join());
		}

//		return null;
	}

	private Long sequentialMaxFinding() {

		long max = nums[left];

		for (int i = 1; i < right; i++) {
			if (nums[i] > max) {
				max = nums[i];
			}
		}

		return max;
	}

}

public class MaximumFindingExample {

//	linear search := O(n)
//	what if array is sorted
	public static long max(long[] nums) {
		long max = nums[0];
		Arrays.stream(nums).forEach(a-> System.out.print( a + " "));
		System.out.println();
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > max) {
				max = nums[i];
			}
		}
		return max;
	}

	public static void main(String[] args) {
		long[] nums = creaeeNumbers(300000);
		System.out.println("");
		System.out.println(nums);
		System.out.println("now results");
		
		long start = System.currentTimeMillis();
//		417 milliseconds
//		sequentialApproach(nums);
//		3 milliseconds
		parallalExecution(nums);
		

		System.out.println("completed in " + (System.currentTimeMillis()- start));

	}

	private static void parallalExecution(long[] nums) {
		ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
		ParallalMaxFinding task = new ParallalMaxFinding(nums,0 ,nums.length);
		System.out.println("Result : "+ pool.invoke(task));
		
		
	}

	private static void sequentialApproach(long[] nums) {

		
		System.out.println("max number by sequential : " + max(nums));

	}

	private static long[] creaeeNumbers(int n) {
		Random random = new Random();
		long[] nums = new long[n];
		
		
		for (int i = 0; i < n; i++) {
			nums[i] = random.nextInt(1000);
		}
		return nums;
	}
}
