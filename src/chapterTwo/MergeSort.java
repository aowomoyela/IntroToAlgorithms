package chapterTwo;

import java.util.Arrays;

public class MergeSort {
	public static final String algorithmName = "Merge Sort";
	
	public static int[] sortInts(int[] array) {
		// We're given an array.
		// If the array has more than one element, split it into two smaller arrays, each of which will be sorted using this function.
		// If the array has only one element, it's already sorted ÐÊtrivially.
		// With each of the sorted subarrays, we combine them by comparing the current first element of each array.
		// The smaller current first element is added to the new, larger sorted array, and removed from/ignored in its original array.
		int[] array1 = null;
		int[] array2 = null;
		
		// Split.
		if (array.length > 1) {
			int firstIndex = 0;
			int midIndex = (int)(Math.floor(array.length / 2));
			int lastIndex = array.length; // The "to" index of copyOfRange is exclusive and may lie outside the array.
			// Create the subarrays.
			array1 = Arrays.copyOfRange(array, firstIndex, midIndex);
			array2 = Arrays.copyOfRange(array, midIndex, lastIndex);
		} else {
			// This array is trivially sorted.
			return array;
		}
		
		// Sort.
		int[] sortedArray1 = sortInts(array1);
		int[] sortedArray2 = sortInts(array2);
		
		// Merge.
		int[] mergedArray = mergeInts(sortedArray1, sortedArray2);
		
		// temporary
		return mergedArray;
	}
	
	private static int[] mergeInts(int[] array1, int[] array2) {
		// Take two arrays ÐÊassumed to be already sorted ÐÊand create a third array from them.
		int a1Index = 0;
		int a2Index = 0;
		int a1Length = array1.length;
		int a2Length = array2.length;
		boolean a1Exhausted = false;
		boolean a2Exhausted = false;
		int totalElements = array1.length + array2.length;
		int[] mergedArray = new int[totalElements];
		// Compare the current element of each array.
		for (int mIndex = 0; mIndex < totalElements; mIndex++) {
			if ( a1Exhausted ) {
				// There are no more elements in array1. Copy in all remaining elements of array2.
				mergedArray[mIndex] = array2[a2Index];
				a2Index++;
				if ( a2Index >= a2Length ) { a2Exhausted = true; }
			} else if ( a2Exhausted ) {
				// There are no more elements in array2. Copy in all remaining elements of array1.
				mergedArray[mIndex] = array1[a1Index];
				a1Index++;
				if ( a1Index >= a1Length ) { a1Exhausted = true; }
			} else {
				// We still have elements in each of the lists.  Continue comparing them.
				if ( array1[a1Index] <= array2[a2Index] ) {
					// Privilege array1's element when elements are equal, because we've gotta choose one of them, so why not this one?
					mergedArray[mIndex] = array1[a1Index];
					a1Index++;
					if ( a1Index >= a1Length ) { a1Exhausted = true; }
				} else {
					mergedArray[mIndex] = array2[a2Index];
					a2Index++;
					if ( a2Index >= a2Length ) { a2Exhausted = true; }
				}
			}
		}
		// Return the merged array.
		return mergedArray;
	}

}
