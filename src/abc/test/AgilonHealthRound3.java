package abc.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class ThreadExample extends Thread{

	@Override
	public void run() {
		System.out.println("First Thread");
	}
}

class Thread2 extends Thread{

	@Override
	public void run() {
		System.out.println("Second thread");
	}
}


class CommonExample {
	


	public synchronized void sayHello() {
		System.out.println("Hello");
	}
	public synchronized void sayHi() {
		System.out.println("Hi");
	}
	
	public synchronized void commonMethod(String task) {
		if(task.equals("task1")) {
			sayHello();
		}else {
			sayHi();
		}
		
	}
}

interface PasswordValidator {

	public boolean isCorrect(String password);
}


 class MaxLength implements PasswordValidator{

	@Override
	public boolean isCorrect(String password) {
		return password.length()<=18;
	}

}

 
 class SpecialValidator implements PasswordValidator {

	@Override
	public boolean isCorrect(String password) {
		Set<Character> set= new HashSet<>(List.of('$','%'));
		return password.chars().mapToObj(c-> (char)c).anyMatch(a-> set.contains(a));
	}

}



public class AgilonHealthRound3 {
	public static void main(String[] args) {

//		helper("password");
//		ThreadExample t1 = new ThreadExample();
//		Thread2 t2 = new Thread2();
//		t1.run();
//		t2.run();
//		CommonExample c1 = new CommonExample();
//		Runnable r1 = ()-> {
//			CommonExample c1 = new CommonExample();
//			c1.commonMethod("task1");
//		};
//		Runnable r2 = ()-> {
//			CommonExample c1 = new CommonExample();
//			c1.commonMethod(null);
//		};
//		ExecutorService exe = Executors.newFixedThreadPool(2);
////		exe.submit(r1);
////		exe.submit(r2);
//		int input = 5;
//		
////		while(input>0) {
//			exe.submit(r1);
//			
//			exe.submit(r2);
//			input--;
//		}
//		findUniquePairs();
		
		
	}
	
	private static void findUniquePairs() {
		int []input = {2,2,6,4,8,-2,12,8};
		int target= 10;
		Map<Integer,Integer> map = new HashMap<>();	
		List<List<Integer>> ans = new ArrayList<>();
		for(int i=0;i<input.length;i++) {
			
			if(map.containsKey(target-input[i])) {
				ans.add(List.of(target-input[i],input[i]));
				
				if(map.get(target-input[i])==1) {
					map.remove(target-input[i]);
				}else {
					map.put(target-input[i], map.get(target-input[i])-1);
				}
			}else {
				map.put(input[i],map.getOrDefault(input[i], 0)+1);
			}
		}
		System.out.println(ans);
		
		
		
	}

	public static boolean commonHelper(String input) {
		PasswordValidator ps1 = new MaxLength();
		PasswordValidator ps2= new SpecialValidator();
		
//		PasswordValidator ps3 = new MaxLength();
		return ps1.isCorrect(input) && ps2.isCorrect(input);
	}

	private static void helper(String input) {
		System.out.println(commonHelper(input));
		
		
	}

}