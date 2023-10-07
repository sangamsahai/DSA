package com.dsa;

import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargestNumber {
	
	public int getKthLargestNumber(int[]arr, int k) {
		
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		
		
		
		for(int i=0;i<arr.length;i++) {
		
			if(minHeap.size()<k) {
				//System.out.println("Size is "+minHeap.size());
				//System.out.println("Default Adding "+arr[i]);
			minHeap.add(arr[i]);
			continue;
		}
			
			if(arr[i]>minHeap.peek()) {
				//System.out.println("Removing "+minHeap.poll());
				minHeap.poll();
				
				System.out.println("Adding "+arr[i]);
				minHeap.add(arr[i]);
			}
		}
		
		return minHeap.peek();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KthLargestNumber k = new KthLargestNumber();
		System.out.println(k.getKthLargestNumber(new int[] {6,1,10,4,20,3,9}, 3));

	}

}
