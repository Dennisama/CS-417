public class RecurssionI {

    public static boolean palindrome (String input) {
        int length = input.length();

        if (length == 0) {
            return true;
        }

        if (input.charAt(0) != input.charAt(length - 1)) {
            return false;
        }

        return palindrome(input.substring(1, length - 1));
    }

    public static int countLetter (String input, char letter) {
        if (input.length() == 0) {
            return 0;
        }

        if (input.charAt(0) == letter) {
            return countLetter(input.substring(1), letter) + 1;
        }

        return countLetter(input.substring(1), letter);
    }

    public static int maxValue (int[] list, int n) {
        if (n == 0) {
            return list[0];
        }

        if (list[n - 1] > maxValue(list, n - 1)) {
            return list[n - 1];
        }

        return maxValue(list, n - 1);
    }

    public static boolean ordered(int[] vals, int n) {
        if (n == 1) {
            return true;
        }

        if (!ordered(vals, n - 1) || (vals[n] < vals[n - 1])) {
            return false;
        }

        return ordered(vals, n - 1);
    }

    public static boolean charPairTest(String input) {
        if (input.length() == 0) {
            return true;
        } else {
            if (input.length() == 1) {
                return false;
            } else {
                if(!input.substring(0,1).equals(input.substring(1,2))) {
                    return false;
                }

                return charPairTest(input.substring(1));
            }
        }
    }

    public static String exchangePairs(String s) {
        if (s.length() < 2) {
            return s;
        } else {
            String exchanges = s.substring(1,2) + s.substring(0,1);
            return exchanges + exchangePairs(s.substring(2));
        }
    }

    public static void printHalves(int[] a) {
        for (int i = a.length - 1; i > 0; i /= 2) {
            System.out.println("a[" + i + "]=" + a[i]);
        }
    }

    public static void main(String[] args) {
        int[] intArray = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        printHalves(intArray);
    }
}
