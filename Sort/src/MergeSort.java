import java.util.ArrayList;
import java.util.Arrays;

public class MergeSort {

    // assumption: arr1 and arr2 are already sorted
    // our job is to merge them into one larger sorted array
    // NOTE: can be done without making new arrays ("in place")
    // O(n)
    public static Integer[] merge(Integer[] arrA, Integer[] arrB){ // O(n) where n is size of A + size of B
        Integer[] ret = new Integer[arrA.length + arrB.length];
        //will store the data from both arrays

        int topA = 0;
        int topB = 0;
        int i = 0; //where to put things in ret
        // while there is data left to take from both
        while(topA < arrA.length && topB < arrB.length) {
            if(arrA[topA] < arrB[topB]) {
                ret[i] = arrA[topA];
                topA++;
            } else {
                ret[i] = arrB[topB];
                topB++;
            }
            i++;
        }
        // empty out A if not empty
        while(topA < arrA.length) {
            ret[i] = arrA[topA];
            topA++;
            i++;
        }
        // empty out B if not empty
        while(topB < arrB.length) {
            ret[i] = arrB[topB];
            topB++;
            i++;
        }

        return ret;
    }


    // assumption: items in range start1, end1 and start2, end2 are already sorted
    // our job is to merge them into one larger sorted array
    // merge in place (saves memory!)
    // O(n)
    public static void merge(Comparable[] arr,
                             int start1, int end1,
                             int start2, int end2) {
        for(int i = start1; i <= end2 && start1 < start2; i++) {
            if(arr[start1].compareTo(arr[start2]) < 0) {
                start1++;
            } else {
                //swap the values at start1 and start2
                Comparable temp = arr[start1];
                arr[start1] = arr[start2];
                arr[start2] = temp;
                start1++;
                //shift the value now at start2 to correct place
                 for(int j = start2;
                    j < end2 && arr[j].compareTo(arr[j+1]) > 0;
                    j++) {
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public static void mergeSort(Comparable[] arr) {
        mergeSort(arr, 0, arr.length-1);
    }



    private static void mergeSort(Comparable[] arr, int start, int end) { // O(n * log n)
        if(start != end) {
            printRange("Before: ", arr, start, end);
            //split by calling mergeSort recursively
            // will do log_2(n) splits
            int mid = (start + end)/2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid+1, end);
            //merge the split (and now sorted) portions
            //will so log_2(n) merges
            merge(arr, start, mid, mid+1, end);  // O(n)
            printRange("After: ", arr, start, end);
        } else {
            printRange("", arr, start, end);
        }
    }

    public static void printRange(String prefix, Comparable[] arr, int start, int end) {
        System.out.print(prefix + "[");
        for(int i = start; i < end; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println(arr[end] + "]");
    }


    public static void main(String[] args) {
        Integer[] arr = {5, 2, 1, 7, 10, 8};

        //5,2,1     and    7, 10, 8
        //5, 2    and 1 and 7, 10    and 8
        //5 and 2 and 1 and 7 and 10 and 8
        //on 5 items, did 3 splits (and therefore 3 merges)

        mergeSort(arr);

        System.out.println();



        arr = new Integer[]{1,7,10,2,5,8};

        mergeSort(arr);

        System.out.println();



        arr = new Integer[]{10,8,7,5,2,1};

        mergeSort(arr);

        System.out.println();
    }
}
