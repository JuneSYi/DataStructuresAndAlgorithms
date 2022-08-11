package LeetcodeChallenge.MarchTwentySix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindtheDifferenceofTwoArrays {
    // 5268
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();
        List<Integer> one = new ArrayList<>();
        List<Integer> two = new ArrayList<>();
        for (int i =0; i< nums1.length; i++) {
            map1.put(nums1[i], 1);
        }

        for (int i =0; i< nums2.length; i++) {
            map2.put(nums2[i], 1);
        }

        for (int key : map1.keySet()) {
            if (!map2.containsKey(key)) {
                one.add(key);
            }
        }

        for (int key : map2.keySet()) {
            if (!map1.containsKey(key)) {
                two.add(key);
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(one);
        ans.add(two);
        return ans;

    }
}
