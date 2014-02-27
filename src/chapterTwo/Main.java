package chapterTwo;

public class Main {
	public static void main(String[] args) {
		int[] intArray = {1,3,2,10,4,9,5,7,2,6,8};
		// int[] sorted = InsertionSort.sortInts(intArray);
		// int[] sorted = MergeSort.sortInts(intArray);
		// int[] sorted = BubbleSort.sortInts(intArray);
		int[] sorted = ShellSort.sortInts(intArray);

		for ( int i = 0; i < sorted.length; i++ ) {
			System.out.println( sorted[i] );
		}
	}
}
