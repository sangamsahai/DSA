package com.dsa;


import java.util.LinkedHashSet;
import java.util.Queue;
import java.util.LinkedList;

public class WordLadder {
	
	
	String[] wordList = new String[]{ "hot","dot","dog","lot","log","cog" };
	String start= "hit";String end= "cog"; 
	
	int bestPathLength  = 1000;
	Queue<String> q2 = new LinkedList<>(); 
	
	
	
	
	//DFS
	public void traverseDFS(String root, LinkedHashSet<String> hs) {
		
		//System.out.println("current path "+hs.toString());
		
		
		if(root.equals(end) && hs.size()<bestPathLength) {
			bestPathLength = hs.size();
			System.out.println(hs.toString());
			return;
		}
		
		for(int i=0; i<wordList.length; i++) {
			String currentWordToCompare = wordList[i];
			
			if(hs.contains(currentWordToCompare)) {
				continue;
			}
			
			if(oneLeterApart(root, currentWordToCompare)) {//found next node
				hs.add(currentWordToCompare);
				//System.out.println("next node "+currentWordToCompare);
				traverseDFS(currentWordToCompare,hs);
			}
			hs.remove(currentWordToCompare);
		}
		
	}
	
	
	//BFS
	public void traverseBFS(Queue<QueueNode> q) {
		
		//System.out.println("Q is "+q.toString());
		
		while(!q.isEmpty()) {
		
			QueueNode itemJustRemovedFromQueue = q.remove();
			
			//System.out.println("remvd from q"+itemJustRemovedFromQueue);
			
			
			if(itemJustRemovedFromQueue.nodeWord.equals(end) ) {
				System.out.println("Cond is met ! Found the word... - "+itemJustRemovedFromQueue.parentPath.toString()+" "+end);
				return;
			}
		
		
		for(int i=0; i<wordList.length; i++) {
			String currentWordToCompare = wordList[i];
			
			//If node already exists on parent path
			if(itemJustRemovedFromQueue.parentPath.contains(currentWordToCompare)) {
				continue;
			}
			
			if(oneLeterApart(itemJustRemovedFromQueue.nodeWord, currentWordToCompare)) {//found next node	
				//System.out.println("next node "+currentWordToCompare);
				//System.out.println("added to q"+currentWordToCompare);
				QueueNode nodeToBeAdded = new QueueNode(currentWordToCompare);
				nodeToBeAdded.parentPath.addAll(itemJustRemovedFromQueue.parentPath);
				nodeToBeAdded.parentPath.add(itemJustRemovedFromQueue.nodeWord);
				q.add(nodeToBeAdded);
			}
			
			
		}//end of for
		
		}//end of while
		
		
	}
	
	public boolean oneLeterApart(String root, String currentWordToCompare) {
		
		int difference = 0;
		for(int i=0; i<root.length();i++) {
			if(root.charAt(i) != currentWordToCompare.charAt(i)) {
				difference++;
			}
		}
		return difference==1 ;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordLadder w = new WordLadder();
		LinkedHashSet<String> hs = new LinkedHashSet<String>();hs.add(w.start);
		w.traverseDFS(w.start,hs);
		
		Queue<QueueNode> q = new LinkedList<>(); 
		q.add(new QueueNode("hit"));
		w.traverseBFS(q);
	}

}

class QueueNode {
	String nodeWord;
	LinkedHashSet<String> parentPath;
	
	public QueueNode(String word) {
		nodeWord = word;
		parentPath = new LinkedHashSet<String>();
	}
}