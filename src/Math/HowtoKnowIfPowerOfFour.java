package Math;

public class HowtoKnowIfPowerOfFour {
    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(1024));
    }

    static boolean isPowerOfTwo(int n) {
        if (n == 0) return false;
        while (n % 4 == 0 ) n /= 4;
        return n == 1;
    }
}
