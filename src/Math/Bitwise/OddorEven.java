package Math.Bitwise;

public class OddorEven {
    /**
     * when you & 1 with any #, the digits remain the same
     * every # is calculated in binary form internally
     *
     * 12 + 7
     *  1100
     *  0111
     *  ----
     * 10011
     *
     * 19 base 10 = 10011 base 2
     *
     * for 10011, the first 4 digits, are all power of 2. only the last 1 is going to be 2 ^ 0.
     * thus, if the last digit is 1, the # will be odd.
     */
    public static void main(String[] args) {
        int n = 67;
        System.out.println(isOdd(n));
    }

    private static boolean isOdd(int n) {
        return (n & 1) == 1;
    }
}
