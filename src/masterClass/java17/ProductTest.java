package masterClass.java17;

import java.math.BigDecimal;

public class ProductTest {

//	@Test
	 static void createProduct() {
		
		//given
		Product prd = new Product("IPhone",new BigDecimal(199),"ELECTRONICS");
		
		//when
		//record provides you default implementation of toString and some methods like getters
		System.out.println(prd);
//		assertsThat(prd.cost(),new BigDecimal(199));
		System.out.println(prd.cost().equals(new BigDecimal(199)));
		
		
		//then
		
	}
	 
	public static void validatingInput() {
		var prd = new Product("",new BigDecimal(0),"up");
	}
	 
	public static void customConstructor() {
		var prd = new Product("hero", new BigDecimal(2));
	}
	
	public static void comparisonBetweenObjects() {
		var prd = new Product("hero",new BigDecimal(100),"yo");
		var prd1 = new Product("hero",new BigDecimal(100),"yo");
		//so all will be provided by the record like comparison.
		
		// if we want to compare few values not all then we can overide the equals and hashcode method.
		System.out.println(prd.equals(prd1));
	}
	
	public static void main(String[] args) {
		createProduct();
//		validatingInput();
		//see due to this only we will use junit 5 to test our method implementation if we get
		//exception further test case will not be executer.
		customConstructor();
		comparisonBetweenObjects();
	}

}
