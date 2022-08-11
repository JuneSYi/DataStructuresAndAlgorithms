package DynamicProgramming;

public class MinCostClimbingStiars {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        dp[0] = 0;
        dp[1] = 0;

        for (int i = 2; i<cost.length; i++) {
            dp[i] = Math.min(cost[i] + dp[i-2], dp[i-1]);
        }

        return dp[cost.length-1];
    }
}
