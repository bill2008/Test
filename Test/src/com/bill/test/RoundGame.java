package com.bill.test;

public class RoundGame {
	public static void main(String[] args) {
		boolean[] arr = new boolean[26];
		for (int i = 0; i < 26; i++) {
			arr[i] = true;
		}
		int index = 0;// 光标位置,从0开始
		int index1 = -2;// 报1的index
		int index2 = -1;// 报2的index
		int shout = 0;// 报数号数

		do {
			if (index == 26) {// 光标到26时归零，代表围成一圈
				index -= 26;
			}
			if (arr[index] == true) {//轮到值为index的人
				shout++;// 报数（从1开始）
				switch (shout % 3) {
				case 0:
					arr[index] = false;//报3出列
					break;
				case 1:
					index1 = index;//记下报1的人的index值
					break;
				case 2:
					index2 = index;//记下报2的人的index值
					break;
				}
			}
			index++;
		} while (index2 != index1);// 当报1和报2为同一个光标位置时，得到所求index，退出循环

		char[] cha = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
				'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
				'X', 'Y', 'Z' };
		for(int i=0;i<26;i++){
			System.out.println(arr[i]+" "+i);//测试游戏后出列的人和在列的人
		}
		System.out.println(cha[index2]+" "+index2);//输出最后在列的人
	}
}