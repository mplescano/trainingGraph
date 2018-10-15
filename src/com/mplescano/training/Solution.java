package com.mplescano.training;
import java.util.ArrayList;
import java.util.List;
// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED
public class Solution
{
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    List<List<Integer>> optimalUtilization(
	                        int deviceCapacity, 
                            List<List<Integer>> foregroundAppList,
                            List<List<Integer>> backgroundAppList)
	{
        // WRITE YOUR CODE HERE
        List<List<Integer>> solutionIdsFgBg = new ArrayList<List<Integer>>(); 
        
        for (List<Integer> itemFgApp : foregroundAppList) {
            Integer idFgApp = itemFgApp.get(0);
            Integer memFgApp = itemFgApp.get(1);
            for (List<Integer> itemBgApp : backgroundAppList) {
                Integer idBgApp = itemBgApp.get(0);
                Integer memBgApp = itemBgApp.get(1);
                if (memFgApp.intValue() + memBgApp.intValue() == deviceCapacity) {
                    List<Integer> pairSolutionId = new ArrayList<>();
                    pairSolutionId.add(idFgApp);
                    pairSolutionId.add(idBgApp);
                    solutionIdsFgBg.add(pairSolutionId);
                }
            }
        }
        
        if (solutionIdsFgBg.size() == 0) {
            List<Integer> tmpItemFgApp = null;
            List<Integer> tmpItemBgApp = null; 
            for (List<Integer> itemFgApp : foregroundAppList) {
                Integer idFgApp = itemFgApp.get(0);
                Integer memFgApp = itemFgApp.get(1);
                for (List<Integer> itemBgApp : backgroundAppList) {
                    Integer idBgApp = itemBgApp.get(0);
                    Integer memBgApp = itemBgApp.get(1);
                    if (memFgApp.intValue() + memBgApp.intValue() < deviceCapacity) {
                        if (tmpItemFgApp == null && tmpItemBgApp == null) {
                            tmpItemFgApp = itemFgApp;
                            tmpItemBgApp = itemBgApp;
                        }
                        else {
                            Integer tmpMemFgApp = tmpItemFgApp.get(1);
                            Integer tmpMemBgApp = tmpItemBgApp.get(1);
                            if (memFgApp.intValue() + memBgApp.intValue() > tmpMemFgApp.intValue() + tmpMemBgApp.intValue()) {
                                tmpItemFgApp = itemFgApp;
                                tmpItemBgApp = itemBgApp;
                            }
                        }
                    }
                }
            }
            if (tmpItemFgApp != null && tmpItemBgApp != null) {
                List<Integer> pairSolutionId = new ArrayList<>();
                pairSolutionId.add(tmpItemFgApp.get(0));
                pairSolutionId.add(tmpItemBgApp.get(0));   
                solutionIdsFgBg.add(pairSolutionId);
            }
        }
        
        return solutionIdsFgBg;
    }
    // METHOD SIGNATURE ENDS
}