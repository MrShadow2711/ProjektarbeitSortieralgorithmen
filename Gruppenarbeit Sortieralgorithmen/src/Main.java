import java.util.Arrays;
import SortingAlgorithms.*;



class Main {
      
      public static void main(String[] args) {
            //Bubblesort test
            SortingAlgorithm alg = new Bubblesort();
            int[] arr = {5,3,7,7,8,3,4,4,1};
            
            System.out.println(Arrays.toString(alg.sort(arr)));
            
            //Frame test
            //Frame frame = new Frame();
            
            //Input Handler test
            InputHandler.setInputArray("23  4 77, 3 2 4");
            System.out.println(Arrays.toString(InputHandler.inputArray));
            
            InputHandler.setSortingDirection(-1);
            System.out.println(InputHandler.sortingDirection);
            
            InputHandler.setSortingAlgorithm("quicksort");
            System.out.println(InputHandler.sortingAlgorithm);
            
            //sorting and flip test
            InputHandler.sortingAlgorithm = new Bubblesort();
            int[] output = InputHandler.sortingAlgorithm.sort(InputHandler.inputArray);
            System.out.println(Arrays.toString(output));
            System.out.println(Arrays.toString(SortingAlgorithm.flipArray(output)));
            
            System.out.println("12345678".matches("[0-9]*"));
            
            System.out.println("Test");
            
            InputHandler.setInputArray("5,3,7,7,8,3,4,4,1");
            //InputHandler.setInputArray("4,3,2,1");
            InputHandler.setSortingAlgorithm("quicksort");
            System.out.println(Arrays.toString(InputHandler.inputArray));
            InputHandler.setSortingDirection(1);
            System.out.println(Arrays.toString(getSortedArray()));
            
            //int[] arr1 = {1,2,3,4,5,6};
            //System.out.println(Arrays.toString(Quicksort.splitArray(arr1, 3, "right")));
            
      }
      
      public static int[] getSortedArray() {
            int[] sortedArray = InputHandler.sortingAlgorithm.sort(InputHandler.inputArray);
            
            if(InputHandler.sortingDirection != -1) return sortedArray;
            return SortingAlgorithm.flipArray(sortedArray);
      }
      
}