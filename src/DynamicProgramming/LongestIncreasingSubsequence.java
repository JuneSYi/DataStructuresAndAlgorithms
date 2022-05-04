package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) { // compares every previous number up to nums[i],
                    dp[i] = Math.max(dp[i], dp[j]+1); //if nums[i] is greater we compare subsequences and add if
                }
            }
        }
        int longest = 0;
        for (int c : dp) {
            longest = Math.max(longest, c);
        } // finds the biggest number and assigns it to longest
        return longest;
    }

    public int lengthOfLISTwo(int[] nums) {
        ArrayList<Integer> sub = new ArrayList<>();
        sub.add(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (num > sub.get(sub.size() - 1)) {
                sub.add(num);
            } else {
                // Find the first element in sub that is greater than or equal to num
                int j = 0;
                while (num > sub.get(j)) {
                    j += 1;
                }

                sub.set(j, num);
            }
        }

        return sub.size();
    }
}
