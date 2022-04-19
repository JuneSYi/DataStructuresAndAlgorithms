package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), candidates, target, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> temp, int[] candidates, int target, int k) {
        if (target <= 0) {
            if (target == 0) list.add(new ArrayList<>(temp));
            return;
        }

        for (int i = k ; i<candidates.length; i++) {
            temp.add(candidates[i]);
            backtrack(list, temp, candidates, target-candidates[i], i);
            temp.remove(temp.size()-1);
        }
    }
}
