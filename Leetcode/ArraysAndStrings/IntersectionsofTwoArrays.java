package ArraysAndStrings;

import java.util.HashMap;
import java.util.HashSet;

public class IntersectionsofTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        for (int num: nums1) {
            map.put(num, num);
        }
        for (int i = 0; i< nums2.length; i++) {
            if (map.containsKey(nums2[i])) {
                set.add(nums2[i]);
            }
        }
        int[] res = new int[set.size()];
        int i = 0;
        for (int edge: set) {
            res[i] = edge;
            i++;
        }
        return res;
    }
}
