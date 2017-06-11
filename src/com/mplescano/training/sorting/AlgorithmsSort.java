package com.mplescano.training.sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 
 * 
 * 
 * @author mlescano
 *
 * @param <T>
 */
public class AlgorithmsSort {

	/**
	 * Time Complexity: O(n^2) - Horrible 
	 * Space Complexity: O(1) - Excellent
	 * 
	 * @see https://en.wikipedia.org/wiki/Bubble_sort
	 * 
	 * @param lstItems
	 */
	public static <T extends Comparable<T>> void bubbleSort(List<T> lstItems) {
		int limitUpper = lstItems.size();
		do {
			int posLastSwap = 0;
			for (int currCount = 1; currCount < limitUpper; currCount++) {
				if (lstItems.get(currCount - 1).compareTo(lstItems.get(currCount)) > 0) {
					swap(currCount - 1, currCount, lstItems);
					posLastSwap = currCount;
				}
			}
			limitUpper = posLastSwap;
		} while (limitUpper == 0);
	}

	/**
	 * Time Complexity: O(n^2) - Horrible 
	 * Space Complexity: O(1) - Excellent
	 * 
	 * @see https://en.wikipedia.org/wiki/Insertion_sort
	 * 
	 * @param lstItems
	 */
	public static <T extends Comparable<T>> void insertionSort(List<T> lstItems) {
		int sizeItems = lstItems.size();
		for (int currCount = 1; currCount < sizeItems; currCount++) {
			T tempItem = lstItems.get(currCount);
			int stepBackCount = currCount - 1;
			while (stepBackCount >= 0 && lstItems.get(stepBackCount).compareTo(tempItem) > 0) {
				lstItems.set(stepBackCount + 1, lstItems.get(stepBackCount));
				stepBackCount--;
			}
			lstItems.set(stepBackCount + 1, tempItem);
		}
	}

	public static <T extends Comparable<T>> void quickSort(List<T> lstItems) {
		int sizeItems = lstItems.size();
		int lowerLimit = 0;
		int upperLimit = sizeItems - 1;

		quickSort(lstItems, lowerLimit, upperLimit);
	}

	public static <T extends Comparable<T>> void quickSort(List<T> lstItems, int lowerLimit, int upperLimit) {
		int lowerCount = lowerLimit;
		int upperCount = upperLimit;
		// Get the pivot element from the middle of the list
		T pivotItem = lstItems.get(lowerLimit + ((upperLimit - lowerLimit) / 2));

		// Divide into two lists
		while (lowerCount <= upperCount) {
			// If the current value from the left list is smaller than the pivot
			// element then get the next element from the left list
			while (lstItems.get(lowerCount).compareTo(pivotItem) < 0) {
				lowerCount++;
			}

			// If the current value from the right list is larger than the pivot
			// element then get the next element from the right list
			while (lstItems.get(upperCount).compareTo(pivotItem) > 0) {
				upperCount--;
			}

			// If we have found a value in the left list which is larger than
			// the pivot element and if we have found a value in the right list
			// which is smaller than the pivot element then we exchange the
			// values.
			// As we are done we can increase i and j
			if (lowerCount <= upperCount) {
				swap(lowerCount, upperCount, lstItems);
				lowerCount++;
				upperCount--;
			}
		}

		// Recursion
		if (lowerLimit < upperCount) {
			quickSort(lstItems, lowerLimit, upperCount);
		}

		if (lowerCount < upperLimit) {
			quickSort(lstItems, lowerCount, upperLimit);
		}
	}

	private static final int DEFAULT_BUCKET_SIZE = 5;

	public static <T extends Comparable<T>> void bucketSort(List<T> lstItems) {
		bucketSort(lstItems, DEFAULT_BUCKET_SIZE);
	}

	public static <T extends Comparable<T>> void bucketSort(List<T> lstItems, int bucketSize) {
		int sizeItems = lstItems.size();
		if (sizeItems == 0) {
			return;
		}

		// Determine minimum and maximum values
		T minValue = lstItems.get(0);
		int indexMinValue = 0;
		T maxValue = lstItems.get(0);
		int indexMaxValue = 0;
		for (int i = 0; i < sizeItems; i++) {
			T item = lstItems.get(i);
			if (item.compareTo(minValue) < 0) {
				minValue = item;
				indexMinValue = i;
			} else if (item.compareTo(maxValue) > 0) {
				maxValue = item;
				indexMaxValue = i;
			}
		}

		// Initialise buckets
		int bucketCount = calculateCountBuckets(minValue, maxValue, bucketSize, sizeItems);
		List<List<T>> buckets = new ArrayList<List<T>>(bucketCount);
		for (int i = 0; i < bucketCount; i++) {
			buckets.add(new ArrayList<T>());
		}

		// Distribute input array values into buckets
		for (int i = 0; i < sizeItems; i++) {
			if (i == indexMinValue) {
				buckets.get(0).add(cloneOrCopy(lstItems.get(i)));
			} else if (i == indexMaxValue) {
				buckets.get(bucketCount - 1).add(cloneOrCopy(lstItems.get(i)));
			} else {
				buckets.get(i / bucketSize).add(cloneOrCopy(lstItems.get(i)));
			}
		}

		// Sort buckets and place back into input array
		int currentIndex = 0;
		for (int i = 0; i < bucketCount; i++) {
			// T[] bucketArray = new T[buckets.get(i).size()];
			// bucketArray = buckets.get(i).toArray(bucketArray);
			List<T> itemBucketArray = buckets.get(i);
			// InsertionSort.sort(bucketArray);
			insertionSort(itemBucketArray);
			int sizeItemBucket = itemBucketArray.size();
			for (int j = 0; j < sizeItemBucket; j++) {
				// array[currentIndex++] = bucketArray[j];
				lstItems.set(currentIndex++, itemBucketArray.get(j));
			}
		}
		insertionSort(lstItems);
	}

	private static <T> T cloneOrCopy(T t) {
		return t;
	}

	private static <T extends Comparable<T>> int calculateCountBuckets(T minValue, T maxValue, int bucketSize,
			int sizeItems) {
		if (sizeItems % bucketSize < bucketSize) {
			return (sizeItems / bucketSize) + 1;
		}
		return (sizeItems / bucketSize);
	}

	private static <T> void swap(int i, int i2, List<T> lstItems) {
		T item02 = lstItems.get(i2);
		T item01 = lstItems.set(i, item02);
		lstItems.set(i2, item01);
	}

	private static List<Long> setup() {
		int maxValue = 1000;
		int size = 108;
		List<Long> lstNumbers = new ArrayList<Long>(size);
		Random generator = new Random();
		for (int i = 0; i < size; i++) {
			lstNumbers.add(i, Long.valueOf(generator.nextInt(maxValue)));
		}
		return lstNumbers;
	}

	private static void printResult(List<Long> numbers) {
		int size = numbers.size();
		for (int i = 0; i < size; i++) {
			System.out.print(numbers.get(i) + " ");
		}
		System.out.println();
	}

	public static void testQuickSort() {
		List<Long> numbers = setup();
		printResult(numbers);

		long startTime = System.currentTimeMillis();

		quickSort(numbers);

		long stopTime = System.currentTimeMillis();
		long elapsedTime = stopTime - startTime;
		System.out.println("Quicksort " + elapsedTime);

		if (!validate(numbers)) {
			System.out.println("Should not happen");
		}
		System.out.println("Excellent");
		printResult(numbers);
	}

	public static void testInsertionSort() {
		List<Long> numbers = setup();
		printResult(numbers);

		long startTime = System.currentTimeMillis();

		insertionSort(numbers);

		long stopTime = System.currentTimeMillis();
		long elapsedTime = stopTime - startTime;
		System.out.println("Insertion " + elapsedTime);

		if (!validate(numbers)) {
			System.out.println("Should not happen");
		}
		System.out.println("Excellent");
		printResult(numbers);
	}

	public static void testBucketSort() {
		List<Long> numbers = setup();
		printResult(numbers);

		long startTime = System.currentTimeMillis();

		bucketSort(numbers);

		long stopTime = System.currentTimeMillis();
		long elapsedTime = stopTime - startTime;
		System.out.println("Bucket " + elapsedTime);

		if (!validate(numbers)) {
			System.out.println("Should not happen");
		}
		System.out.println("Excellent");
		printResult(numbers);
	}

	private static boolean validate(List<Long> numbers) {
		int size = numbers.size();
		for (int i = 0; i < size - 1; i++) {
			if (numbers.get(i).longValue() > numbers.get(i + 1).longValue()) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		testQuickSort();
		testInsertionSort();
		testBucketSort();
	}

}
