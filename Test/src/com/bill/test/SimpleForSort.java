package com.bill.test;

import java.util.Random;

public class SimpleForSort {
	public static void main(String[] args) {
		/*生成随机数组并升序排列*/
		Random r = new Random();//生成随机数组
		int[] arr = new int[10000];
		for (int i = 0; i < 10000; i++) {//生成随机数组
			arr[i] = (int) (r.nextDouble() * 10000);
		}

		for (int i = 0; i < 10000 - 1; i++) {//随机数组排序
			for (int j = 0; j < 10000 - 1 - i; j++) {
				int tmp = 0;
				if (arr[j] > arr[j + 1]) {
					tmp = arr[j + 1];
					arr[j + 1] = arr[j];
					arr[j] = tmp;
				}
			}
		}
		/* 求表示各个数字个数的二位数组*/
		int sum = 1;//有sum个不同的数字
		for (int i = 0; i < 10000-1; i++) {
			if (arr[i] != arr[i + 1]) {//数字跃迁n次就有n+1个不同的数字
				sum++;
			}
		}
	    int index = 0;//光标值
		int standard = 0;//上一个光标值，即标准
		int count = -1;//不同数字组成的升序数组的光标值
		int[][] arrCounter = new int[sum][2];//在arrCounter中存储sum个不同数字的 个数 和 值
		while (true) {

			count++;//处理arrCounter数组中下标为count的数

			if (arr[index] != arr[index + 1]) {//当数组跃迁时为一次数字变动, 即光标刚扫描完成一个数字。
				arrCounter[count][0] = index + 1 - standard;//下标为count的数字的个数
				arrCounter[count][1]=arr[index];//下标为count的数字的值
				standard = index + 1;//标准后移一位

			}
			index++;//光标后移一位
			if ((count+1) == sum) {//当处理完sum个数后结束循环
				break;
			}
		}
		/*将二位数组根据数字的个数降序排列*/
		for(int i=0;i<sum;i++){
			for(int j=0;j<sum-1-i;j++){
				if(arrCounter[j][0]<arrCounter[j+1][0]){
					int tmp0=0;
					int tmp1=0;
					tmp0=arrCounter[j+1][0];
					arrCounter[j+1][0]=arrCounter[j][0];
					arrCounter[j][0]=tmp0;
					tmp1=arrCounter[j+1][1];
					arrCounter[j+1][1]=arrCounter[j][1];
					arrCounter[j][1]=tmp1;
				}
			}
		}
		/*把结果按数字个数的大小降序输出10个*/
		for(int i=0;i<10;i++){
			System.out.println("有"+arrCounter[i][0]+"个"+arrCounter[i][1]);
		}
	}

}
