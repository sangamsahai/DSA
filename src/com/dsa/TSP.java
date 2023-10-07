package com.dsa;

import java.util.ArrayList;
import java.util.HashMap;


public class TSP {
	
	
	
	static HashMap<String, ArrayList<MyEdge>> graph = new HashMap<String, ArrayList<MyEdge>>();
	
	int global_cost = 1000;
	String bestPath;
	
	
	public void findPath(ArrayList<String> pathSoFar, int costSoFar)
	{
		
		System.out.println("\n" );
		System.out.println("Path so far is "+ pathSoFar.toString());
		System.out.println("cost so far is "+ costSoFar );
		System.out.println("best cost so far "+ global_cost );
		
		//Branch and Bound technique
		if(costSoFar > global_cost ) {
			System.out.println("Avoiding this route");
			return;
		}
		
		//Base Case
		if(pathSoFar.size()==4)
		{
			if(costSoFar<global_cost)
			{
				global_cost = costSoFar;
				bestPath = pathSoFar.toString();
				
			}
			return;
		}
		
		//Find neighbors
		ArrayList<MyEdge> neighbors = graph.get(pathSoFar.get(pathSoFar.size()-1));
		//System.out.println("neighbors are "+ neighbors.toString() );
		
		//Iterating over neighbors
		 for (MyEdge neighbor : neighbors) {
		  //checking if this has been traversed
			 if(hasNodeBeenTraversed(neighbor,pathSoFar))
			 {
				 continue;
			 }
			 
			 pathSoFar.add(neighbor.vertex);
			 findPath(pathSoFar,costSoFar + neighbor.weight);
			 
			 pathSoFar.remove(pathSoFar.size()-1);
			 
		    }
		
		
		
	}
	
	public boolean hasNodeBeenTraversed(MyEdge neighbor, ArrayList<String> pathSoFar)
	{
		String neighborVertex = neighbor.vertex;
		for(String vertex : pathSoFar)
		{
			if(neighborVertex.equals(vertex))
			{
				return true;
			}
		}
		return false;
	}

	
	
	
	

	public static void main(String[] args) {
		TSP tsp = new TSP();
		
		
		ArrayList<MyEdge> edges_from_a = new ArrayList<MyEdge>();
		edges_from_a.add(new MyEdge("b",1));
		edges_from_a.add(new MyEdge("c",20));
		edges_from_a.add(new MyEdge("d",30));
		graph.put("a",edges_from_a);
		
		
		ArrayList<MyEdge> edges_from_b = new ArrayList<MyEdge>();
		edges_from_b.add(new MyEdge("a",1));
		edges_from_b.add(new MyEdge("c",10));
		edges_from_b.add(new MyEdge("d",2));
		graph.put("b",edges_from_b);
		
		
		ArrayList<MyEdge> edges_from_c = new ArrayList<MyEdge>();
		edges_from_c.add(new MyEdge("a",20));
		edges_from_c.add(new MyEdge("b",10));
		edges_from_c.add(new MyEdge("d",3));
		graph.put("c",edges_from_c);
		
		
		ArrayList<MyEdge> edges_from_d = new ArrayList<MyEdge>();
		edges_from_d.add(new MyEdge("a",30));
		edges_from_d.add(new MyEdge("b",2));
		edges_from_d.add(new MyEdge("c",3));
		graph.put("d",edges_from_d);
		
		
		
		ArrayList<String> seedPath = new ArrayList<String>();
		seedPath.add("a");
		
		tsp.findPath(seedPath, 0);
		
		System.out.println(tsp.bestPath);
		System.out.println(tsp.global_cost);
		

	}

}


class MyEdge {
	String vertex;
	int weight;
	
	public MyEdge(String vertex,int weight) {
		this.vertex = vertex;
		this.weight = weight;
		
	}
}
