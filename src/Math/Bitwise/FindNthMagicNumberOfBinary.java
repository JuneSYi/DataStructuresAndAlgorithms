package Math.Bitwise;

public class FindNthMagicNumberOfBinary {
    /**
     * AMAZON question
     * Find the nth magic #
     * 		5^3 5^2 5^1 respectively
     * 1st magic # = 0 0 1 and take the additional powers to 5. ans: 5 (5^1)
     * 2nd magic#= 0 1 0 ->25
     * 3rd magic#= 0 1 1 ->30
     * 4th magic#= 1 0 0 ->125
     * 5th magic#= 1 0 1 -> 130
     * How do you find nth? Lets say n =6
     * Whats the binary form of 6 ->1 1 0
     * N & 1 -> will give us the last digit/# in binary
     * N >> 1 to ignore the last 0, we'll loop this.
     */

    public static void main(String[] args) {
        int n = 6;

        int ans = 0;
        int base = 5;
        while (n > 0) {
            int last = n & 1;
            n = n >> 1;
            ans += last * base;
            base = base * 5;
        }
        System.out.println(ans);
    }
}

/*
    bitwise shift left operator
    (10)base10 == (1010)base2
    so 1010 << 1 = 10100 = (20) base10
    thus, any x << 1 = 2x; just doubles it
    e.g. 20 << 1 = 40
    THUS, a << b = a * 2^b

    right shift operator
    0011001 >> 1 = 001100
    a >> b = a / 2^b

 */

/**
 * the problem: A magic number is defined as a number which can be expressed as a power of 5 or sum of unique powers of 5. First few magic numbers are 5, 25, 30(5 + 25), 125, 130(125 + 5), ….
 * Write a function to find the nth Magic number.
 *
 * Describing a bit as being "set" or "clear" is just another way of saying that the bit has the value 1 (set) or 0 (clear).
 *
 * static int nthMagicNo(int n)
 *   {
 *      int pow = 1, answer = 0;
 *
 *      // Go through every bit of n
 *      while (n != 0)
 *      {
 *        pow = pow*5;
 *
 *        // If last bit of n is set
 *        if ((int)(n & 1) == 1)
 *          answer += pow;
 *
 *        // proceed to next bit
 *        // or n = n/2
 *        n >>= 1;
 *      }
 *      return answer;
 *   }
 *
 *   // Driver program to test
 *   // above function
 *   public static void main(String[] args)
 *   {
 *     int n = 5;
 *     System.out.println("nth magic" +
 *     " number is " + nthMagicNo(n));
 *   }
 */
