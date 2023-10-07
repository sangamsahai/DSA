package com.dsa;

import java.util.Stack;

public class NextGreaterElement {
	
	public int[] arr;
	
	public NextGreaterElement(int[] arr) {
		this.arr=arr;
	}
	
	public void printNextGreaterElement() {
		Stack<Integer> s = new Stack<Integer>(); 
		
		s.push(arr[arr.length-1]);//starting
		
		System.out.println("Next greater element for "+arr[arr.length-1]+" is "+" -99 ");
		
		
		for(int i=arr.length-2; i>=0; i--) {
			
			int currentElement = arr[i];
			int nextGreaterElement = -1;
			
			if(s.peek()>currentElement) {
				nextGreaterElement = s.peek();
				s.push(currentElement);
			}
			else
			{
				while(!s.isEmpty() && s.peek()<currentElement) {
					s.pop();
				}
				if(s.isEmpty()) {
					nextGreaterElement = -1;	
				}
				else {
				nextGreaterElement = s.peek();
				}
				s.push(currentElement);
			}
			System.out.println("Next greater element for "+currentElement+" is "+nextGreaterElement);
		
		}
		
	}
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = new int[]{3,10,4,2,1,2,6,1,7,2,9};
		NextGreaterElement nge = new NextGreaterElement(arr);
		nge.printNextGreaterElement();
		

	}

}
