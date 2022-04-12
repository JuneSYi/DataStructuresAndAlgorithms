package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
    // 78 leetcode
    // https://www.youtube.com/watch?v=REOH22Xwdkk&ab_channel=NeetCode
    // https://leetcode.com/problems/subsets/discuss/27281/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partitioning)

    public List<List<Integer>> subsets(int[] nums) {
        /*
        return a list of arrays
        i feel like maps would be my go to
        could we backtrack to keep track of all possible combinations?
        */
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, nums, 0, nums.length, new ArrayList<>(0));
        return res;
    }

    private void backtrack(List<List<Integer>> res, int[] nums, int index, int max, List<Integer> arr) {
        if (arr.size() > nums.length) return;
        res.add(arr);

        if (index < max) {
            arr.add(nums[index]);
            backtrack(res, nums, index+1, max, arr);
        }
    }

    /*
    Cascading
     */
    public List<List<Integer>> cascading(int[] nums) {
        List<List<Integer>> output = new ArrayList();
        output.add(new ArrayList<>());

        for (int num : nums) {
            List<List<Integer>> newSubsets = new ArrayList();
            for (List<Integer> curr : output) {
                newSubsets.add(new ArrayList<>(curr){{add(num);}});
            }
            for (List<Integer> curr : newSubsets) {
                output.add(curr);
            }
        }
        return output;
    }

    /*
    backtracking with structure
     */
    public List<List<Integer>> subsetsBackTrack(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        // Arrays.sort(nums); // why sort? not needed for subset I, needed for subset II
        backtrackOpt(list, new ArrayList<>(), nums, 0);
        return list;
    }

    // our backtrack function takes in the list, a temporary list, the initial input array, and a pointer
    private void backtrackOpt(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
        list.add(new ArrayList<>(tempList)); // immediately add the templist
        for(int i = start; i < nums.length; i++){
            tempList.add(nums[i]); // starts at zero, iterates through num array
            backtrackOpt(list, tempList, nums, i + 1); // recurse with start value +1
            tempList.remove(tempList.size() - 1); // we remove the last item to have recursion happen starting with each value of index i
        }
    }
}
