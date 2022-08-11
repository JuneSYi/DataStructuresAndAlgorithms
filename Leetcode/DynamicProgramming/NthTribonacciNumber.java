package DynamicProgramming;

import java.util.HashMap;

public class NthTribonacciNumber {
    /**
     * The Tribonacci sequence Tn is defined as follows:
     *
     * T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.
     *
     * Given n, return the value of Tn.
     */
    /*
    tabulation, bottom up
     */
    public int tribonacci(int n) {
        int[] sum = new int[n+1];
        sum[0] = 0;
        sum[1] = 1;
        sum[2] = 1;
        for (int i = 3; i < sum.length; i++) {
            sum[i] = sum[i-3] + sum[i-2] + sum[i-1];
        }
        return sum[n];
    }

    /*
    memoization, top down
     */
    public int tibomemo(int n) {
        return dp(n);
    }
    HashMap<Integer, Integer> map = new HashMap<>();
    public int dp(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;

        if (!map.containsKey(n)) {
            map.put(n, dp(n-1)+dp(n-2)+dp(n-3));
        }
        return map.get(n);
    }
}
