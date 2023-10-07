package com.dsa;

public class BST {

	
	public BSTNode insert(BSTNode root, int data)
	{
		if(root==null)
		{
			return new BSTNode(data);
		}
		
		if(data<root.data)//Goes left
		{
			if(root.left==null)
			{
				root.left = new BSTNode(data);
				return root;
			}
			else
			{
				root.left = insert(root.left, data);
				return root;
			}
			
		}
		else//Goes Right
		{
			if(root.right==null)
			{
				root.right = new BSTNode(data);
				return root;
			}
			else
			{
				root.right = insert(root.right, data);
				return root;
			}
		}
		
	}
	
	
	
	public void printBST(BSTNode root)
	{
		if(root == null)
		{
			return;
		}
		System.out.println("\n");
		System.out.println(root.data);
		printBST(root.left);
		printBST(root.right);
	}
	
	
	public boolean search(BSTNode root, int data)
	{
		if(root == null)
		{
			return false;
		}
		if(root.data == data)
		{
			return true;
		}
		
		if(data<root.data)
		{
			return search(root.left, data);
		}
		else
		{
			return search(root.right, data);
		}
		
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BST bst = new BST();
		BSTNode root = bst.insert(null, 100);
		bst.insert(root, 50);
		bst.insert(root, 500);
		bst.insert(root, 25);
		bst.insert(root, 75);
		bst.insert(root, 250);
		bst.insert(root, 750);
		bst.printBST(root);
		
		System.out.println(bst.search(root, 78));
	}

}

class BSTNode
{
	int data;
	BSTNode left;
	BSTNode right;
	
	public BSTNode(int data)
	{
		this.data=data;
	}

}
