package com.bill.test.try100;

import java.util.ArrayList;
import java.util.List;

public class Question {

private static List<Integer> sumList = new ArrayList<Integer>() ;

	public static void main(String[] args) {
	
		TryTest.group("", "+-o");
		System.out.println(TryTest.list.size());
		new Question().init();
		
		System.out.println(sumList.size());
		int max = new Question().sort();
		System.out.println("max:"+max);
		
		int min = new Question().getMin();
		System.out.println("min:"+min);
	}
	
	
	public void init() {
		
		this.operate();
	}
	
	public void operate() {
	
		MyStack<Integer> intStack = new MyStack<Integer>();
		MyStack<String> strStack = new MyStack<String>();
		
		for (int i = 0 ; i < TryTest.list.size(); i++) {
			intStack.clear();
			strStack.clear();
			for (int t = 9 ; t > 0 ; t--) {
				intStack.push(t);
			}
		
			for (int j = TryTest.list.get(i).length() ; j > 0 ; j--) {
				strStack.push(TryTest.list.get(i).substring(j-1,j));
			}  
			this.calculate( intStack , strStack);
		} 
	}
	
	public void calculate(MyStack<Integer> intStack, MyStack<String> strStack) {
		int size = intStack.getStatckSize();
		int strStackSize = strStack.getStatckSize();
		
		/*for (int i = 0; i < size; i++) {
		System.out.println(intStack.pop());
		}*/
		int temp = intStack.pop();
		for (int i = 0; i < strStackSize; i++) {
		
			switch (strStack.pop()) {
				case "+":
				temp+=intStack.pop();
				
				break;
				case "-":
				temp-=intStack.pop();
				
				break;
				case "o":
				temp=Integer.parseInt(temp+""+intStack.pop());
				
				break;
				
				default:   
				break;
			}
		}
		System.out.println(temp);
		sumList.add(temp);
	}
	
	public int sort(){
	
		int max = sumList.get(0) ;
		for (int i = 0; i < sumList.size()-1; i++) {
			if(max < sumList.get(i+1)){
			max = sumList.get(i+1);
			}
		}
		return max;
	}
	
	public int getMin(){
	
		int min = sumList.get(0) ;
		for (int i = 0; i < sumList.size()-1; i++) {
			if(min > sumList.get(i+1)){
			min = sumList.get(i+1);
			}
		}
		return min;
	}
}