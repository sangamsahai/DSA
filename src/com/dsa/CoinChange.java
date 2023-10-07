package com.dsa;

import java.util.Queue;
import java.util.LinkedList;

public class CoinChange {
	// Q - https://leetcode.com/problems/coin-change/
	
	
	int denominations[];
	int ammount;
	Queue<QueueElement> q =  new LinkedList<>();
	
	
	public int bfs() { 
		
		if(ammount==0) {
			return 0;
		}
		
		
		while(!q.isEmpty()) {
			
			QueueElement removedElement = q.poll();
			
			if(removedElement.sum>ammount) {
				continue;
			}
			
			if(removedElement.sum == ammount) {
				return removedElement.level;
			}
			
			for(int i=0;i<denominations.length;i++) {
				q.add(new QueueElement(denominations[i],removedElement.sum+denominations[i],removedElement.level+1));
			}
			
		}
		
		return -1;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CoinChange c = new CoinChange();
		
		//c.denominations = new int[]{1,2,5};
		//c.ammount=11;
		
		//c.denominations = new int[]{2};
		//c.ammount=3;
		
		c.denominations = new int[]{1,2,5};
				c.ammount=14;
		
		for(int i=0;i<c.denominations.length;i++) {
			c.q.add(new QueueElement(c.denominations[i],c.denominations[i],1));
		}
		
		
		System.out.println(c.bfs());

	}

}

 class QueueElement {
	public int denomination;
	public int sum;
	public int level;
	
	public QueueElement(int denomination,int sum, int level) {
		this.denomination=denomination;
		this.sum=sum;
		this.level=level;
		
	}
}
