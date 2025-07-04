package masterClass.interviewPractices;

import java.util.HashMap;
import java.util.Map;

public class WithoutMainClass {
	
	private static String name;

	static {
		
		name="sdj";
		System.out.println(name);
	}
	public static void main(String[] args) {
		Integer name = 1;
		System.out.println(name + WithoutMainClass.name);
		
		try {
			
		}finally {
			System.out.println("finally will be called irrespective of anything");
		}
		
		Map<LinkedInStreamAPIQuestions, String> map = new HashMap<>();
	}

}
