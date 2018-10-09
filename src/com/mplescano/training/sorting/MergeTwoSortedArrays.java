package com.mplescano.training.sorting;

import java.util.Arrays;

public class MergeTwoSortedArrays {

	static int[] arr1 = { 1, 5, 9, 10, 15, 20 };

	static int[] arr2 = { 2, 3, 8, 13 };

	static void mergeFirstMethod(int[] arrOne, int[] arrTwo) {
		int lengthArrOne = arrOne.length;
		for (int countTwo = arrTwo.length - 1; countTwo >= 0; countTwo--) {

			int countOne, lastItemOne = arrOne[lengthArrOne - 1];
			for (countOne = lengthArrOne - 2; countOne >= 0
					&& arrOne[countOne] > arrTwo[countTwo]; countOne--) {
				arrOne[countOne + 1] = arrOne[countOne];
				System.out.println("Step 1 Array One" + Arrays.toString(arrOne));
			}
			System.out.println("Step 1 Array Two" + Arrays.toString(arrTwo));
			if (countOne != lengthArrOne - 2 || lastItemOne > arrTwo[countTwo]) {
				arrOne[countOne + 1] = arrTwo[countTwo];
				arrTwo[countTwo] = lastItemOne;
			}
			System.out.println("Step 2 Array One" + Arrays.toString(arrOne));
			System.out.println("Step 2 Array Two" + Arrays.toString(arrTwo));
		}
	}

	static int[] mergeSecondMethod(int[] arrOne, int[] arrTwo) {
		int lengthArrOne = arrOne.length;
		int lengthArrTwo = arrTwo.length;
		int[] arrThree = new int[lengthArrOne + lengthArrTwo];
		
		
		int countOne = 0;
		int countTwo = 0;
		int countThree = 0;
		while (countOne < lengthArrOne && countTwo < lengthArrTwo) {
			
			if (arrOne[countOne] < arrTwo[countTwo]) {
				arrThree[countThree++] = arrOne[countOne++];
			}
			else {
				arrThree[countThree++] = arrTwo[countTwo++];
			}
		}
		
		while (countOne < lengthArrOne) {
			arrThree[countThree++] = arrOne[countOne++];
		}
		
		while (countTwo < lengthArrTwo) {
			arrThree[countThree++] = arrTwo[countTwo++];
		}
		
		return arrThree;
	}
	
	// Driver method to test the above function
	public static void main(String[] args) {
		//mergeFirstMethod(arr1, arr2);
		//System.out.print("After Merging nFirst Array: ");
		//System.out.println(Arrays.toString(arr1));
		//System.out.print("Second Array:  ");
		//System.out.println(Arrays.toString(arr2));
		
		System.out.println("Result:" + Arrays.toString(mergeSecondMethod(arr1, arr2)));
	}

}