package com.dsa;

import java.util.Vector;

import java.util.ArrayList;
import java.util.Iterator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class Random {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 Vector<Integer> v = new Vector<Integer>(5);
	        for (int i = 1; i <= 5; i++)
	        {
	            v.add(i);
	        }
	        System.out.println(v);
	        v.remove(3);
	        System.out.println(v);
	        Iterator<Integer> vi = v.iterator();
	        while(vi.hasNext()) {
	        	System.out.println("YESS"+vi.next());	
	        }

	        
	        
	        LinkedList<String> cars = new LinkedList<String>();
	        cars.add("Volvo");
	        cars.add("BMW");
	        cars.add("Ford");
	        cars.add("Mazda");
	        System.out.println(cars);
	        
	        
	        
	        ArrayList<String> cars2 = new ArrayList<String>();
	        cars2.add("Volvo");
	        cars2.add("BMW");
	        cars2.add("Ford");
	        cars2.add("Mahindra");
	        System.out.println(cars2);
	        
	        
	        
	        
	        
	        Stack<String> stack = new Stack<String>();
	        stack.push("Welcome");
	        stack.push("To");
	        stack.push("Geeks");
	        stack.push("For");
	        stack.push("Geeks");
	        System.out.println("Initial Stack: " + stack);
	        
	        
	        
	        
	        
	        Queue<String> queue = new LinkedList<>();
	        queue.add("apple");
	        queue.add("banana");
	        queue.add("cherry");
	        System.out.println("Queue: " + queue);
	        
	        
	        
	        
	        
	        
	        // Creating empty priority queue
	        PriorityQueue<Integer> pQueue
	            = new PriorityQueue<Integer>(
	                Collections.reverseOrder());  // "Collections.reverseOrder" for Max Heap, default is Min heap
	 
	        // Adding items to our priority queue
	        // using add() method
	        pQueue.add(10);
	        pQueue.add(30);
	        pQueue.add(20);
	        pQueue.add(400);
	 
	        // Printing the most priority element
	        System.out.println("Head value using peek function:"
	                           + pQueue.peek());
	        
	        
	        
	        
	        
	        
	        
	        // Make a collection
	        ArrayList<String> cars3 = new ArrayList<String>();
	        cars3.add("Volvo");
	        cars3.add("BMW");
	        cars3.add("Ford");
	        cars3.add("Mazda");

	        // Get the iterator
	        Iterator<String> it =  cars3.iterator();

	        while(it.hasNext()) {
	            System.out.print(" Iterator Value is - "+ it.next());
	        }
	 
	      
	        
	}

}
