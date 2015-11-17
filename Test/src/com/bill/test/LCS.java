package com.bill.test;

import java.util.ArrayList;
import java.util.List;

public class LCS {

	public static List<String> getLCS(String str1,String str2) {
		
		int len1 = str1.length();
		int len2 = str2.length();
		int maxLen = len1 > len2? len1: len2;
		int[] tmp = new int[maxLen];
		int[] maxCount = new int[maxLen];
		int[] maxIndex = new int[maxLen];
		
		for (int i = 0;i<len2;i++) {
			for (int j = len1 -1;j>=0;j--) {
				if (str2.charAt(i) == str1.charAt(j)) {
					if (i==0 || j == 0) {
						tmp[j] = 1;
					} else {
						tmp[j] = ++tmp[j-1]; 
					}
				} else {
					tmp[j] = 0;
				}
				
				if (tmp[j] > maxCount[0]) {
					maxCount[0] = tmp[j];
					maxIndex[0] = j;
					for (int k=1;k<maxLen;k++) {
						maxCount[k] = 0;
						maxIndex[k] = 0;
					}
				} else if (tmp[j] == maxCount[0]) {
					for (int k=0;k<maxLen;k++) {
						if (maxCount[k] == 0) {
							maxCount[k] = tmp[j];
							maxIndex[k] = j;
							break;
						}
					}
				}
			}
		}
		List<String> ret = new ArrayList<String>();
		for (int j=0;j<maxLen;j++) {
			if (maxCount[j] > 0) {
				String sub = str1.substring(maxIndex[j] -  maxCount[j] + 1 ,maxIndex[j] + 1 );
				ret.add(sub);
			}
		}
		
		return ret;
	}
	
	public static void main(String[] args) {
		List<String> test = getLCS("i believe i can fly","i can not say goodbye to you");
		for (String sub:test) {
			System.out.println(sub);
		}
	}

}
