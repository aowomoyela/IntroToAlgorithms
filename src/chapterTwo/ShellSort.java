package chapterTwo;

public class ShellSort {
	public static final String algorithmName = "ShellSort";

	public static int[] sortInts(int[] array) {
		// Do a swap sort between pairs of elements with decreasing gaps between them.
		// Using Marcin Ciura's gap sequence, just 'cause.
		int[] gaps = {701, 301, 132, 57, 23, 10, 4, 1};
		
		for (int gap : gaps) {
		    // Do an insertion sort for each gap size.
		    for (int current = gap; current < array.length; current++) {
		        int hold = array[current];
		        int compare;
		        for (compare = current; compare >= gap && array[compare - gap] > hold; compare -= gap) {
		            array[compare] = array[compare - gap];
		        }
		        array[compare] = hold;
		    }

		}
		
		return array;
	}

}
