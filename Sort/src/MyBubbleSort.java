import java.util.Arrays;

public class MyBubbleSort {
    public static boolean compareAndSwap(Comparable[] arr, int a, int b) {// O(1)
        boolean isSwap = false;

        if (arr[a].compareTo(arr[b]) >= 1) {
            Comparable temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
            isSwap = true;
        }

        return isSwap;
    }

    public static boolean swapAllOutOfOrder(Comparable[] arr) {//O(n)
        boolean isSwap = false;
        for (int i = 0; i < arr.length - 1; i++) {
            if (compareAndSwap(arr, i, i + 1)) {
                isSwap = true;
            }
        }

        return isSwap;
    }

    public static void bubbleSort(Comparable[] arr) {//O(n^2)
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = !swapAllOutOfOrder(arr); // Attention !
        }
    }
}
