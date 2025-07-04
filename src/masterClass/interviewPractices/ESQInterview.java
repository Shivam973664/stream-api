package masterClass.interviewPractices;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ESQInterview {

	public static void codingQuestionToReplaceVowels(String input) {
		Stack<Character> stack= new Stack<>();

		int l= input.length();

		int lptr=0;
		int rptr = l-1;

		List<Character> list = Arrays.asList('A','a','e','E','i','I','o','O','u','U' );

		for(int i=0;i<l;i++){
			Character c= input.charAt(i);
			if(list.contains(c)){
				stack.push(c);
			}

		}
		StringBuilder str= new StringBuilder();

		for(int i=0;i<l;i++){
			Character c= input.charAt(i);
			if(list.contains(c)){
				Character temp = stack.pop();
				str.append(temp);
			}else{
				str.append(c);
			}

		}
		System.out.println(str.toString());
	}
	
	public static void main(String[] args) {
		codingQuestionToReplaceVowels("I am a java developer");
	}

}
