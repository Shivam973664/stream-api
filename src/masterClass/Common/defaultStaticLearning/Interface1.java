package masterClass.Common.defaultStaticLearning;

public interface Interface1 {

	///so when we create abstract method then it is mandatory to define it in the class but not in the 
	//interfaces which extends it.
//	public void isInheritingWillCauseProblem();
	
	default void methodA() {
		System.out.println("Inside Method A " + Interface1.class);
	}
}
