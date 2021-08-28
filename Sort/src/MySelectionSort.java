public class MySelectionSort {
    public static void findMinAndSwap(Comparable[] arr, int start) {
        int minIndex = start;
        for (int i = start + 1; i < arr.length; i++) {
            if (arr[minIndex].compareTo(arr[i]) >= 1) {
                minIndex = i;
            }
        }

        Comparable temp = arr[start];
        arr[start] = arr[minIndex];
        arr[minIndex] = temp;
    }

    public static void selectionSort(Comparable[] arr) {
        // Attention ! i ends at arr.length - 1.
        for (int i = 0; i < arr.length - 1; i++) {
            findMinAndSwap(arr,i);
        }
    }
}
