package DynamicProgramming;

import java.util.HashMap;

public class DeleteAndEarnTopDown {
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

    /**
     * Top-down
     * from: https://leetcode.com/problems/delete-and-earn/solution/
     */
    private HashMap<Integer, Integer> points = new HashMap<>();
    private HashMap<Integer, Integer> cache = new HashMap<>(); // cache is used to memoize our recursive function

    /*
    We want maxPoints(num) to return the maximum points that we can gain if
    we only consider all the elements in nums with values between 0 and num.
    we start from the highest number and go down. the highest number is determined by maxNumber and passed as
    the initial number for maxPoints(num);
     */
    private int maxPoints(int num) {
        // Check for base cases
        if (num == 0) {
            return 0;
        }
        /*
        The third component of a dynamic programming solution is base cases. Typically, we can find base cases
        with a little bit of logical thinking. First, maxPoints(0) will always be equal to 0. Second, when considering
        maxPoints(1), we only care about the elements 0 and 1. We do not care about 2 because of how we defined
        maxPoints(x). Looking at the recurrence relation, we know that if we arrived at 1, it means that we must not
        have taken 2, and because 1 times any quantity will be greater than or equal to the number of points we
        can get from taking 0, we should always take 1 (if there are any).
         */

        if (num == 1) {
            return points.getOrDefault(1, 0);
        }

        if (cache.containsKey(num)) { //for memoization, if it's already in cache, we can just cache.get(num)
            return cache.get(num);
        }

        // Apply recurrence relation.
        int gain = points.getOrDefault(num, 0); //if we takes gain, we can also take the maxPoints(num-2) with gain
        cache.put(num, Math.max(maxPoints(num - 1), maxPoints(num - 2) + gain));
        // we put the higher value in and recurse. the recursions goes all the way down until 1 or 0 (base case)
        // we dont need to do +1 because we're already not taking the +1 (skipping the maxPoints(num-1) from previous)

        return cache.get(num);
    }

    public int deleteAndEarnTopDown(int[] nums) {
        int maxNumber = 0;

        // Precompute how many points we gain from taking an element
        for (int num : nums) {
            points.put(num, points.getOrDefault(num, 0) + num);
            maxNumber = Math.max(maxNumber, num);
        }

        return maxPoints(maxNumber);
    }
}
