import SortingAlgorithms.*;

public class InputHandler {
	
	static int test = 2;
	
	static int[] inputArray;
	static int sortingDirection = 1;//1: von klein nach gross; -1: von gross nach klein
	static SortingAlgorithm sortingAlgorithm;
	
	public static void setInputArray(String inputstring) {
		String[] stringArray = InputHandler.filterInput(inputstring);
		//String[] stringArray = inputstring.split(",");
		
		//convert strings to integers
		int[] intArray = new int[stringArray.length];
		
		for(int i = 0; i < stringArray.length; i++) {
			intArray[i] = Integer.parseInt(stringArray[i]);
		}
		
		InputHandler.inputArray = intArray;
		
	}
	
	public static void setSortingDirection(int n) {
		InputHandler.sortingDirection = n;
	}
	
	public static void setSortingAlgorithm(String str) {
		switch (str) {
			case "bubblesort": 
				InputHandler.sortingAlgorithm = new Bubblesort();
				break;
			
			case "insertionsort":
				InputHandler.sortingAlgorithm = new Insertionsort();
				break;
				
			case "selectionsort":
				InputHandler.sortingAlgorithm = new Selectionsort();
				break;
				
			case "quicksort":
				InputHandler.sortingAlgorithm = new Quicksort();
				break;
			
			default:
				InputHandler.sortingAlgorithm = new Bubblesort();
		}
	}
	
	private static String[] filterInput(String inputstring) {
		inputstring = inputstring.trim();
		
		//remove all characters
		String stringWithoutCharacters = "";
		for(int i = 0; i < inputstring.length(); i++) {
			if(Character.toString(inputstring.charAt(i)).matches("[-0-9, ]")) stringWithoutCharacters += inputstring.charAt(i);
		}
		inputstring = stringWithoutCharacters;
		
		//if separation by comma, split input string at commas and return it
		if(inputstring.contains(",")) return inputstring.replace(" ","").split(",");
		
		//if not separated by comma, separate by space
		String[] inputSplitted = inputstring.split(" ");
		
		//filter out empty elements
		int count = 0;
		for(int i = 0; i < inputSplitted.length; i++) {//counting all empty elements
			if(inputSplitted[i] == "") {
				count++;
			}
		}
		
		String[] out = new String[inputSplitted.length - count];
		int j = 0;
		for(int i = 0; i < inputSplitted.length; i++) {//putting array together without empty elements
			if(!inputSplitted[i].isEmpty()) {
				out[j] = inputSplitted[i];
				j++;
			}
		}
		
		return out;
	}
}
