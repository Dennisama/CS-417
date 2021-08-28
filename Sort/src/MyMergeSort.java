import java.util.ArrayList;
import java.util.Arrays;

public class MyMergeSort {
    public static void merge(Comparable[] arr,
                             int start1, int end1,
                             int start2, int end2) {
        for (int i = start1; i <= end2 && start1 < start2; i++) {
            if (arr[start1].compareTo(arr[start2]) < 0) {
                start1++;
            } else {
                Comparable temp = arr[start1];
                arr[start1] = arr[start2];
                arr[start2] = temp;
                start1++;

                for (int j = start2; j < end2 && arr[j].compareTo(arr[j + 1]) > 0; j++) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void mergeSort(Comparable[] arr, int start, int end) {
        while(start != end) {
            int mid = (start + end)/2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            merge(arr, start, mid, mid + 1, end);
        }
    }
}
