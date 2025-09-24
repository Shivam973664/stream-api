package abc.test.ey.round1;


class A{
	private static A a;
	
	private String name ="";
	
	private A() {
		
	}
	
	public synchronized static A getInstance() {
		if(A.a==null) {
			a= new A();
			return a;
		}else {
			return a;
		}
	}
	
}