package Amazon.ArraysAndStrings;

import java.sql.Array;
import java.util.*;

/*
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        //Collections.sort(Arrays.asList(num));
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < num.length - 2; i++) {
            if (i == 0 || (i > 0 && num[i] != num[i - 1])) {
                int lo = i + 1, hi = num.length - 1, sum = 0 - num[i];
                while (lo < hi) {
                    if (num[lo] + num[hi] == sum) {
                        res.add(Arrays.asList(num[i], num[lo], num[hi]));
                        while (lo < hi && num[lo] == num[lo + 1]) lo++;
                        while (lo < hi && num[hi] == num[hi - 1]) hi--;
                        lo++;
                        hi--;
                    } else if (num[lo] + num[hi] < sum) lo++;
                    else hi--;
                }
            }
        }
        return res;
    }
}
/*
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(i, nums[i]); // each index will have their own number
        }

        for (int i = 0; i < map.size(); i++) {
            if (twoSum(map, map.get(i), i) != null) {
                ans.add(new ArrayList<>(twoSum(map, map.get(i), i)));
            }
        }
        return ans;
    }

    private List<Integer> twoSum(Map<Integer, Integer> graph, int target, int skip) {
        for (int i = 0; i < graph.size(); i++) {
            for (int j = i+1; j < graph.size(); j++) {
                if (i == skip || j == skip) continue;
                int k = graph.get(i);
                int l = graph.get(j);
                if (k + l + target == 0 && i != j) {
                    List<Integer> dan = new ArrayList<>();
                    dan.add(graph.get(i));
                    dan.add(graph.get(j));
                    dan.add(target);
                    return dan;
                }
            }
        }
        return null;
    }
*/
