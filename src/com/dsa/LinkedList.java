package com.dsa;

public class LinkedList {
	
	
	Node head; // list head 
    //node - linkedlist
  public class Node { 
      int data; 
      Node next; 
  
      public Node(int d)
      { data = d; }  //constructor to create a new node
  } 

  
  public void appendAtTail(int data)
  {
	  if(head==null)//LL of 0 length
	  {
		  appendAtHead(data);
		  return;
	  }
	  
	  Node temp=head;
	  while(temp.next!=null)
	  {
		  //System.out.println(temp.data);
		  temp=temp.next;
	  }
	  temp.next = new Node(data);
	  System.out.println("List is - ");
	  printList();
	  return;
	  
  }
  
  public void appendAtHead(int data)
  {
	  if(head==null)//if LL is empty
	  {
		  head = new Node(data);
		  System.out.println("List is - ");
		  printList();
		  return;
	  }
	  
	  Node newNode = new Node(data);
	  newNode.next = head;
	  head = newNode;
	  
	 
	  System.out.println("List is - ");
	  printList();
	  return;
  }
  
  public void printList()
  {
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
  
  
  public void reverseLLIteratively()
  {
	  if(head==null || head.next==null)
	  {
		  return;
	  }
	  Node current=head;
	  Node current_next = current.next;
	  head.next=null;
	  while(current_next!=null)
	  {
		  
		  Node temp = current;
		  current = current_next;
		  current_next = current_next.next;  
		  current.next = temp; 

	  }
	  head=current;
	  
	  System.out.println("Reversed List is - ");
	  printList();
  }
  
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList ll=new LinkedList();
		ll.appendAtTail(99);
		ll.appendAtTail(10);
		ll.appendAtTail(12);
		ll.appendAtHead(14);
		
		ll.reverseLLIteratively();

	}

}
