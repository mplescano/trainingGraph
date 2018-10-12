package com.mplescano.training.sorting;
// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED
public class AmazonDemoCellAdjacent
{        
  // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public List<Integer> cellCompete(int[] states, int days)
    {
    // WRITE YOUR CODE HERE
    	int sizeCell = states.length;
    	int[] nextDayStates = new int[sizeCell];
    	
    	int count = 0;
    	int countDay = 1;
    	while (countDay <= days) {
    		while (count < sizeCell) {
    			if (count == 0) {
    				if (/*states[count - 1] == 0 &&*/ states[count + 1] == 0) {
    					nextDayStates[count] = 0;
    				}
    				else if (/*states[count - 1] == 0 &&*/ states[count + 1] == 1) {
    					nextDayStates[count] = 1;
    				}
    			}
    			else if (count == sizeCell - 1) {
    				if (states[count - 1] == 0 /*&& states[count + 1] == 0*/) {
    					nextDayStates[count] = 0;
    				}
    				else if (states[count - 1] == 1 /*&& states[count + 1] == 0*/) {
    					nextDayStates[count] = 1;
    				}
    			}
    			else {
    				if ((states[count - 1] == 0 && states[count + 1] == 0) ||
    						(states[count - 1] == 1 && states[count + 1] == 1)) {
    					nextDayStates[count] = 0;
    				}
    				else {
    					nextDayStates[count] = 1;
    				}
    			}
    			
    			count++;
    		}
			states = nextDayStates;
			nextDayStates = new int[sizeCell];
			countDay++;
			count = 0;
		}
    	
		return IntStream.of(states).mapToObj(Integer::valueOf).collect(Collectors.toList());
    }
  // METHOD SIGNATURE ENDS
    
    public static void main(String[] args) {
    	
    	AmazonDemoCellAdjacent test = new AmazonDemoCellAdjacent();
    	
    	//System.out.println(test.cellCompete(new int[] {1, 0, 0, 0, 0, 1, 0, 0}, 1));
    	
    	//System.out.println(test.cellCompete(new int[] {1, 1, 1, 0, 1, 1, 1, 1}, 1));
    	
    	System.out.println(test.cellCompete(new int[] {1, 1, 1, 0, 1, 1, 1, 1}, 2));
    	
    }
    
    
    
}