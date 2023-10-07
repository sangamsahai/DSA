package com.dsa;

public class Knapsack {
	
	
	
	int arr[] = new int[5];
	int counter = 0;
	
	int[] weights = new int[]{ 8,4,2,9,1 }; 
	int[] values = new int[]{ 20,1,10, 2, 3 }; 
	
	int bestValueSoFar = 0;
	
	
	public void createSubsets(int pos)
	{
		
		if(pos==5)
		{

			
			int weightInThisSubset = getWeight();
			int valueInThisSubset = getValue();
			//10 is max capacity
			if(weightInThisSubset<=10 && valueInThisSubset>bestValueSoFar)
			{
				bestValueSoFar = valueInThisSubset;
			}
	
			printArray();
			counter++;
			return;
		}
		
		
			arr[pos]=0;
			createSubsets(pos+1);
			
			arr[pos]=1;
			createSubsets(pos+1);
		
		
	}
	
	public int getWeight()
	{
		int sum = 0;
		for(int i=0;i<5;i++)
		{
		sum=sum + weights[i]*arr[i];	
		}
		return sum;
	}
	

	public int getValue()
	{
		int sum = 0;
		for(int i=0;i<5;i++)
		{
		sum=sum + values[i]*arr[i];	
		}
		return sum;
	}
	
	public void printArray()
	{
		for(int i=0;i<5;i++) 
		{
			System.out.println(arr[i]);
		}
		System.out.println("\n");
	}

	public static void main(String[] args) {
		Knapsack knapsack=new Knapsack();
		knapsack.createSubsets(0);	
		System.out.println(knapsack.counter);
		System.out.println(knapsack.bestValueSoFar);

	}

}
