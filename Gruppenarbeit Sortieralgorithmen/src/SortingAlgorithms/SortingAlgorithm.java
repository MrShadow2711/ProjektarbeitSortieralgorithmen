package SortingAlgorithms;

/*
 * programmed by Marlon
 */

public abstract class SortingAlgorithm {
	abstract public int[] sort(int[] array);
	
	public static int[] flipArray(int[] array) {
		int[] out = new int[array.length];
		
		for(int i = 0; i < array.length; i++) {
			out[out.length-i-1] = array[i];
		}
		
		return out;
	}
}
