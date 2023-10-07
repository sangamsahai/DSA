package com.dsa;
import java.util.*;

public class TowerOfHanoi {
	
	Stack<Integer> stack1 = new Stack<Integer>();
	Stack<Integer> stack2 = new Stack<Integer>();
	Stack<Integer> stack3 = new Stack<Integer>();
	
	public void moveStackOfPegs(int depth, int source_stack_number, int destination_stack_number)
	{
		
		Stack<Integer> source_stack = getSourceOrDestinationStack(source_stack_number);
		Stack<Integer> dest_stack = getSourceOrDestinationStack(destination_stack_number);
		int buffer_stack_number = getBufferStackNumber(source_stack_number,destination_stack_number);
		Stack<Integer> buffer_stack = getSourceOrDestinationStack(buffer_stack_number);
		
//		System.out.println("\n\n\n source_stack "+source_stack.toString());
//		System.out.println("destination_stack "+dest_stack.toString());
//		System.out.println("buffer_stack "+buffer_stack.toString());
//		System.out.println("Moving depth "+ depth + " from " +source_stack_number+" to "+destination_stack_number);
//		
		
		
		//Base condition
		if(depth==1)
		{
			System.out.println("Putting peg from "+source_stack_number+ " to "+ destination_stack_number);
			dest_stack.push(source_stack.pop());
			return;
		}
		
		//Main Recursion
		moveStackOfPegs(depth-1, source_stack_number, buffer_stack_number);
		System.out.println("Putting peg from "+source_stack_number+ " to "+ destination_stack_number);
		dest_stack.push(source_stack.pop());
		moveStackOfPegs(depth-1, buffer_stack_number, destination_stack_number);
		
	}

	public Stack<Integer> getSourceOrDestinationStack(int number)
	{
		if(number==1)
		{
			return this.stack1;
		}
		else if(number==2) {
			return this.stack2;
		}
		return this.stack3;
	}
	
	public int getBufferStackNumber(int source, int destination)
	{
		return  6-(source+destination);
	}
	
	public void printStack(Stack<Integer> stack)
	{
		System.out.println(stack.toString());
//		Stack<Integer> stack_copy=stack.
//		while(!stack.isEmpty()) {
//			System.out.println("\n");
//			System.out.println(stack.pop());
//		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TowerOfHanoi tower = new TowerOfHanoi();
		tower.stack1.push(10);
		tower.stack1.push(8);
		tower.stack1.push(3);
		
		System.out.println("\n\n\n Before");
		System.out.println("\n Stack 1");
		tower.printStack(tower.stack1);
		System.out.println("\n Stack 2");
		tower.printStack(tower.stack2);
		System.out.println("\n Stack 3");
		tower.printStack(tower.stack3);
		
		tower.moveStackOfPegs(3, 1, 3);

		System.out.println("\n\n\n After");
		System.out.println("\n Stack 1");
		tower.printStack(tower.stack1);
		System.out.println("\n Stack 2");
		tower.printStack(tower.stack2);
		System.out.println("\n Stack 3");
		tower.printStack(tower.stack3);
	}

}
