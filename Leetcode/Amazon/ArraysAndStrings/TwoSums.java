package Amazon.ArraysAndStrings;

import java.util.HashMap;
import java.util.Map;

public class TwoSums {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) { // i+1 is key so j always stays ahead of i
                if (nums[i] + nums[j] == target) {
                    ans[0] = i;
                    ans[1] = j;
                    return ans;
                }
            }
        }
        return null;
    }

    public int[] twoSumHash(int[] nums, int target) {
        int[] ans = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int j = 0; j < nums.length; j++) {
            int cur = target - nums[j];
            if (map.containsKey(cur) && map.get(cur) != j) {
                ans[0] = map.get(nums[j]);
                ans[1] = map.get(cur);
                return ans;
            }
            
        }
        return null;
    }
}
