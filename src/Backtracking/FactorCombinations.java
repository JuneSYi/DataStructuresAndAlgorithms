package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class FactorCombinations {
    public List<List<Integer>> getFactors(int n) {
        if (n%2==1) return new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        backtrack();
        return list;
    }

    private void backtrack(List<List<Integer>> list, int n, List<Integer> temp, int num) {
        if (n != num) {
            if (!list.contains(new ArrayList<>(temp))) list.add(new ArrayList<>(temp));
        }

        for (int i = 2; i<n/2; i=i+2) {
            if (n % i != 0) continue;
            temp.add(i);
            temp.add(n/i);
        }
        /*
        we can iterate from 2 -> half of n and add +2 per iteration
        each iteration we can check if n % i != 0 then continue (skip that iteration, we only want perfect numbers)
        divide the original by int i
        */
    }

    public List<List<Integer>> getFactorsOptimal(int n) {
        List<List<Integer>> result = new ArrayList<>(); // create arraylist
        helper(result, new ArrayList<Integer>(), n, 2);
        return result;
    }

    public void helper(List<List<Integer>> result, List<Integer> item, int n, int start){ // 4 values
        if (n <= 1) { // number will eventually be reduced to 1
            if (item.size() > 1) {
                result.add(new ArrayList<Integer>(item));
            }
            return;
        }

        for (int i = start; i <= n; ++i) { //starts with 2
            if (n % i == 0) { //if no remainders
                item.add(i); // then we can add
                helper(result, item, n/i, i); //recurse into new number once we divide by i, starts with 2,
                // we'll build the list that has 2 and every number after.
                item.remove(item.size()-1);
            }
        }
}
