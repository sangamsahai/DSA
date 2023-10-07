package com.dsa;

import java.util.Queue;
import java.util.LinkedList;

public class CoinChangeDP {
	// Q - https://leetcode.com/problems/coin-change/
	
	
	int denominations[];
	int ammount;
	
	
	
	
	public int getNumberOfCoins(int decisionStartingIndex, int ammount) {
		
		//System.out.println(" computing for "+decisionStartingIndex+"  "+ammount);
		int returnValue=-99;
		
		if(ammount <= 0) {
			System.out.println("special0 computed value is "+" 0 " + " for - "+ " computing for "+decisionStartingIndex+"  "+ammount);
			return  0;
		}
		
		
		else if(decisionStartingIndex>denominations.length-1) {
			System.out.println("special0 computed value is "+" 0 " + " for - "+ " computing for "+decisionStartingIndex+"  "+ammount);
			return  0;
		}
		
		else if(denominations[decisionStartingIndex] == ammount) {
			System.out.println("\n special1 computed value is "+" 1 " + " for - "+ " computing for "+decisionStartingIndex+"  "+ammount);
			return  1;
		}
		
		else if(denominations[decisionStartingIndex]>ammount) {
			returnValue= getNumberOfCoins( decisionStartingIndex+1 , ammount);
			System.out.println("\n  computed value is "+returnValue+ " for - "+ " computing for "+decisionStartingIndex+"  "+ammount);
			return returnValue;
		}
		
		else if(decisionStartingIndex<denominations.length-1) {
			returnValue =  Math.min(
					1 + getNumberOfCoins( decisionStartingIndex , ammount-denominations[decisionStartingIndex]),//considering this denomination
					getNumberOfCoins( decisionStartingIndex+1 , ammount)//rejecting this denomination
					);
			System.out.println("\n  computed min value is "+returnValue+ " for - "+ " computing for "+decisionStartingIndex+"  "+ammount);
			return returnValue;
		}
		else
		{
			returnValue= 1 + getNumberOfCoins( decisionStartingIndex , ammount-denominations[decisionStartingIndex]);
			System.out.println("\n  computed value is "+returnValue+ " for - "+ " computing for "+decisionStartingIndex+"  "+ammount);
			return returnValue;
			
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CoinChangeDP c = new CoinChangeDP();
		
		//c.denominations = new int[]{5,2,1};
		//c.ammount=11;
		
		//c.denominations = new int[]{2};
		//c.ammount=3;
		
		c.denominations = new int[]{5,2,1};//make the denomination in increasing order
				c.ammount=14;
		
		
		
		System.out.println(c.getNumberOfCoins(0, c.ammount));

	}

}

 
