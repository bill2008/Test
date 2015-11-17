package com.bill.test;

import java.util.Date;
import java.util.Random;

public class RandSort {

	private static Random r = new Random(new Date().getTime());
	private static int[] N = new int[10000];
	static {
		for (int i =0; i< N.length;i++) {
			N[i] = r.nextInt(30); 
		}
	}
	
	/*
	 * countSort计数排序的实现
	 */
	public static int[] countSort(int a[], int k) {  
        int[] b = new int[a.length];  
        int[] c = new int[k];  
        for (int i = 0; i < c.length; i++) {  
            c[i] = 0;  
        }  
        for (int i = 0; i < a.length; i++) {  
            c[a[i]] += 1;  
        }  
        for (int i = 0; i < c.length; i++) {  
            if (i != 0) {  
                c[i] += c[i - 1];  
            }  
        }  
        for (int i = a.length - 1; i >= 0; i--) {  
            b[c[a[i]] - 1] = a[i];  
            c[a[i]] = c[a[i]] - 1;  
        }  
        return b;  
    } 
	
	/** 
     *  基数排序 
     * @param result  最终已排序的数组，共用一个节省空间 
     * @param maxLen  待排序的数组中最大的位数 
     */  
    public static void radixSort(int[] a,int[] result, int maxLen) {  
        int flag = 1;  
        // 保存每轮要排序的位对应数组a的值  
        int [] digitArr = new int[a.length];  
        for(int i=0; i < maxLen; i++) {  
            // 共比较的轮数  
            flag *= 10;  
            // b数组中对应的装着a数组中每位的数,第一轮装着各位，第二轮装着十位数...  
            for (int j = 0; j < digitArr.length; j++) {  
                digitArr[j]=a[j]%flag;  
                digitArr[j]=digitArr[j]/(flag/10);  
            }  
            countSort(a, digitArr,result,10);  
            // 每一轮计数排序完后刷新下一轮要排序的数组  
            System.arraycopy(result, 0, a, 0,result.length);  
        }  
    }
	
    /** 
     * 计数排序 :对数组a中的元素按某些位排序 
     * @param tmp  要参与排序的当前位的值保存在tmp中 
     * @param result  每次计数排序后的新的数组顺序 
     */  
    public static void countSort(int a[], int tmp[], int result[], int k) {  
        int[] c = new int[k];  
        for (int i = 0; i < c.length; i++) {  
            c[i] = 0;  
        }  
        for (int i = 0; i < tmp.length; i++) {  
            c[tmp[i]] += 1;  
        }  
        for (int i = 0; i < c.length; i++) {  
            if (i != 0) {  
                c[i] += c[i - 1];  
            }  
        }  
        for (int i = tmp.length - 1; i >= 0; i--) {  
            // 和计数排序唯一的差别在于赋值的时候用真实的数据  
            result[c[tmp[i]] - 1] = a[i];  
            c[tmp[i]] = c[tmp[i]] - 1;  
        }  
    } 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = new int[N.length]; 
		radixSort(N,a, 3);
		System.out.println(a);
	}

}
