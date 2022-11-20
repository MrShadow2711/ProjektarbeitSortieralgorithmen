package SortingAlgorithms;

/*
 * programmed by Tarek
 */

public class Insertionsort extends SortingAlgorithm {

	@Override
	public int[] sort(int[] zahlen) {						//Methode Insertion Sort Algorithmus; sortiert ausgew‰hlte Zahlen von klein nach Groﬂ
		for (int i = 1; i < zahlen.length; i++) {			//i = aktuell ausgew‰hltes Element und wechselt ggf. "seinen Platz" -> Es wandert bei jedem "vollendeten Vergleichsprozess" mit Element j um ein "Array Element" nach rechts  
			int currentValue = zahlen[i];
			
			int j = i - 1;									//j = Element, welches mit i verglichen wird. Es bewegt sich im Array immer weiter nach links, bis das Array "fertig ist" und wechselt seinen Platz mit i, wenn j>i
			while (j >= 0 && zahlen[j] > currentValue) {
				zahlen[j + 1] = zahlen[j];
				j--;
			}
			zahlen[j + 1] = currentValue;
		}
		return zahlen;
	}
}
