public class Practices {

    public static boolean hasCapitals(String s) {
        if (s.length() == 0) {
            return false;
        }

        if (Character.isUpperCase(s.charAt(0))) {
            return true;
        }

        return hasCapitals(s.substring(1));
    }

    public static int min(int[] arr, int n) {
        if (n == 0) {
            return arr[0];
        }

        if (arr[n - 1] < min(arr, n - 1)) {
            return arr[n - 1];
        }

        return min(arr, n - 1);
    }

    public static String keepPositives(int[] arr, int n, String res) {
        if (n == 0) {
            return res;
        }

        if (arr[n - 1] < 0) {
            return keepPositives(arr, n - 1, res);
        }

        String newres;
        if (res.equals("")) {
            newres = res + arr[n - 1];
        } else {
            newres = res + ", " + arr[n - 1];
        }

        return keepPositives(arr, n - 1, newres);
    }
}
