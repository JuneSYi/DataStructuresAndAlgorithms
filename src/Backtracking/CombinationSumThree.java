package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumThree {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(k, n, new ArrayList<>(), list, 1);
        return list;
    }

    private void backtrack(int k, int n, List<Integer> temp, List<List<Integer>> list, int start) {
        if (n<=0 && k == 0) {
            if (n==0) list.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i<10; i++) {
            temp.add(i);
            backtrack(k-1, n-i,temp,list,i+1);
            temp.remove(temp.size()-1);
        }
    }
}
