package com.konkest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring-modules.xml");

		IHello obj = (IHello) context.getBean("bonjour");
		obj.printHello();
		IHello obj2 = new IHello() {

			@Override
			public void printHello() {
				System.out.println("Hola ! " + getName());

			}

			private String getName() {
				return " Juan ";
			}

			@Override
			public void setName(String name) {
				System.out.println("not set : " + name);

			}
		};
		obj2.printHello();
		obj.setName("John");
		obj.printHello();
	}
}