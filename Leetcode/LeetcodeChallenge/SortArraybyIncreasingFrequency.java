package LeetcodeChallenge;

import java.util.*;

public class SortArraybyIncreasingFrequency {
    /*
    Given an array of integers nums, sort the array in increasing order based on the frequency of the values.
    If multiple values have the same frequency, sort them in decreasing order.

    Return the sorted array.
     */
    public static void main(String[] args) {
        SortArraybyIncreasingFrequency exe = new SortArraybyIncreasingFrequency();
        int[] test = {2,3,1,3,2};
        System.out.println(Arrays.toString(exe.frequencySort(test)));
    }
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i<nums.length; i++) {
            map.put(nums[i],map.getOrDefault(nums[i], 0) +1);
        }
        List<Integer> arr = new ArrayList<>();


        while (arr.size()!=nums.length) {
            List<Integer> decOrder = new ArrayList<>();
            int mstFreq = Integer.MAX_VALUE;
            int remKey = 0;
            boolean tracker = false;
            for (int node : map.keySet()) {
                if (map.get(node) < mstFreq) {
                    mstFreq = map.get(node);
                    remKey = node;
                }
            }
            for (int key : map.keySet()) {
                if (mstFreq == map.get(key) && key != remKey) {
                    decOrder.add(key);
                    tracker = true;
                }
            }
            if (tracker) {
                decOrder.add(remKey);
                decOrder = reorder(decOrder); // ordered in decreasing order
                for (int i = 0; i < decOrder.size(); i++) {
                    int temp = 0;
                    while (temp!=mstFreq){
                        arr.add(decOrder.get(i)); // how do we add this by mstFreq
                        temp++;
                    }
                    map.remove(decOrder.get(i));
                }
            } else {
                int temp =0;
                while (temp!=mstFreq) {
                    arr.add(remKey);
                    temp++;
                }
                map.remove(remKey);
            }
        }
        int[] ans = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            ans[i] = arr.get(i);
        }
        return ans;
    }

    private List<Integer> reorder(List<Integer> input) {
        int start = 0;
        int end = input.size()-1;
        while (start < end) {
            if (input.get(start) < input.get(end)) {
                int temp = input.get(start);

                input.set(start, input.get(end));
                input.set(end, temp);

            }
            start++;
        }
        return input;
    }
}
