package com.bill.designPattern.factory;

public class Client {

	public static void main(String[] args) {
		IFactory factory = new Factory();
		IProduct product = factory.createProduct();
		product.productMethod();
	}

}
