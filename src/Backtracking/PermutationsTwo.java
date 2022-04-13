package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class PermutationsTwo {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] bool = new boolean[nums.length];
        backtrack(res, nums, 0, new ArrayList<>(), bool);
        return res;
    }

    private void backtrack(List<List<Integer>> res, int[] nums, int index, List<Integer> temp, boolean[] bool) {
        if (temp.size() == nums.length) {
            if (!res.contains(new ArrayList<>(temp))) res.add(new ArrayList<>(temp));
        }

        for (int i = 0; i<nums.length; i++) {
            if (bool[i]) continue;
            temp.add(nums[i]);
            bool[i] = true;
            backtrack(res, nums, index+1, temp, bool);
            bool[i] = false;
            temp.remove(temp.size()-1);
        }
    }
    /*
    given array, might have duplicates
    return all unique permutations in any order

    */
}
