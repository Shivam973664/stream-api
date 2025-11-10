package abc.test.capgemini;

public class RoundOne {
	public static void main(String[] args) {
//		AddTwoNumbersExample add= (a,b)-> {
//			System.out.println(a+b);
//		};
//		add.addTwoNumber(5, 6);
//		AddTwoNumbersExample.exampleStatic();
		
		
//		/write a program to reverse a number
		Integer num =1234;
		int ans=0;
		while(num>0) {
			int digit = num%10;
			ans= ans*10+digit;
			num/=10;
		}
		System.out.println(ans);
		
		
	}
}
//Q= predict the output?
//		//listOfIntegers = {1 to 10}
//		 
//		Stream s = listOfIntegers.stream().filter(i -> i%2 == 0);
//		Sysout()
//		List l1=s.collect(Collector.toList());