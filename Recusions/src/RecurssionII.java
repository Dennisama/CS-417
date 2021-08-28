public class RecurssionII {

    //Recursion III
    public static float pow(float num, int exp) {
        if (exp == 0) {
            return 1;
        }

        return num * pow(num, exp - 1);
    }

    public static boolean ordered(int[] vals, int n) {
        if (n == 1) {
            return true;
        } else {
            if (vals[n - 1] < vals[n - 2]) {
                return false;
            }

            return ordered(vals, n - 1);
        }
    }

    public static boolean charPairTest(String input) {
        if (input.length() == 0) {
            return true;
        } else if (input.length() == 1) {
            return false;
        } else {
            if (input.charAt(0) != input.charAt(1)) {
                return false;
            }

            return charPairTest(input.substring(2));
        }
    }

    public static String exchangePairs(String s) {
        if (s.length() < 2) {
            return s;
        }

        String exchanges = s.substring(1,2) + s.substring(0,1);
        return exchanges + exchangePairs(s.substring(2));
    }

    //Recursion II
    public static boolean isSubstring(String str, String sub) {
        if (str.length() < sub.length()) {
            return false;
        }

        if (str.startsWith(sub)) {
            return true;
        }

        return isSubstring(str.substring(1), sub);
    }

    public static int findLast(String[] words, int n, String key) {
        if (n == 0) {
            return -1;
        }

        if (words[n - 1].equals(key)) {
            return n - 1;
        }

        return findLast(words, n - 1, key);
    }

    public static void allIntegers(String numbers, String result) {
        if (numbers.length() == 0) {
            System.out.println(result);
        }

        for (int i = 0; i < numbers.length(); i++) {
            char n = numbers.charAt(i);
            String next = numbers.substring(0, i) + numbers.substring(i + 1);

            allIntegers(next, result + n);
        }
    }

    //Recursion I
    public static boolean palindrome(String input) {
        if (input.length() < 2) {
            return true;
        }

        if (input.charAt(0) != input.charAt(input.length() - 1)) {
            return false;
        }

        return palindrome(input.substring(1,input.length() - 1));
    }

    public static int countLetter(String input, char letter) {
        if (input.length() == 0) {
            return 0;
        }

        if (input.charAt(0) == letter) {
            return 1 + countLetter(input.substring(1), letter);
        }

        return countLetter(input.substring(1), letter);
    }

    public static int maxValue(int[] list, int n) {
        if (n == 0) {
            return list[0];
        }

        if (list[n - 1] > maxValue(list, n - 1)) {
            return list[n - 1];
        }

        return maxValue(list, n - 1);
    }

    public static int count8(int n) {
        if (n == 0) {
            return 0;
        }

        int rem1 = n % 10; //8
        int pre1 = n / 10; //18
        int rem2 = pre1 % 10; //8

        if (rem2 == rem1 && rem1 == 8) {
            return 2 * 1 + count8(pre1);
        } else if (rem2 != rem1 && rem1 == 8) {
            return 1 + count8(pre1);
        } else {
            return count8(pre1);
        }

    }

    

    public static void main(String[] args) {
        System.out.println(count8(188));
    }
}
