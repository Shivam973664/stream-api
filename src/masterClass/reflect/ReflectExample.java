package masterClass.reflect;

import java.lang.reflect.Method;

//superclass example

class Parent{
	
}


class Person extends Parent{
	public void show() {
		
	}
}


public class ReflectExample {

	public static void main(String[] args) {
		//we can create reflect class by below getClass method
		Person p = new Person();
		Class c = p.getClass();
		String className = c.getName();
		System.out.println("Class Name : "+ className);
		Method []method = c.getMethods();
		for(int i=0;i<method.length;i++) {
			System.out.println(method[i].getName());
		}
		//to get data of parent class
		Class parentClass = c.getSuperclass();
//		Class parentParentClass = parentClass.getClass();
//		Class pparentParentClass = parentParentClass.getClass();
		System.out.println("Parent Class Name "+ parentClass.getName());
	}

}
