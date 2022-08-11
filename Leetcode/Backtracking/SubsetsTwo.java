package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsTwo {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, nums, 0, new ArrayList<>());
        return res;
    }

    private void backtrack(List<List<Integer>> res, int[] nums, int index, List<Integer> temp) {
        if (!res.contains(new ArrayList<>(temp))) res.add(new ArrayList<>(temp));
        for (int i = index; i<nums.length; i++) {
            temp.add(nums[i]);
            backtrack(res, nums, i+1, temp);
            temp.remove(temp.size()-1);
        }
    }
}
