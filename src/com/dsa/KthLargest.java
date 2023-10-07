package com.dsa;
import java.util.*;



class KthLargest {
	
    public static String reorganizeString(String string1) {

        Map < Character, Integer > charCounter = new HashMap < > ();
        for (char c: string1.toCharArray()) {
            int freq = charCounter.getOrDefault(c, 0) + 1;
            charCounter.put(c, freq);
        }
        PriorityQueue < Map.Entry < Character, Integer >> maxFreqChar = new PriorityQueue < Map.Entry < Character, Integer >> (
            (item1, item2) -> item2.getValue() - item1.getValue());

        maxFreqChar.addAll(charCounter.entrySet());
        
        System.out.println("Initial Heap is - "+maxFreqChar.toString());
        
        

        Map.Entry < Character, Integer > previous = null;
        StringBuilder result = new StringBuilder(string1.length());
        
        //main iteration loop
        while (!maxFreqChar.isEmpty() || previous!=null) {

            if (previous != null && maxFreqChar.isEmpty())
                return "";
            
            Map.Entry < Character, Integer > currentEntry = maxFreqChar.poll();
            System.out.println("\nRemoving this - "+currentEntry.getKey());
            int count=currentEntry.getValue()-1;
            result.append(currentEntry.getKey());
            System.out.println("Resultant string is - "+result);

            if(previous!=null){
                maxFreqChar.add(previous);
                previous=null;
            }
            
            if(count != 0){
                previous = new AbstractMap.SimpleEntry<>(currentEntry.getKey(), count);
               
            }
            System.out.println("Now Heap is - "+maxFreqChar.toString());
            
        }

        return result.toString() + "";
    }

    public static void main(String args[]) {
        String[] inputs = {
        	"aaaabcdd",
            "programming",
            "hello",
            "fofjjb",
            "abbacdde",
            "aba",
            "awesome",
            "aaab",
            "aab"
        };
        for (int i = 0; i < 1; i++) {
            System.out.print(i + 1);
            System.out.println(".\tInput string: " + inputs[i]);

            String output = reorganizeString(inputs[i]);
            output = (output.length() == 0) ? "''" : output;

            System.out.println("\n\tReorganize string: " + output);
           // System.out.println(PrintHyphens.repeat("-", 100));
        }

    }
}