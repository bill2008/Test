package com.bill.test;

public class PrintUntil {
	
	public static void main(String[] args) {
		print('*',5);
	}
	
	public static void print(char c,int number) {
		assert number < 1 : "number must big then 0";
		char[] chars = new char[number];
		printChars(chars,c,1);
	}
	
	private static void printChars(char[] chars,char c,int rowNumber) {
		chars[rowNumber - 1] = c;
		System.out.println(chars);
		if (rowNumber < chars.length)
					printChars(chars,c,rowNumber + 1);
	}
}
