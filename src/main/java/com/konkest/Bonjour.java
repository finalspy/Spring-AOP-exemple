package com.konkest;

/**
 * Spring bean
 * 
 */
public class Bonjour implements IHello {
	private String name;

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void printHello() {
		System.out.println("Bonjour ! " + name);
	}
}