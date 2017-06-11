package com.mplescano.training.sorting;

//[2,5] [3,7,8]
//[6,8,9] [3,4,7]
//[1,2,7] [4,5]
public class TestExam {

	public int[] sorter(int[] arrInt01, int[] arrInt02) {
		
		int sizeMerge = arrInt01.length + arrInt02.length;
		int[] arrMerge = new int[sizeMerge];
		int countArr01 = 0;
		int countArr02 = 0;
		int countMerge = 0;
				
		while (countArr01 < arrInt01.length) {
			
			/*if (countArr02 == arrInt02.length) {
				arrMerge[countMerge++] = arrInt01[countArr01];
			}*/
			
			boolean pickedItemArr01 = false;
			while (countArr02 < arrInt02.length) {
				if (arrInt01[countArr01] < arrInt02[countArr02]) {
					arrMerge[countMerge++] = arrInt01[countArr01];
					pickedItemArr01 = true;
					break;
				}
				else if (arrInt01[countArr01] > arrInt02[countArr02]) {
					arrMerge[countMerge++] = arrInt02[countArr02];
					countArr02++;
				}
				else {
					arrMerge[countMerge++] = arrInt01[countArr01];
					pickedItemArr01 = true;
					break;
				}
			}
			
			if (!pickedItemArr01 && (countArr01 + 1 == arrInt01.length || countArr02 == arrInt02.length)) {
				arrMerge[countMerge++] = arrInt01[countArr01];
			}

			if (countArr01 + 1 == arrInt01.length && countArr02 < arrInt02.length) {
				for (int innerCountArr02 = countArr02; countArr02 < arrInt02.length; innerCountArr02++) {
					arrMerge[countMerge++] = arrInt02[innerCountArr02];
				}
			}
			
			countArr01++;
		}
		
		return arrMerge;
	}
	
	public static void main(String[] args) {
		TestExam objTestExam = new TestExam();
		
		int[] arrMerge = objTestExam.sorter(new int[]{1, 2, 7},  new int[]{4, 5});
		for (int itemInt : arrMerge) {
			System.out.print(itemInt + " ");
		}
		
		System.out.println();
		
		int[] arrMerge2 = objTestExam.sorter(new int[]{6, 8, 9},  new int[]{3, 4, 7});
		for (int itemInt : arrMerge2) {
			System.out.print(itemInt + " ");
		}
	}
}
