public class Main {

    public boolean palindrome(String test) {
        int lengthoftest = test.length();
        if (lengthoftest == 0 || lengthoftest == 1) {
            return true;
        } else if (test.charAt(0) != test.charAt(lengthoftest - 1)) {
            return true;
        } else {
            return palindrome(test.substring(1, lengthoftest - 1));
        }
    }

    public static int maxValue( int[] list, int n) {
        if (n == 1) {
            return list[0];
        } else {
            int ret = Math.max(list[n - 1], maxValue(list, n - 1));
            System.out.println("The Larger is " + ret);
            return ret;
        }
    }

    public static int countLetter(String input, char letter) {
        if (input.length() == 0) {
            return 0;
        }
        char a = 'a';
        Character.isUpperCase(a);

        if (input.substring(0, 1).equals(letter)) {
            return 1 + countLetter(input.substring(1), letter);
        }

        return countLetter(input.substring(1), letter);
    }

    public static void main(String[] args) {
        int a = countLetter("abbbcaabb", 'b');
        System.out.println("The Max is " + a);
    }
}
