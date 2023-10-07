package com.dsa;

import java.util.ArrayList;

public class PossiblePaths {
	
	//int[][] arr = { { 1, 2 }, { 3, 4 } };
   Point dest = new Point(3,2);
   
   int globalCounter=0;
	
	//source is always origin, input param is the distance
	//person can go only right or down
	public void explorePaths(int x, int y, ArrayList<Point> path) {
		
		if(!isValid(new Point(x,y))) {
			return;
		}
		
		
		if(dest.x==x && dest.y==y) {
			printList(path);
			return;
		}
		
		
		
		//explore right
		Point rightPoint = new Point(x,y+1); 
		path.add(rightPoint);
		explorePaths(x, y+1, path);
		path.remove(rightPoint);
		
		
		//explore down
		Point downPoint = new Point(x+1,y); 
		path.add(downPoint);
		explorePaths(x+1, y, path);
		path.remove(downPoint);
		
		
		
	}
	
	public void printList(ArrayList<Point> path) {
		globalCounter++;
		System.out.println("Path# "+ globalCounter+" is - ");
		for(int i=0;i<path.size();i++)
		{
			System.out.println("["+path.get(i).x+","+path.get(i).y+"]");
		}
		System.out.println("\n");
	}
	
	public boolean isValid(Point p) {
		return p.x<=dest.x && p.y<=dest.y;
	}
	
	
	//source is always origin
	//dest is x, y
	public int getNumberOfPaths(int x, int y) {
		
		//check for valid number
		if(x<0 || y<0) {
			return 0;
		}
		
		if((x==1&&y==0) || (x==0&&y==1)) {
			return 1;
		}
		
		
		return getNumberOfPaths(x-1,y) + getNumberOfPaths(x,y-1);
		
	}
	
	
	
	public static void main(String[] args) {
		PossiblePaths p = new PossiblePaths();
		
		ArrayList<Point> pathList = new ArrayList<Point>();
		pathList.add(new Point(0,0));
		
		p.explorePaths(0, 0, pathList);
		System.out.println("#paths is "+p.getNumberOfPaths(p.dest.x,p.dest.y));
	}
	
	
	
	
}
class Point{
	int  x;int y;
	public Point(int x, int y)
	{
		this.x=x;
		this.y=y;
	}
}
