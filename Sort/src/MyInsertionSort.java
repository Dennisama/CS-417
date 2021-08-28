public class MyInsertionSort {
    public static void insert(Comparable[] arr, Comparable val, int size) {
        arr[size] = val;
        for (int i = size - 1; i >= 0; i--) {
            if (val.compareTo(arr[i]) >= 1) {
                return;
            }

            Comparable temp = arr[i];
            arr[i] = arr[i + 1];
            arr[i + 1] = temp;
        }
    }

    public static void insertionSort(Comparable[] arr) {
        for (int i = 1; i < arr.length; i++) {
            insert(arr, arr[i], i);
        }
    }
}
