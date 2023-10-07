package com.dsa;
import java.util.*;
import java.util.LinkedList;

public class BinaryTree {
	
	
	public int getHeight(BinaryTreeNode root) {
		if(root==null) {
			return 0;
		}
		return Math.max(getHeight(root.leftChild), getHeight(root.rightChild))+1;
	}
	
	//Fix this, it is PreOrder
	public void inOrderTraverse(BinaryTreeNode root){
		if(root==null) {
			return;
		}
		System.out.println(root.data);
		inOrderTraverse(root.leftChild);
		inOrderTraverse(root.rightChild);
	}
	
	public void BFSTraversal(BinaryTreeNode root) {
		if(root==null) {
			return;
		}
		Queue<BinaryTreeNode> q = new LinkedList<>();
		q.add(root);
		
		while(!q.isEmpty())
		{
			BinaryTreeNode poppedElement = q.remove();
					System.out.println(poppedElement.data);
					
					if(poppedElement.leftChild!=null) {
					q.add(poppedElement.leftChild);
					}
					if(poppedElement.rightChild!=null) {
						q.add(poppedElement.rightChild);
					}			
		}
		
	}
	
	//-999 is false, else true
	public int isTreeBalanced(BinaryTreeNode root) {
		
		if(root==null) {
			return 0;
		}
		int leftHeight = isTreeBalanced(root.leftChild);
		int rightHeight = isTreeBalanced(root.rightChild);
		//Bubbling up the signal to halt
		if(leftHeight==-999 || leftHeight==-999) {
			return -999;
		}
		//System.out.println("left and right height is "+ leftHeight+"  "+rightHeight);
		//Main check
		if(Math.abs(rightHeight-leftHeight)>1) {
			return -999;
		}
		return Math.max(leftHeight,rightHeight)+1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BinaryTreeNode root =  new BinaryTreeNode(1);
		root.leftChild=new BinaryTreeNode(2);
		root.rightChild=new BinaryTreeNode(3);
		root.leftChild.leftChild=new BinaryTreeNode(4);
		root.leftChild.rightChild=new BinaryTreeNode(5);
		root.rightChild.leftChild=new BinaryTreeNode(6);
		root.rightChild.rightChild=new BinaryTreeNode(7);
		
		//root.rightChild.rightChild.leftChild=new BinaryTreeNode(8);
		//root.rightChild.rightChild.rightChild=new BinaryTreeNode(9);
		
		//root.rightChild.rightChild.leftChild.leftChild=new BinaryTreeNode(10);
		
		BinaryTree bt=new BinaryTree(); 
		bt.inOrderTraverse(root);
		System.out.println("Height is "+ bt.getHeight(root));
		//System.out.println("Balanced is "+ bt.isTreeBalanced(root));
		System.out.println("BFS Traversal is ");
		bt.BFSTraversal(root);
	}

}
class BinaryTreeNode {
	int data;
	BinaryTreeNode leftChild;
	BinaryTreeNode rightChild;
	
	public BinaryTreeNode(int data) {
		this.data=data;
		this.leftChild=null;
		this.rightChild=null;
	}
}
