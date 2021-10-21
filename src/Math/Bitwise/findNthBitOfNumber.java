package Math.Bitwise;

public class findNthBitOfNumber {
    /**
     * find i^th bit of a #
     * 10110110
     * ----------
     * 87654321
     * find 5th bit, would be 1, but how do we find it?
     * we need a mask (separate a number entity you have to get the answer)
     * to find 5th bit, we see that it has 4 zeros (0 0 0 1 0 0 0 0 )
     *
     * 1 << (n-1) where is 5 in this problem
     * ans: n & (1 << (n-1))
     */
}
