package com.dsa;

import java.util.HashMap;

public class KnapSackDynamic {
	
	
	
	
	int[] weights = new int[]{ 8,4,2,9,1 }; 
	int[] values = new int[]{ 20,1,10, 2, 3 }; 
	HashMap<String, Integer> map = new HashMap<>();
	
	int bestValueSoFar = 0;
	
	
	public int bestValue(int i, int capacity)
	{
		String key = ""+i+"-"+capacity;
		if(map.containsKey(key))
		{
			System.out.println("Fetched pre - computed for "+i+" and "+ capacity);
			return map.get(key);
		}
		
		System.out.println("computing - "+i+" and "+ capacity);
		
		int retVal = 0;
		
		if(capacity<=0)
		{
			retVal =  0;
		}
		else if(i>4)
		{
			retVal =  0;
		}
		else if(weights[i]>capacity)
		{
			retVal =  bestValue(i+1, capacity);
		}
		else {
			retVal =  Math.max(values[i] + bestValue(i+1, capacity - weights[i]),
				bestValue(i+1, capacity));
		}
		map.put(key, retVal);
		return retVal;
	}
	

	public static void main(String[] args) {
		KnapSackDynamic knapsack=new KnapSackDynamic();
	
		System.out.println(knapsack.bestValue(0, 10));

	}

}
