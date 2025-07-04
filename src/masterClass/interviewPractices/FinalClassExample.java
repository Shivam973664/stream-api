package masterClass.interviewPractices;

import java.util.ArrayList;
import java.util.List;

public  class FinalClassExample {

	private static final String num="Shivam";
	private static final List<String> names = new ArrayList<>() ;
	private static final int []ar = new int[] {12,3,5};
	
	
	public static void main(String[] args) {
//		names.add("sjd");
		System.out.println(num);
		///variable value can not be changed
		/// if we reference variable
		names.add("shivam");
		ar[0]=1;
		System.out.println(names + "" + ar[0]);
	}


	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	
	

}
