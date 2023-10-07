package com.dsa;

public class CoinChange2 {
	
	// Q - https://leetcode.com/problems/coin-change-ii/description/
	
	
		int denominations[];
		int ammount;
		
		public int numOfWays(int index, int ammount) {
			
			int retVal=-99;
			
			if(index>denominations.length-1 || ammount<=0) {
				retVal=0;
			}
			
			else if(denominations[index]>ammount) {
				retVal= numOfWays(index+1, ammount) ;
			}
			else if(denominations[index] == ammount) {
				retVal = 1+ numOfWays(index+1, ammount) ;
			}
			else {
			
			
			
			int pick = numOfWays(index, ammount-denominations[index]) ;
			int dontPick = numOfWays(index+1, ammount) ;
			retVal= pick+dontPick;
			}
			System.out.println("index - "+index+" ammount - "+ammount+" computed val is "+retVal);
			return retVal;
		}
		

	public static void main(String[] args) {
		
		CoinChange2 c = new CoinChange2();		
				
				c.denominations = new int[]{5,2,1};//make the denomination in increasing order
						c.ammount=5;
				
				
				System.out.println(c.numOfWays(0, c.ammount));

	}

}
