package DynamicProgramming;

import java.util.HashMap;

public class ClimbingStairs {
    /**
     * You are climbing a staircase. It takes n steps to reach the top.
     *
     * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
     */
    /*
    with recursion only
     */
    public int climbStairs(int n) {
        return dp(n);
    }
    // A function that represents the answer to the problem for a given state
    // time complexity of 2^n (one of the worst), worse than n^2. because every call to dp, creates 2 more calls to dp
    private int dp(int i) {
        if (i <= 2) return i; // Base cases
        return dp(i - 1) + dp(i - 2); // Recurrence relation
    }

    /*
    with Memoization
     */
    private HashMap<Integer, Integer> memo = new HashMap<>();

    private int dpMemoization(int i) {
        if (i <= 2) return i;
        // Instead of just returning dp(i - 1) + dp(i - 2), calculate it once and then
        // store it inside a hashmap to refer to in the future
        if (!memo.containsKey(i)) {
            memo.put(i, dpMemoization(i - 1) + dpMemoization(i - 2));
        }

        return memo.get(i);
    }

    public int climbStairsMemoization(int n) {
        return dpMemoization(n);
    }

    /*
    Tabulation
     */
    public int climbStairsTabulation(int n) {
        if (n == 1) return 1;

        // An array that represents the answer to the problem for a given state
        int[] dp = new int[n + 1];
        dp[1] = 1; // Base cases
        dp[2] = 2; // Base cases
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2]; // Recurrence relation
        }

        return dp[n];
    }
}
