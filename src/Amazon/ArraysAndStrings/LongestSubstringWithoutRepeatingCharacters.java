package Amazon.ArraysAndStrings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    /**
     * sliding window
     * By using HashSet as a sliding window, checking if a character in the current can be done in O(1)O(1).
     */
    public int lengthOfLongestSubstring(String s) {
        int[] chars = new int[128]; // 128 for each possible char

        int left = 0; //left pointer for window
        int right = 0; //right pointer for window

        int res = 0; //use variable to check final result
        while (right < s.length()) {
            char r = s.charAt(right); //for character at right boundary.
            chars[r]++; // up the value at index r (char)

            while (chars[r] > 1) { // if the chars[r] is > 1, then that means it's repeated
                char l = s.charAt(left);  //so we start with the left boundary using left
                chars[l]--; //we decrease each index we visit
                left++; // window goes up
            } // after contracting the window

            res = Math.max(res, right - left + 1); // why right-left + 1, make sure there is no duplicate character
            // so we can update our result using the current window's length
            // i think because if subtract index 3 by index 2. that's technically 2 lengths, but it'll only show 1. so we add 1

            right++;
        }
        return res;
    }

    public int lengthOfLongestSubstringMap(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    public int lengthOfLongestSubstringHashSet(String s) {
        if (s == null || s.length() == 0) return 0;
        int i = 0, j = 0, ans = 0;
        Set<Character> set = new HashSet<>();
        while (i< s.length()) {
            char c = s.charAt(i);

            while (set.contains(c)) { // checking if char c is already in our set
                set.remove(s.charAt(j)); // remove at current variable, move the pointer up once
                j++;
            } //when we come out of this while loop, we know that char c is not in our set
            set.add(c);
            ans = Math.max(ans, i-j+1);
            i++;
        }
        return ans;
    }

    /**
     * Brute Force Solution
     */
    public int BruteForce(String s) {
        int n = s.length();

        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (check(s, i, j)) {
                    res = Math.max(res, j - i + 1);
                }
            }
        }

        return res;
    }

    private boolean check(String s, int start, int end) {
        int[] chars = new int[128];

        for (int i = start; i <= end; i++) {
            char c = s.charAt(i); // returns a char value at index i for string s and assigns it to variable c
            chars[c]++; // at index c (char is converted to ASCII value). we're going to ++ the value from 0 to 1. if it's already 1, it'll go to 2
            if (chars[c] > 1) { //if chars[c] is 2, that means the variable has already been visited.
                return false;
            }
        }

        return true;
    }
}
