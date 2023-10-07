package com.dsa;

public class MyHashMap {
	
	MyEntity[] bucketArray = new MyEntity[3];
	
	
	public void put(String key, String value) throws Exception {
		
		int hashCode = key.hashCode();
		int bucketIndex = hashCode%3;	
		
		if(!fetchValueForKeyAtIndex(key, bucketIndex).equals("")) {
			throw new Exception("Duplicate key !!");
		}
		
		appendAtIndex( key, value, bucketIndex);
	}
	
	public String get(String key) {
		int hashCode = key.hashCode();
		int bucketIndex = hashCode%3;
		return fetchValueForKeyAtIndex(key, bucketIndex);
	}
	
	
	public void appendAtIndex(String key, String value, int bucketIndex) {
		System.out.println("Putting key- "+key  +  " in bucket "+bucketIndex);
		if(bucketArray[bucketIndex] == null) {
			bucketArray[bucketIndex] = new MyEntity(key, value);
			return;
		}
		//Inserting at head
		MyEntity newItem = new MyEntity(key, value);
		newItem.next = bucketArray[bucketIndex];
		bucketArray[bucketIndex] = newItem;
	}
	
	public String fetchValueForKeyAtIndex(String key, int bucketIndex) {
		if(bucketArray[bucketIndex] == null) {
			return "";
		}
		
		MyEntity temp = bucketArray[bucketIndex];
		while(temp.next != null)
		{
			if(temp.key == key) {
				return temp.value;
			}
			temp = temp.next;
		}
		if(temp.key == key) {
			return temp.value;
		}
		return "";
	}
	
	

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		
		MyHashMap hm= new MyHashMap();
		hm.put("key1","val1");
		
		hm.put("key2","val2");
		
		hm.put("key3","val3");
		
		hm.put("key4","val4");
		
		hm.put("key5","val5");
		hm.put("key5","val5");
		
		System.out.println(hm.get("key1"));
		System.out.println(hm.get("key2"));
		System.out.println(hm.get("key3"));
		System.out.println(hm.get("key4"));
		System.out.println(hm.get("key5"));
		

	}

}

class MyEntity {
	String key;
	String value;
	MyEntity next;  //for linked list pointer
	
	public MyEntity(String key, String value) {
		this.key = key;
		this.value = value;
	}
}
