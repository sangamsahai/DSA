package com.dsa;

public class NQueen {
	
	int size = 3;
	int arr[] = new int[size];
	int counter = 0;
	
	
	public void placeQueen(int pos)
	{
		
		if(pos==size)
		{
			boolean positioning = checkPosition();
			System.out.println(positioning);
			if(positioning)
			{
				System.out.println("VICTORYYYYYY"+"\n\n\n");
			}
			printArray();
			counter++;
			return;
		}
		
		for(int i=0;i<size;i++)
		{
			arr[pos]=i;
			placeQueen(pos+1);
		}
		
		
		
	}
	
	
	public boolean checkPosition()
	{
		boolean rowCheck;
		boolean diagCheck;
		for(int i=0;i<=size-1;i++)
		{
			for(int j=0;j<=size-1;j++)
			{
				if(i==j)
				{
					continue;
				}
				rowCheck = checkSameRow(i,j);
				diagCheck = checkDiagonal(i,j);
				if(rowCheck==false  || diagCheck==false)
				{
					return false;
				}
			}	
		}
		return true;
	}
	
	public boolean checkSameRow(int i, int j)
	{
		if(arr[i] == arr[j]) {
			return false;
		}
		return true;
	}
	
	public boolean checkDiagonal(int i, int j)
	{
		if(Math.abs(i-j)==Math.abs(arr[i]-arr[j])) {
			return false;
		}
		return true;
	}
	
	public void printArray()
	{
		for(int i=0;i<=size-1;i++) 
		{
			System.out.println(arr[i]);
		}
		System.out.println("\n");
	}

	public static void main(String[] args) {
		NQueen nQueen=new NQueen();
		nQueen.placeQueen(0);	
		System.out.println(nQueen.counter);
	}

}
