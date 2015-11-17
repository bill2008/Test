package com.bill.test;

public class Beer {

	private  static final int GAI2BEER = 4;
	private  static final int PING2BEER = 2;

	public static void main(String[] args) {
		
		int beer = 10 / 2;
		int beerSum = 0;
		int gai = 0;
		int ping = 0;
		
		while (beer > 0 || gai >= GAI2BEER || ping >= PING2BEER ) {
			beerSum += beer;
			gai += beer;
			ping += beer;
			
			beer = gai / GAI2BEER + ping / PING2BEER;
			gai %= GAI2BEER;
			ping %= PING2BEER;
		}
		
		System.out.println(beerSum);
		
	}
	
}
