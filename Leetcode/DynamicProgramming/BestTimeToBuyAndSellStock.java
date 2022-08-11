package DynamicProgramming;

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        if (prices.length<2) return 0;
        int[] dp = new int[prices.length+1];
        dp[0] = 0;
        dp[1] = prices[1] - Math.min(prices[0], prices[1]);
        return 0;
        //failed problem
    }
}
