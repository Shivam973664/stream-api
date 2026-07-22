package masterClass.MultiThreading.course.forkJoinPool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

class SimpleTaskForkJoinPoolNoReturn extends RecursiveAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int steps;

	public SimpleTaskForkJoinPoolNoReturn(int steps) {
		this.steps = steps;
	}

	@Override
	protected void compute() {

		if (steps > 100) {
			System.out.println("currently we are processing this step :- " + steps);

			SimpleTaskForkJoinPoolNoReturn firstInstance = new SimpleTaskForkJoinPoolNoReturn(steps / 2);
			SimpleTaskForkJoinPoolNoReturn secondInstance = new SimpleTaskForkJoinPoolNoReturn(steps / 2);

//			it will execute the task in asynchronously .
//			firstInstance.fork();
//			secondInstance.fork();

//			it will return the result once the computation is completed
//			firstInstance.join();
//			secondInstance.join();

//			it will execute the task + wait + return the result once completion
			invokeAll(firstInstance, secondInstance);

		} else {
			System.out.println("Processing steps :- " + steps);
		}

	}

}

//Exercise :- print integer in the list

class PrintIntegerListTask extends RecursiveAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Integer> list;
	int left;
	int right;

	public PrintIntegerListTask(List<Integer> list, int left, int right) {
		this.list = list;
		this.left = left;
		this.right = right;
	}

	@Override
	protected void compute() {
		if (left > right) {
			System.out.println("left index should be smaller than right index ******");
//			return;
		} else if (left == right) {
			System.out.println("Processed Element is := " + list.get(left));
//			return;
		} else {
			System.out.println("Currently Processing : " + left + " to " + right);
			int mid= left+ (right-left)/2;
			PrintIntegerListTask leftProcessor = new PrintIntegerListTask(list, left, mid);
			PrintIntegerListTask rightProcessor = new PrintIntegerListTask(list, mid + 1, right);

			invokeAll(leftProcessor, rightProcessor);
		}
	}

}

class PrintIntegerListTaskSolution extends RecursiveAction{
	
	List<Integer> list;
	
	public PrintIntegerListTaskSolution(List<Integer> list) {
		this.list= list;
	}

	@Override
	protected void compute() {
		if(list.size()<2) {
			System.out.println("Processed element is :" + list.get(0));
		}else {
			System.out.println("Dividing the list of size "+ list.size());
			List<Integer> left = list.subList(0, list.size()/2);
			List<Integer> right = list.subList( list.size()/2 , list.size());
			
			PrintIntegerListTaskSolution leftProcessor= new PrintIntegerListTaskSolution(left);
			PrintIntegerListTaskSolution rightProcessor= new PrintIntegerListTaskSolution(right);
			
			invokeAll(leftProcessor,rightProcessor);
			
		}
		
	}
	
}

public class ForkJoinPoolExample {

	public static void main(String[] args) {
//		firstExample();
//		printIntegerExercise();
		printIntegerSolution();
	}

	private static void printIntegerSolution() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		PrintIntegerListTaskSolution print = new PrintIntegerListTaskSolution(list);
		print.invoke();
	}

	private static void printIntegerExercise() {
//		ForkJoinPool forkJoinPool = new ForkJoinPool();
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		PrintIntegerListTask printIntegerListTask = new PrintIntegerListTask(list, 0, list.size() - 1);
		try {
			printIntegerListTask.invoke();
		} catch (Exception e) {
			System.out.println("exception :" + e.getMessage());
//			e.printStackTrace();
		}

	}

	private static void firstExample() {
		int numberOfProcessors = Runtime.getRuntime().availableProcessors();
		System.out.println(numberOfProcessors);
//		if default than the pool size will be equal number of processor we have in our system
		ForkJoinPool forkJoinPool = new ForkJoinPool();

		SimpleTaskForkJoinPoolNoReturn root = new SimpleTaskForkJoinPoolNoReturn(800);
		root.invoke();

	}
}
