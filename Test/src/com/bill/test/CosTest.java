package com.bill.test;

public class CosTest {

	public static final double PI=3.14159265358979323846;
	
	public double cos(double x,int n) {
		if (n==0) return 1d;
		return cos(x,n-1) + pow(-1, n) * (pow(x,2*n) / factorial(2*n));
	}
	
	public double pow(double a,int b) {
		double result = 1d;
		for (int i=0;i<b;i++) {
			result = result * a;
		}
		return result;
	}
	
	public double factorial(int n) {
		return n == 0? 1d : n * factorial(n -1);
	}

	
	public static void main(String[] args) {
		CosTest CosTest = new CosTest();
		for (int i=0;i<180;i++) {
			System.out.print(i + " ");
			System.out.print(CosTest.cos(i*1.0/180*PI,300));
			System.out.println(" " + Math.cos(i*1.0/180*PI));
		}
	}

}
