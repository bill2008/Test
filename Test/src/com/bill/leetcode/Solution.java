package com.bill.leetcode;

public class Solution {
    
	public static String getHint(String secret, String guess) {
		char[] guesses = guess.toCharArray();
		char[] secrets = secret.toCharArray();
		
		assert (guesses.length == secrets.length) : "guess's lenght not equals secret's  lenght.";
		
		int aCount = 0;
		int bCount = 0;
		
		for (int i=0; i<secrets.length;i++) {
			if (secrets[i] == guesses[i]) { 
				aCount++;
				secrets[i] = '\0';
				guesses[i] = '\0';
				continue;
			}
		}
		for (int i=0; i<secrets.length;i++) {
			if (secrets[i] == '\0') continue;
			for (int j=0; j<guesses.length;j++) {
				if (secrets[i] == guesses[j]) {
					bCount++;
					secrets[i] = '\0';
					guesses[j] = '\0';
					break;
				}
			}
		}
		return aCount + "A" + bCount + "B";
		
    }
    
	public String getHint2(String secret, String guess) {
	    int a=0,b=0;
	    int[] digits=new int[10];
	    for(int i=0;i<secret.length();i++){
	        if(secret.charAt(i)==guess.charAt(i)) a++;
	        else{
	            if(++digits[secret.charAt(i)-'0']<=0) b++;
	            if(--digits[guess.charAt(i)-'0']>=0) b++;
	        }
	    }
	    return a+"A"+b+"B";
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char x = 0;
		System.out.print(x);
		System.out.print(getHint("1807","7810"));
	}

}
