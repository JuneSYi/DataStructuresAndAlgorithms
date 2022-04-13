package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, nums, 0, new ArrayList<>());
        return list;
    }

    private void backtrack(List<List<Integer>> list, int[] nums, int index, List<Integer> temp) {
        // base case
        if (temp.size() == nums.length) {
            if (!list.contains(new ArrayList<>(temp))) list.add(new ArrayList<>(temp));
        }
        // recursive step
        for (int i = index ; i<nums.length; i++) {
            temp.add(nums[i]);
            backtrack(list, nums, i+1, temp);
        }
    }

    private void backtrackAns(List<List<Integer>> list, int[] nums, int index, List<Integer> temp) {
        if (temp.size() == nums.length) { // base casec
            list.add(new ArrayList<>(temp));
        }
        for (int i = 0 ; i<nums.length; i++) { // recursive step
            if(temp.contains(nums[i])) continue;
            temp.add(nums[i]);
            backtrack(list, nums, i+1, temp);
            temp.remove(temp.size()-1);
        }
    }
}
