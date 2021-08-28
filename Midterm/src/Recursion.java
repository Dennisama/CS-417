import java.util.ArrayList;

public class Recursion {

    private ArrayList<String> dictionary;

    public static boolean nestParen(String str) {
        int n = str.length();

        if (n == 0) {
            return true;
        }

        if (str.charAt(n - 1) == '(') {
            return false;
        }

        if (str.charAt(0) == ')') {
            return false;
        }



        if (str.charAt(0) == '(' && str.charAt(n - 1) != ')'
                && str.charAt(n - 1) != '(') {

            return nestParen(str.substring(0, n - 1));


        } else if (str.charAt(0) != '(' && str.charAt(0) != ')'
                && str.charAt(n - 1) == ')') {

            return nestParen(str.substring(1));

        } else {

            return nestParen(str.substring(1, n - 1));

        }

    }

    // Given a string and a non-empty substring sub,
    // compute recursively if at least n copies of
    // sub appear in the string somewhere, possibly
    // with overlapping. N will be non-negative.
    // eg. strCopies("catcowcat", "cat", 2) → true
    //     strCopies("catcowcat", "cow", 2) → false
    public static boolean strCopies(String str, String sub, int n) {
        if (n == 0) {
            return true;
        } else {
            if (str.length() < sub.length()) {
                return false;
            }
        }

        if (str.substring(0, sub.length()).equals(sub)) {
            return strCopies(str.substring(1), sub, n - 1);
        }

        return strCopies(str.substring(1), sub, n);
    }

    // Given a string and a non-empty substring sub, compute recursively
    // the largest substring which starts and ends with sub and return
    // its length.
    // e.g strDist("catcowcat", "cat") → 9
    //     strDist("catcowcat", "cow") → 3
    //     strDist("cccatcowcatxx", "cat") → 9
    public int strDist(String str, String sub) {
        if (str.length() < sub.length()) {
            return 0;
        }

        boolean condition1 = str.substring(0, sub.length()).equals(sub);
        boolean condition2 = str.substring(str.length() - sub.length()).equals(sub);

        if (condition1 && condition2) {
            if (str.length() == sub.length()) {
                return sub.length();
            } else {
                if (str.length() < 2 * sub.length()) {
                    return str.length();
                }

                return 2 * sub.length()
                        + str.substring(sub.length(), str.length() - sub.length()).length();
            }
        } else if (!condition1 && condition2) {
            return strDist(str.substring(1), sub);
        } else if (condition1) {
            return strDist(str.substring(0, str.length() - 1), sub);
        } else {
            if (str.length() == sub.length()) {
                return 0;
            }

            return strDist(str.substring(1, str.length() - 1), sub);
        }
    }

    public void permutation(String word, String res) {
        if (word.length() == 0) {
            System.out.println(res);
        }

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            String next = word.substring(0,i) + word.substring(i + 1);
            permutation(next, res + c);
        }

    }

    public boolean makeword(String word, String res) {
        if (word.length() == 0) {
            if (dictionary.contains(res)) {
                return true;
            }

            return false;
        }

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            String next = word.substring(0, i) + word.substring(i + 1);
            boolean isfound = makeword(next, res + c);
            if (isfound) {
                return true;
            }
        }

        return false;
    }
}
