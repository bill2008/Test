package com.bill.test;

import java.util.Date;
import java.util.Random;

public class GameOfLife {

	private static final boolean[][] world = new boolean[10][10];
	private static final boolean[][] world2 = new boolean[10][10];
	
	private static int getNeighborCount(final boolean[][] life,int x,int y) {
		int count = 0;
		if (isLiveNeighbor(life,x - 1,y -1)) count++;
		if (isLiveNeighbor(life,x - 1,y)) count++;
		if (isLiveNeighbor(life,x - 1,y + 1)) count++;
		
		if (isLiveNeighbor(life,x,y - 1)) count++;
		if (isLiveNeighbor(life,x,y + 1)) count++;
		
		if (isLiveNeighbor(life,x + 1,y -1)) count++;
		if (isLiveNeighbor(life,x + 1,y)) count++;
		if (isLiveNeighbor(life,x + 1,y + 1)) count++;
		
		return count;
	}
    private static boolean isValidCell(final boolean[][] life,int x, int y)  
    {  
        if((x >= 0) && (x < life.length) && (y >= 0) && (y < life[0].length))  
        {  
            return true;  
        }  
        else  
        {  
            return false;  
        }  
    } 
	private static boolean isLiveNeighbor(final boolean[][] life,int x,int y) {
		if (isValidCell(life,x,y) && life[x][y]) return true;
		return false;
	}
    
    
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		boolean[][] life = world;
		boolean[][] result = world2;
		boolean[][] tmp;
		Random r = new Random(new Date().getTime());
		
		for (int i=0;i<10;i++) {
			life[r.nextInt(10)][r.nextInt(10)] = true;
		}
		
		
		int liveCount = 0;
		do {
			liveCount = 0;
			for (int x=0;x<life.length; x++) {
				for (int y=0;y<life.length; y++) {
					if (life[x][y]) {
						System.out.print("O");
					} else {
						System.out.print("X");
					}
				}
				System.out.println("");
			}
			
			System.out.println("");
			System.out.println("");
			System.out.println("");
			
			for (int x=0;x<life.length; x++) {
				for (int y=0;y<life.length; y++) {
					int neighborCount = getNeighborCount(life,x,y);
					if (life[x][y] && (neighborCount <= 1 || neighborCount >= 4)) {
						result[x][y] = false;
					} else if (life[x][y] && (neighborCount == 2 || neighborCount == 3)) {
						result[x][y] = true;
					} else if (!life[x][y] && neighborCount == 3) {
						result[x][y] = true;
					} else {
						result[x][y] = life[x][y];
					}
					if (result[x][y]) {
						liveCount ++;
					}
				}
			}
			tmp = result;
			result = life;
			life = tmp;
			Thread.sleep(1000);  
		} while (liveCount > 0);
	}

}
