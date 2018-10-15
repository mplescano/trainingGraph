package com.mplescano.training.numbers;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
import java.util.List;
// CLASS BEGINS, THIS CLASS IS REQUIRED
public class SolutionOne
{
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    List<List<Integer>> nearestXsteakHouses(int totalSteakhouses, 
                                         List<List<Integer>> allLocations, 
                                         int numSteakhouses)
	{
        // WRITE YOUR CODE HERE
        List<List<Integer>> solutionsCoordinates = new ArrayList<List<Integer>>();
        if (totalSteakhouses > allLocations.size()) {
            return solutionsCoordinates;
        }
        if (numSteakhouses > totalSteakhouses) {
            return solutionsCoordinates;
        }
        
        for (List<Integer> itemCoordenates : allLocations) {
            if (solutionsCoordinates.size() < numSteakhouses) {
                solutionsCoordinates.add(itemCoordenates);
            }
            else {
                Integer xChallCoord = itemCoordenates.get(0);
                Integer yChallCoord = itemCoordenates.get(1);
                MathContext mathContext = new MathContext(3, RoundingMode.HALF_UP);
                BigDecimal distanceChallenge = new BigDecimal(Math.sqrt(xChallCoord.intValue() * xChallCoord.intValue() + yChallCoord.intValue() * yChallCoord.intValue()), mathContext);
                
                for (int countSolItem = 0; countSolItem < solutionsCoordinates.size(); countSolItem++) {
                    List<Integer> solItemCoordinate = solutionsCoordinates.get(countSolItem);
                    Integer xSolCoord = solItemCoordinate.get(0);
                    Integer ySolCoord = solItemCoordinate.get(1);
                    BigDecimal distanceSolution =  new BigDecimal(Math.sqrt(xSolCoord.intValue() * xSolCoord.intValue() + ySolCoord.intValue() * ySolCoord.intValue()), mathContext);
                    if (distanceChallenge.compareTo(distanceSolution) < 0) {
                        solutionsCoordinates.set(countSolItem, itemCoordenates);
                    }
                    else if (distanceChallenge.compareTo(distanceSolution) == 0) {
                        if (xChallCoord.intValue() < xSolCoord.intValue()) {
                            solutionsCoordinates.set(countSolItem, itemCoordenates);
                        }
                    }
                }
                
            }
            
        }
        
        return solutionsCoordinates;
    }
    // METHOD SIGNATURE ENDS
    
    public static void main(String args[]) {
        SolutionOne sol = new SolutionOne();
        
        List<List<Integer>> coordinates = new ArrayList<List<Integer>>();
        List<Integer> itemCoordenates = new ArrayList<>();
        itemCoordenates.add(0);
        itemCoordenates.add(0);
        coordinates.add(itemCoordenates);
        System.out.println(sol.nearestXsteakHouses(1, coordinates, 0));
        
        
    }
}