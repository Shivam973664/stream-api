package masterClass.Common.defaultStaticLearning;

public interface Interface2 extends Interface1{

	default void methodB() {
		System.out.println("Inside Method B");
	}
	
	//so classs b extends interface 1
	//after adding this method of interface 1 will not be called
	default void methodA() {
		System.out.println("Inside Method A " + Interface2.class);
	}
}
