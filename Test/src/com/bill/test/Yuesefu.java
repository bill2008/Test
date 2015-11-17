package com.bill.test;

public class Yuesefu {

	/**
	 * @param seven
	 */
	public static void main(String[] args) {
		final int N=26,s=1,m=3;
		int i=s-1,j,k=N,g=1;
		int a[]=new int[N];
		for(int h=1;h<=N;h++){
			a[h-1]=h;
		}
		System.out.println("出圈的顺序为");
		do {
			i=i+(m-1);
			while (i>=k){
				i=i-k;
			}
			System.out.print("\t"+a[i]);
			for(j=i;j<k-1;j++){
				 a[j]=a[j+1];
			}
			k--;
			g++;
		}while(g<=N);
	}

}