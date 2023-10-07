package com.dsa;

public class StackUsingArray {
	
	int top=-1;
	int stackArray[] = new int[10];
	
	public boolean isEmpty()
	{
		return top==-1;
	}
	
	public void push(int item) {
		top++;
		stackArray[top]=item;
	}
	
	public void pop() {
		top--;
	}
	
	public int peek() {
		return stackArray[top];
	}
	
	public void printArray() {
	System.out.println("Stack is");
		for(int i=0;i<=top;i++)
		{
			System.out.println(stackArray[i]);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackUsingArray s = new StackUsingArray();
		s.push(1);
		s.push(2);
		s.push(4);
		s.printArray();
		s.pop();
		s.printArray();
		System.out.println(s.isEmpty());

	}

}
