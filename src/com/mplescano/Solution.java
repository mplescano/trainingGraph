package com.mplescano;

import java.util.Stack;

public class Solution
{ 
	// METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
	public static int totalScore(String[] blocks, int n)
	{
		// WRITE YOUR CODE HERE
		Stack<String> numberScores = new Stack<String>();
		int totalScore = 0;
		for(int i = 0; i < blocks.length; i++) {
		    System.out.println("Score: " + blocks[i]);
		    String simbolScore = blocks[i];
            if ("-".equals(simbolScore.charAt(0) + "") || Character.isDigit(simbolScore.charAt(0))) {
                numberScores.push(simbolScore);
                totalScore += Integer.parseInt(simbolScore);
                System.out.println("size: " + numberScores.size());
            }
            else if ("X".equals(simbolScore)) {
            	if (numberScores.size() > 0) {
                	totalScore += (Integer.parseInt(numberScores.peek()) * 2);
                    numberScores.push((Integer.parseInt(numberScores.peek()) * 2) + "");
                    System.out.println("size: " + numberScores.size());
            	}
            }
            else if ("+".equals(simbolScore)) {
            	if (numberScores.size() > 1) {
                    System.out.println("size: " + numberScores.size());
                	String last = numberScores.peek();
                	System.out.println("last: " + last);
                	String beforeLast = numberScores.elementAt(numberScores.size() - 2);
                	System.out.println("beforeLast: " + beforeLast);
                	totalScore += Integer.parseInt(last) + Integer.parseInt(beforeLast);
                	numberScores.push((Integer.parseInt(last) + Integer.parseInt(beforeLast)) + "");
            	}
            }
            else if ("Z".equals(simbolScore)) {
            	if (numberScores.size() > 0) {
                	String prevScore = numberScores.pop();
                	totalScore -= Integer.parseInt(prevScore);
                    System.out.println("size: " + numberScores.size());
            	}
            }
            System.out.println("Total: " + totalScore);

		}
		
		return totalScore;
	}
	// METHOD SIGNATURE ENDS
}