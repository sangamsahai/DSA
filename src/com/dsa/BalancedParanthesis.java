package com.dsa;

import java.util.Stack;

public class BalancedParanthesis {
	
	
	
	public boolean checkParanBalance(String paranthesis)
	{
		
		Stack stack= new Stack<>();
		
		for(int i=0;i<paranthesis.length();i++)
		{
			char currentChar = paranthesis.charAt(i);
			if(!isClosingBracket(currentChar))//opening bracket
			{
				stack.push(currentChar);
				System.out.println(stack);
			}
			else//closing bracket
			{
				if(!stack.isEmpty() && (char)stack.peek()==getOpeningBracket(currentChar))
				{
					stack.pop();
					System.out.println("\n"+stack);
				}
				else
				{
					return false;
				}
			}
			
		}
		return stack.isEmpty();
	}

	public boolean isClosingBracket(char ch)
	{
		return (ch=='}' || ch==']' || ch==')');
	}
	
	public char getOpeningBracket(char ch)
	{
		 if(ch=='}')
				{
			return '{';
				}
		 else if(ch==']')
			{
		return '[';
			}
		 else 
			{
		return '(';
			}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BalancedParanthesis bp = new BalancedParanthesis();
		System.out.println(bp.checkParanBalance("([]){"));
	}

}
