package com.dsa;

import java.util.ArrayList;
import java.util.HashMap;

public class KnapSackBnb {
	
	
	
	
	int[] weights = new int[]{ 8,4,2,9,1 }; 
	int[] values = new int[]{ 20,1,10, 2, 3 }; 
	HashMap<String, Integer> map = new HashMap<>();
	
	int bestValueSoFar = 0;
	int capacity = 10;
	int bestRejectValueSoFar = 1000; // We have to minimize this - like cost
	
	
	public void exploreSeachSpace(ArrayList<MyItem> decisionMade, ArrayList<MyItem> yetTobeMade, int valueSoFar, int valueOfRejects)
	{
		
		System.out.println("This function call");
		System.out.println("decisionMade- "+decisionMade.toString());
		System.out.println("yetTobeMade- "+yetTobeMade.toString());
		System.out.println("valueOfRejects- "+valueOfRejects);
		
		if(getWeight(decisionMade) > 10) {
			System.out.println("Ignoring this subtree as weight exceeded \n");
			System.out.println("\n");
			return;
		}
		if(valueOfRejects > bestRejectValueSoFar) {
			System.out.println("WOWWWW!!!");
			System.out.println("valueOfRejects"+valueOfRejects+","+"bestRejectValueSoFar"+bestRejectValueSoFar);
			System.out.println("Ignoring this subtree as we have a better solution \n");
			System.out.println("\n");
			return;
		}
		System.out.println("\n");
		
		if(yetTobeMade.size()==0)
		{
			if(getWeight(decisionMade) <= 10 &&  valueOfRejects<bestRejectValueSoFar)
			{
				bestRejectValueSoFar = valueOfRejects;
			}
			if(getWeight(decisionMade) <= 10 &&  valueSoFar>bestValueSoFar)
			{
				bestValueSoFar = valueSoFar;
			}
			return;
		}
		
		MyItem itemToBeMadeDecisionOn = yetTobeMade.get(0);
		
		//First Path - we will take it
		decisionMade.add(itemToBeMadeDecisionOn);
		yetTobeMade.remove(itemToBeMadeDecisionOn);
		exploreSeachSpace(decisionMade, yetTobeMade, valueSoFar+itemToBeMadeDecisionOn.value, valueOfRejects);
		//clean up
		decisionMade.remove(itemToBeMadeDecisionOn);
		yetTobeMade.add(0, itemToBeMadeDecisionOn);
		
		
		//Second Path - we will leave it
		yetTobeMade.remove(itemToBeMadeDecisionOn);
		exploreSeachSpace(decisionMade, yetTobeMade, valueSoFar, valueOfRejects+itemToBeMadeDecisionOn.value);
		//clean up
		yetTobeMade.add(0, itemToBeMadeDecisionOn);
		
	}
	
	public int getWeight(ArrayList<MyItem> decisionMade)
	{
		int sum = 0;
		for(MyItem obj : decisionMade)
		{
			sum+= obj.weight;
		}
		return sum;
	}
	

	public static void main(String[] args) {
		KnapSackBnb knapsack=new KnapSackBnb();
		
		
		ArrayList<MyItem> d_made = new ArrayList<MyItem>();
		ArrayList<MyItem> y2b_made = new ArrayList<MyItem>();
		
		y2b_made.add(new MyItem(20, 8));
		y2b_made.add(new MyItem(1, 4));
		y2b_made.add(new MyItem(10, 2));
		y2b_made.add(new MyItem(2, 9));
		y2b_made.add(new MyItem(3, 1));
		
		
		knapsack.exploreSeachSpace(d_made, y2b_made, 0, 0);
		
		System.out.println("Best Value");
		System.out.println(knapsack.bestValueSoFar);
		

	}

}


class MyItem {
	int value;
	int weight;
	
	public MyItem(int value, int weight) {
		this.value = value;
		this.weight = weight;
	}
	
	@Override
    public String toString() {
        return "{"+"value:"+this.value + "," + "weight:"+this.weight+"}" ;
    }
	
	
}
