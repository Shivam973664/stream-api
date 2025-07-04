package masterClass.Common.defaultStaticLearning;

public class Client14 implements Interface1,Interface4{
//default method can't be created inside class
	//the only way to remove compile time exception by oberriding the default method in the class
	public void methodA() {
		System.out.println("Inside Method A " + Client14.class);
	}
	
	public static void main(String[] args) {
		Client14 c1 = new Client14();
		c1.methodA();
	}

}
