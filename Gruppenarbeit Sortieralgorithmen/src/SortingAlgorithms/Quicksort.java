package SortingAlgorithms;

/*
 * coded by Marlon
 */

public class Quicksort extends SortingAlgorithm {

	@Override
	public int[] sort(int[] array) {
		//Wenn Array/Teilarray nur aus einem oder keinem Element besteht, muss es nicht sortiert werden.
		if(array.length == 0) return array;
		if(array.length == 1) return array;
		
		int pivotIndex = Math.round((float) array.length / 2 - 0.5f);//Pivot Element wird festgelegt
		
		//Indizes werden gesetzt
		int j = 0;
		int k = array.length - 1;
		
		while(true) {
			
			while(array[j] < array[pivotIndex] && j < pivotIndex) {
				j++;//Indize j wird soweit vergrößert, bis Element im Array an der Stelle j größer ist, als das pivot Element
			}
			
			while(array[k] > array[pivotIndex] && k > pivotIndex) {
				k--;//Indize k wird soweit verkleinert, bis Element im Array an der Stelle k kleiner ist, als das pivot Element
			}
			
			//Falls j und k gleich sind, liegen sie beide auf dem pivot Element => alle Zahlen wurden auf die richtige Seite des pivot Elements gebracht
			if(j == k) {
				//Array wird am pivot Element, welches sich nun an seinem richtigen Platz befindet, aufgeteilt in zwei Teilarrays
				int[] arr1 = Quicksort.splitArray(array, pivotIndex, "left");
				int[] arr2 = Quicksort.splitArray(array, pivotIndex, "right");
				
				//Beide Teilarrays werden sortiert mit dem Quicksort-Algorithmus
				arr1 = sort(arr1);
				arr2 = sort(arr2);
				
				//Beide Teilarrays werden mit dem pivot Element in der Mitte wieder zusammengefügt und zurückgegeben
				return Quicksort.joinArray(arr1, arr2, array[pivotIndex]);
			}
			
			//Element an der Stelle j wird getauscht mit dem Element an der Stelle k
			int cashe = array[j];
			array[j] = array[k];
			array[k] = cashe;
			
			//j und k müssen einen Schritt weiter in Richtung (und max. bis zum) pivot Element gehen, da es zu Fehlern kommt, 
			//wenn das Element an der Stelle j/k gleich groß ist, wie das pivot Element.
			if(j == pivotIndex) {
				//pivot Element befindet sich nach dem Tauschen nun an der Stelle k
				pivotIndex = k;
				j++;
			}else if(k == pivotIndex) {
				//pivot Element befindet sich nach dem Tauschen nun an der Stelle j
				pivotIndex = j;
				k--;
			}else {
				j++;
				k--;
			}
		}
	}
	
	public static int[] splitArray(int[] array, int splitAt, String Case) {
		int[] output;
		
		switch(Case) {
		case "left":
			//alle Elemente links neben dem Element an der Stelle splitAt werden in ein Array gespeichert, welches dann ausgegeben wird.
			output = new int[splitAt];
			for(int i = 0; i < splitAt; i++) {
				output[i] = array[i];
			}
			return output;
			
		case "right":
			//alle Elemente rechts neben dem Element an der Stelle splitAt werden in ein Array gespeichert, welches dann ausgegeben wird.
			output = new int[array.length - 1 - splitAt];
			int j = 0;
			for(int i = splitAt + 1; i < array.length; i++) {
				output[j] = array[i];
				j++;
			}
			return output;
			
		default:
			System.out.println("Du musst eine Seite des Arrays, links(\"left\") oder rechts(\"right\") vom angegebenen Element, angeben!");
		}
		
		return null;
	}
	
	public static int[] joinArray(int[] arr1, int[] arr2, int joinInsertion) {
		int[] output = new int[arr1.length + arr2.length + 1];//Array erschaffen mit der Länge beider Arrays + dem Element dazwischen
		
		//alle Elemente des Arrays arr1 zum Array output hinzufügen
		for(int i = 0; i < arr1.length; i++) {
			output[i] = arr1[i];
		}
		
		output[arr1.length] = joinInsertion;//Element joinInsertion zum Array output hinzufügen

		//alle Elemente des Arrays arr2 zum Array output hinzufügen
		for(int i = 0; i < arr2.length; i++) {
			output[arr1.length + 1 + i] = arr2[i];
		}
		
		return output;//Zusammengefügtes Array zurückgeben
	}

}
