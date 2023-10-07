package com.dsa;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class MyTrie {
	
	
	
	public void searchInTrie(MyTrieNode trieRoot, String string)
	{
		
		
		int indexOfStringTobeFoundInTrie = 0;
		MyTrieNode temp = trieRoot;
		
		while(indexOfStringTobeFoundInTrie<string.length())//iterating over letters of string
		{
			MyTrieNode matchingNode = getNodeInList(string.charAt(indexOfStringTobeFoundInTrie), temp.nodeList);
			if(matchingNode == null) //No matching node found
			{
				System.out.println("String not found");
				return;
			}
			else
			{
				temp = matchingNode;
			}
			indexOfStringTobeFoundInTrie++;
		}
		if(!temp.indices.isEmpty()) {//terminal node check
		System.out.println("Index is- "+temp.indices.toString());
		}
		else {//non terminal node
			System.out.println("String not found");
		}
		
	}
	
	public MyTrieNode createTrie(String[] strings)
	{
		MyTrieNode trieRoot = new MyTrieNode('\0');
		
		for(int i=0;i<strings.length;i++)//iterating over strings
		{
			String currentString = strings[i];
			//System.out.println("Pushing in "+ currentString);
			int indexOfCharToBePushed = 0;
			MyTrieNode temp = trieRoot;
			
			while(indexOfCharToBePushed<currentString.length())//iterating over letters of string
			{
				MyTrieNode matchingNode = getNodeInList(currentString.charAt(indexOfCharToBePushed), temp.nodeList);
				if(matchingNode == null) //No matching node found
				{
					MyTrieNode newNode = new MyTrieNode(currentString.charAt(indexOfCharToBePushed));
					
					if(indexOfCharToBePushed==currentString.length()-1)//last character: square Node
					{
						newNode.indices.add(i);
					}
					//System.out.println("Adding node for "+ currentString.charAt(indexOfCharToBePushed)+ " to " + temp.ch);
					temp.nodeList.add(newNode);
					temp = newNode;
				}
				else
				{
					temp = matchingNode;
					if(indexOfCharToBePushed == currentString.length()-1)//String already exists
					{
						matchingNode.indices.add(i);
					}
				}
				indexOfCharToBePushed++;
			}//iterating over letters of string: END	
		}//iterating over strings: END
		
		return trieRoot;
	}
	
	public MyTrieNode getNodeInList(char ch, ArrayList<MyTrieNode> list )
	{
		for(int i=0; i<list.size(); i++)
		{
			if(list.get(i).ch == ch)
			{
				return list.get(i);
			}
		}
		return null;
	}
	
	public void printFirstWord(MyTrieNode root)
	{
		MyTrieNode temp = root;
		//System.out.println("blah2 "+temp.nodeList.size());
		while(temp.nodeList.size()!=0)
		{
			
			System.out.println(temp.ch);
			temp = temp.nodeList.get(0);
			System.out.println("blah3 "+temp.nodeList.size());
		}
		System.out.println(temp.ch);
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyTrie mt = new MyTrie();
		String[] strings = new String[] {"bull", "bear", "stock", "bear"};
		MyTrieNode root = mt.createTrie(strings);
		//mt.printFirstWord(root);
		mt.searchInTrie(root, "stock");

	}

}

class MyTrieNode {
	char ch = '\0';
	Set<Integer> indices = new HashSet<Integer>();
	 ArrayList<MyTrieNode> nodeList
     = new ArrayList<MyTrieNode>(); 
	 
	 public MyTrieNode(char ch)
	 {
		 this.ch = ch;
	 }
}