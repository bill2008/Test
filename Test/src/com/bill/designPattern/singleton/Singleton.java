package com.bill.designPattern.singleton;

public class Singleton {
	
	private static Singleton singleton = new Singleton();
	
	private Singleton(){}
	public static Singleton getInstance(){
		return singleton;
	}
}

