package com.bill.test;

import java.util.Date;
import java.util.Random;

public class Rand {

	private static Random r = new Random(new Date().getTime());
	private static int[] N = new int[10000];
	private static int[][] ret = new int[10][2];
	static {
		for (int i =0; i< N.length;i++) {
			N[i] = r.nextInt(20); 
		}
		for (int i =0; i<10;i++) {
			ret[i][0] = Integer.MIN_VALUE;
			ret[i][1] = 0;
		}
	}
	
	
	public static void main(String[] args) {
		quicksort(0,N.length-1);
		int start = 0;
		for (int i =0; i< N.length;i++) {
			if (N[i] != N[start]) {
				addData2Ret(N[start],i-start);
				start = i;
			}
		}
		
		for (int i =0; i< ret.length;i++) {
			System.out.print(ret[i][0] + ":" + ret[i][1] + " ");
		}
	}
	
	private static void addData2Ret(int value,int count) {
		if (ret[9][1] >= count) {
			return;
		} else {
			ret[9][0] = value;
			ret[9][1] = count;
		}
		for (int i = ret.length-2; i>=0; i--) {
			if (ret[i][1]>ret[i+1][1]) {
				return;
			} else {
				int tmp1 = ret[i][0];
				int tmp2 = ret[i][1];
				ret[i][0] = ret[i+1][0];
				ret[i][1] = ret[i+1][1];
				ret[i+1][0] = tmp1;
				ret[i+1][1] = tmp2;
			}
		}
	}

	private static void quicksort(int left,int right) {
		int i,j,t,temp;
		if (left > right)
			return;
		
		temp = N[left]; //temp中存的是基准数
		i = left;
		j = right;
		while (i != j) {
			//先从右往左找
			while (N[j]>=temp && i<j)
				j--;
			//再从左往右找
			while (N[i]<=temp && i<j)
				i++;
			//交换两个数在数组中的位置
			if (i<j) {
				t=N[i];
				N[i]=N[j];
				N[j]=t;
			}
		}
		//最终将基准数归位
		N[left]=N[i];
		N[i]=temp;
		
		quicksort(left,i-1);
		quicksort(i+1,right);
	}
}
