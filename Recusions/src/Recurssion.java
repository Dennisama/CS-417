public class Recurssion {
    public static boolean hasCapitals(String s) {
        if (s.length() == 1) {
            if (Character.isUpperCase(s.charAt(0))) {
                return true;
            }
            return false;
        } else if (Character.isUpperCase(s.charAt(0))) {
            return true;
        }
        return hasCapitals(s.substring(1));
    }

    public static int min(int[] arr, int n) {
        if(n == 1) {
            return arr[n - 1];
        }

        if(arr[n - 1] < min(arr, n - 1)) {
            return arr[n - 1];
        }
            return min(arr, n - 1);

    }

    public static String keepPositives(int[] arr, int n, String res){
        if(n == 0) {
            return res;
        }

        if(arr[n - 1] < 0) {
            return keepPositives(arr, n - 1, res);
        }

        String newres = arr[n - 1] + ", " + res;
        return keepPositives(arr, n - 1, newres);
    }

    public static void main( String[] args ){
        System.out.println( keepPositives( new int[]{-2, 5, 7, -3, 2}, 5, "" ) ); // returns "5, 7, 2"
        System.out.println( keepPositives( new int[]{2, 3, 4}, 3, "" ) ); // returns "2, 3, 4"
        System.out.println( keepPositives( new int[]{-2, -3}, 2, "" ) ); // returns ""
    }
}
