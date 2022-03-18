package ArraysAndStrings;

import java.util.*;

/**
 * You are given a string s, and an array of pairs of indices in the string pairs where pairs[i] = [a, b] indicates 2 indices(0-indexed) of the string.
 *
 * You can swap the characters at any pair of indices in the given pairs any number of times.
 *
 * Return the lexicographically smallest string that s can be changed to after using the swaps.
 */
public class SmallestStringWithSwaps {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        Map<Integer, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(i,s.charAt(i));
        }
        // Input: s = "dcab
        // pairs = [[0,3],[1,2]]
        Map<Integer, Integer> tracker = new HashMap<>();
        // maybe we can track what's been swapped, if one of the pair.get() values equals the numbers we're traccking in an array (map.contains), then we revisit that again
        for (int i =0 ; i< pairs.size(); i++) {
            tracker.put(pairs.get(i).get(0), tracker.getOrDefault(pairs.get(i).get(0), 0)+1); // keeps track of every number and adds a count every tie it's swapped
            tracker.put(pairs.get(i).get(1), tracker.getOrDefault(pairs.get(i).get(0), 0)+1); // sames

            if (map.get(pairs.get(i).get(0)) > map.get(pairs.get(i).get(1))) {
                char var = map.get(pairs.get(i).get(1));
                map.put(pairs.get(i).get(1),map.get(pairs.get(i).get(0)));
                map.put(pairs.get(i).get(0), var);
            }
        }
        String fake = "";
        return fake;
    }

    int[] parent;
    public String usingUnionFind(String s, List<List<Integer>> pairs) {
        parent = new int[s.length()];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i; // building out the  indexes
        }

        for (List<Integer> pair : pairs) {
            union(pair.get(0), pair.get(1)); // doing union on the pairs that go together.
        }

        Map<Integer, PriorityQueue<Character>> map = new HashMap<>();
        char[] sChar = s.toCharArray(); // turning the string into an array of chars
        for (int i = 0; i < sChar.length; i++) { // for each index on char array
            int root = find(i);
            map.putIfAbsent(root, new PriorityQueue<>());
            map.get(root).offer(sChar[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sChar.length; i++) {
            sb.append(map.get(find(i)).poll());
        }
        return sb.toString();
    }

    public int find(int index) {
        while (parent[index] != index) {
            parent[index] = parent[parent[index]];
            index = parent[index];
        }
        return index;
    }

    public void union(int a, int b) {
        int aParent = find(a);
        int bParent = find(b);
        if (aParent < bParent) {
            parent[bParent] = aParent;
        } else {
            parent[aParent] = bParent;
        }
    }
}
