import java.util.Arrays;

public class BubbleSort {

    public static boolean compareAndSwap(Comparable[] arr, int a, int b){ //possibly swap a single pair: O(1)
        if( arr[a].compareTo( arr[b] ) >= 1 ){
            Comparable temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
            return true;
        }

        return false;
    }

    public static boolean swapAllOutOfOrder(Comparable[] arr) { //one loop through all data to swap pairs: O(n)
        boolean swapped = false;

        for(int i = 0; i < arr.length-1; i++) {
            if(compareAndSwap(arr, i, i+1)) {
                swapped = true;
            }
        }

        return swapped;
    }

    public static void bubbleSort(Comparable[] arr) { // O(n^2)
        boolean sorted = false;

        while(!sorted) {
            sorted = !swapAllOutOfOrder(arr);
            System.out.println(Arrays.toString(arr));
        }
    }
    // invariant: after the i-th iteration, the i largest values will be in their final location

    public static void main(String[] args) {
        Integer[] arr1 = {5,2,1,10,7};

        System.out.println(Arrays.toString(arr1));

        bubbleSort(arr1);

        System.out.println();

        arr1 = new Integer[]{1,2,5,7,10};

        System.out.println(Arrays.toString(arr1));

        bubbleSort(arr1);

        System.out.println();

        arr1 = new Integer[]{10,7,5,2,1};

        System.out.println(Arrays.toString(arr1));

        bubbleSort(arr1);
    }
}
