package Amazon.ArraysAndStrings;

import java.util.HashMap;
import java.util.HashSet;

public class FirstUniqueCharacterInAString {
    /**
     * Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
     */

    public int withHash(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }
        for (int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))) continue;
            return i;
        }
        return -1;
    }
    public int firstUniqCharOptimal(String s) {
        int[] index = new int[128];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            index[c]++;

        }
        for (int i = 0; i < s.length() ; i++) {
            char c = s.charAt(i);
            if (index[c] == 1) return i;

        }
        return -1;
    }

    public int firstUniqChar(String s) { // brute force
        for (int i = 0; i<s.length(); i++) {
            boolean match = false;
            for (int j = 0; j < s.length(); j++) {
                if (i==j) continue;
                if (s.charAt(i) == s.charAt(j)) match = true;
            }
            if (!match) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        FirstUniqueCharacterInAString exe = new FirstUniqueCharacterInAString();
        //System.out.println(exe.firstUniqChar("loveleetcode"));
        HashMap<Integer, Integer> test = new HashMap<>();
        test.put(1, 2);
        test.put(1,3);
        test.put(2,4);
        test.put(1,2);
        test.put(1,3);

        System.out.println(test.get(1));
    }
}
