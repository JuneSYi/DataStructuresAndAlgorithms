package Math.Bitwise;

public class NumberAppearsOnce {
    public static void main(String[] args) {
        int[] arr = new int[]{2,3,4,1,2,1,3,6,4};
        int value = arr[0];
        for (int i = 1; i < arr.length; i++) {
            value ^= arr[i];
        }
        System.out.println(value);
    }
    /**
     * xor (exclusive or) ^
     * 0  0  1  1  a
     * 0  1  0  1  b
     * ------------
     * 0  1  1  0  a^b
     *
     * a ^ 1 = 1
     * a ^ 0 = a
     * a ^ a = 0
     */
}
