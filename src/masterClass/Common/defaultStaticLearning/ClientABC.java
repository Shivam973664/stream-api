package masterClass.Common.defaultStaticLearning;

public class ClientABC implements Interface1,Interface2,Interface3{
	
	//Precedence
	//1. Class that implements the interface
	//2. the sub interface that extends the interface.

	//after declaring this method now method of interface2 will not be called.
	public void methodA() {
		System.out.println("Inside Method A " + ClientABC.class);
	}
	
	public static void main(String[] args) {
		
		//we are creating one relationship 
		//interface2 overrides method of interface1 and interface3 will overrides method of interface2
		ClientABC clientABc= new ClientABC(); // always resolve to the child class/implementation class
		clientABc.methodA();
		clientABc.methodB();
		clientABc.methodC();
	}

}
