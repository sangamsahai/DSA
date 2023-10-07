package com.dsa;



public class ReverseLinkedList {
	
	 
	//Classic recusrion def
	public Node reverseLinkedList(Node head)
	{
		if(head.next==null)//just 1 element
		{
			return head;
		}
		
		Node reversedSubList = reverseLinkedList(head.next);
		return appendAtTail(reversedSubList,head.data);
	}
	
	
	public Node appendAtTail(Node head, int data)
	  {
		  if(head==null)//LL of 0 length
		  {
			  Node newNode = new Node(data);
			  System.out.println("List is - ");
			  printList(newNode);
			  return newNode;
		  }
		  
		  Node temp=head;
		  while(temp.next!=null)
		  {
			  temp=temp.next;
		  }
		  temp.next = new Node(data);
		  System.out.println("List is - ");
		  printList(head);
		  return head;  
	  }

	
	public void printList(Node head)
	  {
		if(head==null)
		{
			return; //LL of 0 length
		}
		if(head.next==null)//LL of 1 length
		  {
			  System.out.println(head.data);
			  return;
		  }
		  
		  Node temp=head;
		  while(temp.next!=null)
		  {
			  System.out.println(temp.data);
			  temp=temp.next;
		  }
		  System.out.println(temp.data);
	  }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node newNode = null;
		ReverseLinkedList ll = new ReverseLinkedList();
		newNode = ll.appendAtTail(newNode, 8);
		newNode = ll.appendAtTail(newNode, 9);
		newNode = ll.appendAtTail(newNode, 10);
		
		newNode = ll.reverseLinkedList(newNode);
		System.out.println("Final reversal");
		ll.printList(newNode);
		
				
		
		

	}

}

class Node { 
    int data; 
    Node next; 

    public Node(int d)
    { data = d; }  //constructor to create a new node
} 
