package SortingAlgorithms;

public class Bubblesort extends SortingAlgorithm {
	
	@Override
	public int[] sort(int[] array) {
		boolean changed = true;
		
		while(changed) {
			changed = false;
			
			for(int i = 1; i < array.length; i++) {
				if(array[i] < array[i-1]) {
					int s = array[i];
					array[i] = array[i-1];
					array[i-1] = s;
					changed = true;
				}
			}
		}
		
		return array;
	}
	
}
