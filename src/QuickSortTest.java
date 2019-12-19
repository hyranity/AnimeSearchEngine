
import Util.*;
import java.util.Arrays;

public class QuickSortTest<E extends Comparable<E>> {

    public static void main(String[] args) {
        Integer[] arr = new Integer[] {1,6,8,5,3};
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public void sort(List<E> list) {
        list = new List();

        // Obtain pivot from middle item
        E pivot = list.getRecord(list.size - (list.size / 2));

        int lowerGroup = 0;
        int higherGroup = list.size;

    }

    public static void quickSort(Integer[] arr, int low, int high) {
        //check for empty or null array
        if (arr == null || arr.length == 0) {
            return;
        }

        if (low >= high) {
            return;
        }

        //Get the pivot element from the middle of the list
        int middle = low + (high - low) / 2;
        int pivot = arr[middle];
        System.out.println("PIVOT = ");

        // make left < pivot and right > pivot
        int i = low, j = high;
        while (i <= j) {
            //Check until all values on left side array are lower than pivot
            while (arr[i] < pivot) {
                System.out.println("[i] Looping size " + arr[i] + " < " + arr[j]);
                i++;
            }
            System.out.println("[i] Looping stopped. Found: " + arr[i]);
            //Check until all values on left side array are greater than pivot
            while (arr[j] > pivot) {
                System.out.println("[j] Looping size " + arr[j] + " < " + arr[j]);
                j--;
            }
            System.out.println("[j] Looping stopped. Found: " + arr[j]);
            //Now compare values from both side of lists to see if they need swapping 
            //After swapping move the iterator on both lists
            if (i <= j) {
                System.out.println("Swap because " + arr[i] + " <= " + arr[j]);
                swap(arr, i, j);
                i++;
                j--;
            }
        }
        //Do same operation as above recursively to sort two sub arrays
        if (low < j) {
            quickSort(arr, low, j);
        }
        if (high > i) {
            quickSort(arr, i, high);
        }
    }
    
     public static void swap (Integer array[], int x, int y)
    {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }
}
