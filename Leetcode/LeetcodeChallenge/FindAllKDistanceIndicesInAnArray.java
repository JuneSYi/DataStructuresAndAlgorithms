package LeetcodeChallenge;

import java.util.*;
// 6031.
// 5203 count artifacts that can be extracted
// 5227 maximize the topmost element after k moves
// 6032 minimum weighted subgraph with the required paths
public class FindAllKDistanceIndicesInAnArray {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        HashSet<Integer> ans = new HashSet<>();
        for (int i = 0; i<nums.length; i++) {
            if (nums[i] == key) list.add(i);
        }

        for (int edge : list) {
            for (int i = 0; i<nums.length; i++) {
                if (Math.abs(i - edge) <= k) ans.add(i);
            }
        }
        List<Integer> fin = new ArrayList<>();
        for (int word : ans) fin.add(word);
        List<Integer> real = new ArrayList<>();
        for (int i = 0; i<fin.size(); i++) {
            int lowest = Integer.MAX_VALUE;
            for (int j = 0; j < fin.size(); j++) {
                if (fin.get(j) < lowest) lowest = fin.get(j);
                fin.remove(j);
            }
            real.add(lowest);
        }
        return real;
    }

    /*
    Answer
     */
    public List<Integer> findKDistantIndicesANS(int[] nums, int key, int k) {

        //flagging those who should be in result
        boolean flag[] = new boolean[1001];

        //O(N * K)
        for (int i = 0; i < nums.length; i++) {

            //if we found the key
            if (nums[i] == key) {

                //flag range  of (i - k, i + k)
                int j = i - k > 0 ? i - k : 0;
                for (; j <= i + k  && j < nums.length; j++) {
                    flag[j] =true;
                }
            }
        }

        //pack up
        //add flagged nums in list
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 1001; i++) {
            if (flag[i]) {
                list.add(i);

            }
        }
        return list;
    }

    public List<Integer> findKDistantIndicesHSet(int[] nums, int key, int k) {
        List<Integer> list = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key) {
                int from = 0, till = 0;//just initialising you could do anything with it;
                from = Math.max((i - k), 0);
                till = Math.min((i + k), nums.length - 1);
                for (int j = from; j <= till; j++) set.add(j);
            }
        }
        for (int i : set) list.add(i);
        Collections.sort(list);

        return list;
    }
}
