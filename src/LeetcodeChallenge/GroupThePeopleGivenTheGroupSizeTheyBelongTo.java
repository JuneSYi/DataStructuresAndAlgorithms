package LeetcodeChallenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupThePeopleGivenTheGroupSizeTheyBelongTo {
    /**
     * There are n people that are split into some unknown number of groups.
     * Each person is labeled with a unique ID from 0 to n - 1.
     *
     * You are given an integer array groupSizes, where groupSizes[i] is the size of the group that person i is in.
     * For example, if groupSizes[1] = 3, then person 1 must be in a group of size 3.
     *
     * Return a list of groups such that each person i is in a group of size groupSizes[i].
     *
     * Each person should appear in exactly one group, and every person must be in a group.
     * If there are multiple answers, return any of them. It is guaranteed that there will be at least
     * one valid solution for the given input.
     */
    public List<List<Integer>> groupThePeople(int[] gz) {
        /*
        each person, unique id. 0 to n-1
        groupsizes[i] is size of group that person is in.
         */
        List<List<Integer>> res = new ArrayList(); // answer we'll return
        Map<Integer, List<Integer>> groups = new HashMap<>(); // create a map with a list as values
        for (int i = 0; i < gz.length; ++i) {
            List<Integer> list = groups.computeIfAbsent(gz[i], k -> new ArrayList());
            list.add(i);
            if (list.size() == gz[i]) {
                res.add(list);
                groups.put(gz[i], new ArrayList());
            }
        }
        return res;
    }
}
