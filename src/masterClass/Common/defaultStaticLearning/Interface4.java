package masterClass.Common.defaultStaticLearning;

public interface Interface4 {

	//the only difference here is it doesn't extends interface1 
	// now if we have class which implements both inter1 and 4 then we will get compile time
	//exception
	default void methodA() {
		System.out.println("Inside Method A " + Interface4.class);
	}
}
