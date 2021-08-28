import java.util.Arrays;

public class InsertionSort {

    public static void insert(Comparable[] arr, Comparable val, int size){
        arr[size] = val;
        for( int i = size-1; i >= 0; i-- ){ // loops over up to n-1 items in the worst case: O(n)
            if( val.compareTo( arr[i] ) >= 1 )
                return; //quit if val is in place
            //otherwise, swap val downward
            Comparable temp = arr[i];
            arr[i] = arr[i+1];
            arr[i+1] = temp;
        }
    }

    public static void insertionSort(Comparable[] arr) { // O(n^2)
        for(int i = 1; i < arr.length; i++) { // loops n-1 times: O(n)
            insert(arr, arr[i], i); // O(n)
            System.out.println(Arrays.toString(arr));
        }
    }
    //best case: sorted data
    //worst case: reverse sorted data
    //invariants: after the i-th iteration, the first i elements are sorted relative to each other


    public static void main(String[] args) {
        Integer[] arr1 = {5,2,1,10,7};

        System.out.println(Arrays.toString(arr1));

        insertionSort(arr1);

        System.out.println();

        arr1 = new Integer[]{1,2,5,7,10};

        System.out.println(Arrays.toString(arr1));

        insertionSort(arr1);

        System.out.println();

        arr1 = new Integer[]{10,7,5,2,1};

        System.out.println(Arrays.toString(arr1));

        insertionSort(arr1);
    }
}
