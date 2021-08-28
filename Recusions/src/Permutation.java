import java.util.ArrayList;

public class Permutation {

    public static ArrayList<String> dictionary;

    public static void permutation(String word, String res) {
        if (word.length() == 0) {
            System.out.println(res);
        }

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            String next = res.substring(0, i) + res.substring(i + 1);
            permutation(next, res + c);
        }
    }

    public static boolean makeword(String word) {
        return mw(word, "");
    }

    public static boolean mw(String s, String res) {
        if (s.length() == 0) {
            if (dictionary.contains(res)) {
                System.out.println(res);
                return true;
            }

            return false;
        }

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            String next = s.substring(0,i) + s.substring(i + 1);
            boolean found = mw(next, res + c);
            if (found) {
                return true; // return terminates the loop !
            }
        }

        return false;
    }
}
