import java.util.Arrays;

public class SelectionSort {

    public static void findMinAndSwap( Comparable[] arr, int start ){
        int minIndex = start;
        for( int i = start+1; i < arr.length; i++ ){  // O(n)
            if( arr[minIndex].compareTo( arr[i] ) >= 1 )
                minIndex = i;
        }
        Comparable temp = arr[start];
        arr[start] = arr[minIndex];
        arr[minIndex] = temp;
    }


    public static void selectionSort(Comparable[] arr) { // O(n^2)
        for(int i = 0; i < arr.length-1; i++) { // runs O(n) times
            findMinAndSwap(arr, i); // O(n)

            System.out.println(Arrays.toString(arr));
        }
    }
    // invariants: after the i-th iteration, the i lowest values will be in their final location


    public static void main(String[] args) {
        Integer[] arr1 = {5,2,1,10,7};

        System.out.println(Arrays.toString(arr1));

        selectionSort(arr1);

        System.out.println();

        arr1 = new Integer[]{1,2,5,7,10};

        System.out.println(Arrays.toString(arr1));

        selectionSort(arr1);

        System.out.println();

        arr1 = new Integer[]{10,7,5,2,1};

        System.out.println(Arrays.toString(arr1));

        selectionSort(arr1);
    }
}
