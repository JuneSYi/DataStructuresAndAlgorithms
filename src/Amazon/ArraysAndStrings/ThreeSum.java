package Amazon.ArraysAndStrings;

import java.sql.Array;
import java.util.*;

/*
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.
 */
public class ThreeSum {
    public List<List<Integer>> threeSumOptimal(int[] num) {
        Arrays.sort(num);
        //Collections.sort(Arrays.asList(num));
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < num.length - 2; i++) { // loop through until 2nd to last index
            if (i == 0 || (i > 0 && num[i] != num[i - 1])) { // if i = 0 or it's greater than 0 && value does not equal previous value
                // we add if i = 0  to short circuit the if statement because i-1 would no exist for i =0.
                int lo = i + 1, hi = num.length - 1, sum = 0 - num[i]; // start with number after i, make sum = negative first of num[i]
                while (lo < hi) { // goes through every number after i
                    if (num[lo] + num[hi] == sum) { // if 2 numbers equal the sum (negative version of num[i]), we add it
                        res.add(Arrays.asList(num[i], num[lo], num[hi])); // added
                        while (lo < hi && num[lo] == num[lo + 1]) lo++; //to avoid duplicates?
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

    public List<List<Integer>> threeSumSets(int[] nums) {
        Set<List<Integer>> res  = new HashSet<>(); // set of lists
        if(nums.length==0) return new ArrayList<>(res); // if empty, return empty
        Arrays.sort(nums); // sort list
        for(int i=0; i<nums.length-2;i++){ // loops through
            int j =i+1; //j = lo
            int  k = nums.length-1; // k = hi
            while(j<k){ // while lo < hi
                int sum = nums[i]+nums[j]+nums[k]; // sum
                if(sum==0)res.add(Arrays.asList(nums[i],nums[j++],nums[k--])); // if equal zero, add to res, why increment both? used once, can't repeat?
                else if ( sum >0) k--;
                else if (sum<0) j++;
            }

        }
        return new ArrayList<>(res);

    }

    public List<List<Integer>> threeSumAnother(int[] nums) {
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
}



