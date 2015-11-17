package com.bill.test;

import java.util.ArrayList;
import java.util.List;

public class Number100 {
	
	private int[] numbers = {1,2,3,4,5,6,7,8,9};
	private String[] operators = {"+","-"," "};
	private List<String> operatorList;
	
	private void createOperators() {
		operatorList = new ArrayList<String>();
		for (String op:this.operators) {
			createNextOperator("",op,numbers.length - 1);
		}
	}
	
	private void createNextOperator(String operators,String nextOperator,int length) {
		if (operators.length() < length) {
			operators = operators + nextOperator;
			if (operators.length() == length) {
				operatorList.add(operators);
			}
			for (String op:this.operators) {
				createNextOperator(operators,op,length);
			}
		}
	}
	
	private List<String> getAllEquation() {
		createOperators();
		List<String> ret = new ArrayList<String>();
		StringBuilder sb;
		for (String operator:operatorList) {
			sb = new StringBuilder();
			for (int i=0;i<numbers.length;i++) {
				sb.append(numbers[i]);
				if (i < operator.length()) {
					char op = operator.charAt(i);
					if (' ' != op) {
						sb.append(op);
					}
				}
			}
			ret.add(sb.toString());
		}
		return ret;
	}
	private int compute(String equation) {
		String[] subEquations = equation.split("\\+");
		int sum = 0;
		for (String subEquation:subEquations) {
			String[] numbers = subEquation.split("\\-");
			if (numbers.length == 1) {
				sum += Integer.parseInt(numbers[0]);
				continue;
			} 
			int subValue = Integer.parseInt(numbers[0]);
			for (int i=1;i<numbers.length; i++) {
				int value = Integer.parseInt(numbers[i]);
				subValue -= value;
			}
			sum += subValue;
		}
		return sum;
	}
	public List<String> getEquationWithValue(int value) {
		List<String> ret = new ArrayList<String>();
		for (String equation: getAllEquation()) {
			if (compute(equation) == value) {
				ret.add(equation);
			}
		}
		return ret;
	}
	public static void main2(String[] args) {
		int value = 100;
		Number100 number100= new Number100();
		List<String> equations= number100.getEquationWithValue(value);
		for (String equation:equations) {
			System.out.println(equation + "=" + value);
		}
		
	}
	
	public static void main(String[] args) {

		int len = (int) (Math.pow(3, 8));// 所有8位3进制数的个数，即十进制下所有符号的可能组合数
		int[] tool = new int[8];// 设置一个8个元素的数组保存8位3进制数
		for (int k = 0; k < len; k++) {// 产生len个3进制数,即产生所有的1~3组成的7位数的组合，每次考察第k种可能性
			int[] aimCheck = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
			/* 产生一个tool数组 */
			int temp = k;
			for (int j = 7; j >= 0; j--) {// num10转换成8位3进制数，保存到数组tool中
				tool[j] = temp % 3;
				temp = temp / 3;
			}

			/* 根据tool进行aim数组的转化 */
			/*
			 * 1代表+ 2代表- 0代表 连接
			 */

			int pro = 10;// 10的幂
			for (int i = 7; i >= 0; i--) {// 从tool的末尾开始遍历,根据tool改变aim各项的值
				if (tool[i] == 1) {// 1, tool中是加号，aim相应的值不变
					pro = 10;
				}
				if (tool[i] == 2) {// 2, tool中是减号，aim相应的值为负
					aimCheck[i + 1] = aimCheck[i + 1] * (-1);
					pro = 10;
				}
				if (tool[i] == 0) {// 0, tool中是空白,aim相应的值加权为一个数
					aimCheck[i] = aimCheck[i] * pro + aimCheck[i + 1];
					aimCheck[i + 1] = 0;
					pro *= 10;
				}

			}
			/* 验证 */
			int sum = 0;
			for (int i = 0; i < 9; i++) {// aim按照tool运算后求和
				sum = sum + aimCheck[i];
			}
			/* 输出 */
			String[] strTool = new String[8];
			int[] aim = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
			if (sum == 100) {// 如果结果为100
				for (int i = 0; i < 8; i++) {
					if (tool[i] == 1) {
						strTool[i] = "+";
					} else if (tool[i] == 2) {
						strTool[i] = "-";
					} else if (tool[i] == 0) {
						strTool[i] = "";
					}
				}
				System.out.println(aim[0] + strTool[0] + aim[1] + strTool[1]
						+ aim[2] + strTool[2] + aim[3] + strTool[3] + aim[4]
						+ strTool[4] + aim[5] + strTool[5] + aim[6]
						+ strTool[6] + aim[7] + strTool[7] + aim[8] + "=100");
			}

		}
	}
}