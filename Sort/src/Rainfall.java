public class Rainfall {
    public static double rainfall(int[] arr) {
        double res = 0;
        int sum = 0;
        int n = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -99) {
                break;
            }

            if (arr[i] >= 0) {
                sum += arr[i];
                n++;
            }
        }

        if (n != 0) {
            res = (double) sum / n;
        }

        return res;
    }
}
