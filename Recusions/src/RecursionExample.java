public class RecursionExample {
    public static int factorial(int n) {
        System.out.println( "n is " + n );
        if (n == 0) {
            System.out.println( "0!=1" );
            return 1;
        }
        else {
            System.out.println( "need factorial of " + (n-1) );
            int answer = factorial(n-1);
            System.out.println( "factorial of " + (n-1)
                    + " is " + answer );
            return answer * n;
        }
    }

    public static void count1(int n) {
        if (n >= 1) {
            System.out.println(n);
            count1(n-1);
        }
    }

    public static void count2(int n) {
        if (n >= 1) {
            count2(n-1);
            System.out.println(n);
        }
    }


    public static void main(String[] args) {
        /*System.out.println( "3!=" + factorial(3) );*/
        count2(5);
    }

}
