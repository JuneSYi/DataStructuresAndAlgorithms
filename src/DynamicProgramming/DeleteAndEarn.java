package DynamicProgramming;

import java.util.HashMap;

public class DeleteAndEarn {
    HashMap<Integer, Integer> map = new HashMap<>();
    public int deleteAndEarn(int[] nums) {
        int[] buckets = new int[10001];
        for (int num : nums) {
            buckets[num] += num; // adds all the numbers for that value and places them in num index
        }
        int[] dp = new int[10001];
        dp[0] = buckets[0];
        dp[1] = buckets[1];
        for (int i = 2; i < buckets.length; i++) {
            dp[i] = Math.max(buckets[i] + dp[i - 2], dp[i - 1]); // compares which number is bigger.
        }
        return dp[10000];
    }
}
