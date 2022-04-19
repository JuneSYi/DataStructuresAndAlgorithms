package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumTwo {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), candidates, target, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> temp, int[] candidates, int target, int index) {
        if (target <= 0) {
            if (target == 0) {
                list.add(new ArrayList<>(temp));
            }
            return;
        }

        for (int i = index; i<candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i-1]) continue;
            temp.add(candidates[i]);
            backtrack(list, temp, candidates, target-candidates[i], i+1);
            temp.remove(temp.size()-1);
        }
    }
}
