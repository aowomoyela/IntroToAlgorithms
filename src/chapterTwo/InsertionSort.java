package chapterTwo;

public class InsertionSort {
	public static final String algorithmName = "Insertion Sort";

	public static int[] sortInts(int[] array) {
		// Loop through the array, looking at each number in turn.
		for (int current = 0; current < array.length; current++) {
			// Hang on to the current number we're sorting.
			int hold = array[current];
			// tailCompare is the index position of the last value in the sorted subarray array[0 ... current-1]
			int tailCompare = current-1;
			// Go backwards through the sorted subarray until we find a value that's not larger than the current number...
			while ( tailCompare >= 0 && array[tailCompare] > hold ) {
				// ...moving numbers up one space (to make room for the smaller number to go earlier in the sequence) as we go.
				array[tailCompare+1] = array[tailCompare];
				tailCompare--;
			}
			// The while loop breaks when it's on a number that's not smaller than the hold value. Place the hold value just after it.
			array[tailCompare+1] = hold;
		}
		// Return the sorted array.
		return array;
	}
	
}
