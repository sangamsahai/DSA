package com.dsa;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;


class LRUCache {
  int capacity;
  
  //LinkedListNode holds key and value pairs
  HashMap<Integer,LinkedListNode> cache; 
  LinkedList<LinkedListNode> cache_vals;
  
  public LRUCache(int capacity) {
    this.capacity = capacity;
    cache = new HashMap<Integer,LinkedListNode>(capacity);
    cache_vals = new LinkedList<LinkedListNode>();
  }


  int get(int key) {
	  
	  if(cache.containsKey(key)) {
		  LinkedListNode linkedListNode= cache.get(key);
		  cache_vals.remove(linkedListNode);
		  cache_vals.addFirst(linkedListNode);
		  return linkedListNode.value;
	  }
	  else {
		  return -1;
	  }
  }

  void set(int key, int value) {
	  LinkedListNode newLinkedListNode= new LinkedListNode(key,value);
	  
		if(cache_vals.size()<capacity) {
			 cache_vals.add(newLinkedListNode);	  
			  }
		else {
			  cache_vals.removeLast();
			  cache_vals.addLast(newLinkedListNode);
		} 
	  
		
	  cache.put(key, newLinkedListNode);
  }

  String print() {
    String result = "";
    ListIterator<LinkedListNode> iterator = cache_vals.listIterator(0);
    while(iterator.hasNext()){
      LinkedListNode node = iterator.next();
      result += "("+node.key + ":" +node.value+")" + ",";  
    }
   return result;
  }
  
  
  public static void main(String[] args) {
	  
	  LRUCache lru = new LRUCache(4);
	  
	  lru.set(1, 10);
	  lru.set(2, 20);
	  lru.set(3, 30);
	  lru.set(4, 40);
	  
	  System.out.println(lru.get(4));
	  
	  System.out.println(lru.print());
	  
	  lru.set(5, 50);
	  System.out.println(lru.print());
 System.out.println(lru.get(5));
	  
	  System.out.println(lru.print());
	  
	}

}  

class LinkedListNode {
	int key;
	int value;
	public LinkedListNode(int key, int value) {
		this.key=key;
		this.value=value;
	}
}