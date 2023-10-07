package com.dsa;

public class WordReverse {
	
	public String reverseWords(String input) {
		
		//Reversing the whole sentence
		char[] inp_arr=input.toCharArray();
		int p1=0;int p2=inp_arr.length-1;
		for(int i=0; i<inp_arr.length/2 ;i++) {
			char temp=inp_arr[p1];
			inp_arr[p1] = inp_arr[p2];
			inp_arr[p2] = temp;
			p1++;
			p2--;
		}
		
		
		
		//Reversing individual worlds
		int previous=0;
		int last_space=-1;
		for(int i=0; i<inp_arr.length ;i++)
		{
			
			if(inp_arr[i]==' ')//space is found 
			{
				reverseCharacters(previous,i-1,inp_arr);
				last_space = i;
				previous = i+1;
				//System.out.println(String.copyValueOf(inp_arr));
			}
			
		}
		reverseCharacters(last_space+1,inp_arr.length-1,inp_arr);
		return String.copyValueOf(inp_arr);
		
	}
	
	public String reverseCharacters(int start, int end, char[] inp_arr) {
		//System.out.println(start+" "+end);
		//System.out.println("Start-  "+String.copyValueOf(inp_arr));
		int len = end-start+1;
		for(int i=0; i<len/2 ;i++) {
			char temp=inp_arr[start];
			inp_arr[start] = inp_arr[end];
			inp_arr[end] = temp;
			start++;
			end--;
			//System.out.println(String.copyValueOf(inp_arr));
		}
		//System.out.println("end-  "+String.copyValueOf(inp_arr));
		return  String.copyValueOf(inp_arr);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WordReverse wr = new WordReverse();
		System.out.println(wr.reverseWords("Hello My World"));
		//System.out.println(wr.reverseCharacters(1,4,"abcdef".toCharArray()));

	}

}
