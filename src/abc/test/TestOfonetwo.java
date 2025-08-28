package abc.test;

import java.util.function.Predicate;

public class TestOfonetwo {

	
	
	public static void main(String[] args) {
		
		
//		Input: A2B3C4
//		Output: AABBBCCCC
///AG12BH13CLL10
		//10AG
//		helper("AG12BH13CLL10");
		againTrying("AG12BH13CLL10");
		
	}
	
	private static void helper(String input) {
		StringBuilder str = new StringBuilder();
		Predicate<Character> pcharacter= (c)-> (c>='A' && c<='Z')
				|| (c>='a' && c<='z');
		Predicate<Character> pnumber= c->  c>='0' && c<='9';
		
//		Character temp='a';
		StringBuilder inputChange= new StringBuilder();
		StringBuilder numberChange= new StringBuilder();
		for(int i=0;i<input.length();i++) {
			Character c= input.charAt(i);
			if(pcharacter.test(c)
					) {
				inputChange.append(c);
				numberChange.setLength(0);
			}else if(pnumber.test(c)) {
				
				numberChange.append(c);
				int tempptr= i+1;
				while(tempptr<input.length() && (pnumber.test(input.charAt(tempptr)) )) {
					numberChange.append(input.charAt(tempptr));
					tempptr++;
				}
				i=tempptr-1;
				
				Integer count= Integer.parseInt(numberChange.toString());
				while(count>0) {
					str.append(inputChange.toString());
					count--;
				}
				inputChange.setLength(0);
			}
		}
		System.out.println(str.toString());
		
		
	}
	
	
	public static void againTrying(String input) {
		int idx=0;
		StringBuilder result = new StringBuilder();
		while(idx<input.length()) {
			StringBuilder text = new StringBuilder();
			StringBuilder numberr= new StringBuilder();
			while((input.charAt(idx)>= 'a' && input.charAt(idx)<='z') || 
					(input.charAt(idx)>= 'A' && input.charAt(idx)<='Z') && idx<input.length() ) {
				text.append(input.charAt(idx));
				idx++;
			}
			
			while(input.charAt(idx)>='0' && input.charAt(idx)<='9' && idx<input.length()) {
				numberr.append(input.charAt(idx));
				idx++;
			}
			Integer num = Integer.parseInt(numberr.toString());
			while(num>0) {
				result.append(text);
				num--;
			}
			
		}
		System.out.println(result.toString());
	}

}
