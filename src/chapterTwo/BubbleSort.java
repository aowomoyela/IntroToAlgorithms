package chapterTwo;

public class BubbleSort {
	public static final String algorithmName = "Bubble Sort";
	
	public static int[] sortInts(int[] array) {
		// Sort an array by swapping out-of-order elements.
		// The subarray array[0] is trivially-sorted. array[0-1] can be sorted by a single swap, or none.
		// Once we have array[0-2], we have three possible combinations: [2] is greater than both [0] and [1] (already sorted)...
		// ...[2] is greater than [0] but less than [1], or [2] is less than both [0] and [1].
		// So, we need to compare [2] against [1], perform any swapping, and then compare [1] against [0] again.
		for (int i = 1; i < array.length; i++) {
			for ( int j = i; j > 0; j-- ) {
				if ( array[j] < array[j-1] ) {
					int hold = array[j];
					array[j] = array[j-1];
					array[j-1] = hold;
				}
			}
		}
		
		return array;
	}

}
