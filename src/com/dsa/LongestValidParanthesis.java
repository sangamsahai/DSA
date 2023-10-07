package com.dsa;

public class LongestValidParanthesis {
	
	
	public int lengthOfLongestValidParanthesis(String str, int start, int end) {
		
		if(end==start+1 && ((str.charAt(start)=='(' && str.charAt(end)==')') || (str.charAt(start)==')' && str.charAt(end)=='(')) ) {
			return 2;
		}
		
		if(!(start>=0 && start<=str.length()-1 && end>=0 && end<=str.length()-1)) {
			return -1;
		}
		
		if(str.charAt(start)==')') {
			return lengthOfLongestValidParanthesis( str, start+1,  end);
		}
		
		if(str.charAt(start)=='(' && str.charAt(end)=='(') {
			return Math.max(
			 lengthOfLongestValidParanthesis( str, start,  end-1),//if this starting bracket is a part
			 lengthOfLongestValidParanthesis( str, start+1,  end-1));
		}
		
		return Math.max(
				 2+ lengthOfLongestValidParanthesis( str, start+1,  end-1),
				 lengthOfLongestValidParanthesis( str, start+1,  end));
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LongestValidParanthesis l = new LongestValidParanthesis();
		//System.out.println(l.lengthOfLongestValidParanthesis("(()()", 0, 4));
		//System.out.println(l.lengthOfLongestValidParanthesis("()()", 0, 3));
		//System.out.println(l.lengthOfLongestValidParanthesis("(())", 0, 3));
		//System.out.println(l.lengthOfLongestValidParanthesis(")()()", 0, 4));
		//System.out.println(l.lengthOfLongestValidParanthesis("(()())", 0, 5));
		
		//System.out.println(l.lengthOfLongestValidParanthesis(")()())", 0, 5));
		System.out.println(l.lengthOfLongestValidParanthesis("(()())(", 0, 6));

	}

}
