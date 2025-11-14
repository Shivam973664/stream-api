package abc.test;

import java.util.Arrays;

public class MagnitITRoundFinal {

	
	
	//Multiple of 10 converter
	//The input is an array of integers, go through the array, once you find a number 
	//that's multiple of 10 (10, 20, 30, etc.), the numbers 
	//following it are changed to that number, until you find the next multiple of 10.
	//example:
	//int input[] =  {28,7,30,84,29,74,50,37,85,74,60,63,65,90,82}
	//int output[] = {28,7,30,30,30,30,50,50,50,50,60,60,60,90,90}
	
	public static void main(String[] args) {
		int []arr = {28,7,30,84,29,74,50,37,85,74,60,63,65,90,82};
		int prev=-1;
//		boolean found=false;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]%10==0) {
				prev=arr[i];
//				found=true;
			}else if(prev!=-1) {
				arr[i]=prev;
			}
		}
		Arrays.stream(arr).forEach(a-> System.out.print(a + " "));
	}
	//Question 2nd : 
	//"I have two buckets, one 5 gallon, one 3 gallon. 
//	I am next to a water faucet and a sink, so I have unlimited supply of water. Using these two buckets, how do I get 4 gallon of water?"
	
	
}
