package ArraysAndStrings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class IntersectionofTwoArraysTwo {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> maptwo = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], map.getOrDefault(nums1[i], 0) +1);
        }
        for (int i = 0; i < nums2.length; i++) {
            maptwo.put(nums2[i], maptwo.getOrDefault(nums2[i], 0) +1);
        }

        List<Integer> list = new ArrayList<>();
        for (int edge: map.keySet()) {
            if (maptwo.containsKey(edge)) {
                int n = Math.min(map.get(edge), maptwo.get(edge));
                for (int i = 0; i<n; i++ ) {
                    list.add(edge);
                }
            }
        }
        int[] arr = new int[list.size()];
        for (int i = 0; i<list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }
}
