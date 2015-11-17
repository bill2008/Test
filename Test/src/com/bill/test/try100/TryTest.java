package com.bill.test.try100;

import java.util.ArrayList;
import java.util.List;

/**
* 1、2、2、3、4、5这六个数字，用java写一个main函数，打印出所有不同的排列， 如：512234、412345等.要求："4"不能在第三位，"3"与"5"不能相连.
* 
* @author gnn
*/
public class TryTest {
	public static List<String> list = new ArrayList<String>();
	public static int num = 8 ;
	/**
	　　　 * 构造字符串的所有排序组合
	　　　 * @param str 将要组合成的字符
	　　　 * @param nstr 源字符串集
	　　　 */

	public static void group(String str, String nstr) {
		String temp = "";
		addStr(temp, "+");
		addStr(temp, "-");
		addStr(temp, "o");
	}
	public static void addStr(String str, String nstr) {
		if (num != str.length()) {
			String temp = "";
			temp = str + nstr;
			if (temp.length() == num){
				list.add(temp);
			}
			System.out.println(temp);
			addStr(temp, "+");
			addStr(temp, "-");
			addStr(temp, "o");
		}
	}

	public static void main(String[] args) {
		TryTest.group("", "+-o");
		System.out.println(list.size());
	}
}



