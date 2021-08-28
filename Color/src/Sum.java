public class Sum {
    public static long recursiveSum(long n) {
        if (n == 0) {
            return 0;
        } else if (n > 0) {
            return n + recursiveSum(n - 1);
        } else {
            return n + recursiveSum(n + 1);
        }
    }

    public static long iterativeSum(long n) {
        long result = 0;
        if (n > 0) {
            while (n > 0) {
                result += n;
                n--;
            }
        } else if (n < 0) {
            while (n < 0) {
                result += n;
                n++;
            }
        }
        return result;
    }

    public static void main( String[] args ) {
        long a = recursiveSum(5000000);
        System.out.println("a: " + a);
        long b = iterativeSum(5000000);
        System.out.println("b: " + b);

        /*int [] nums = { 8, 16, 32, 64, 125, 250, 500,
                1_000, 2_000, 4_000, 8_000, 16_000,
                32_000, 64_000, 125_000, 250_000, 500_000,
                1_000_000, 2_000_000, 4_000_000, 8_000_000, 16_000_000,
                32_000_000, 64_000_000, 125_000_000, 250_000_000 };

        for (int n : nums) {
            long t1 = System.currentTimeMillis();
            iterativeSum(n);
            long t2 = System.currentTimeMillis();
            System.out.println( (t2-t1)+" ms for iterativeSum("+n+")" );
        }
        for (int n : nums) {
            long t1 = System.currentTimeMillis();
            recursiveSum(n);
            long t2 = System.currentTimeMillis();
            System.out.println( (t2-t1)+" ms for recursiveSum("+n+")" );
        }*/
    }

}
