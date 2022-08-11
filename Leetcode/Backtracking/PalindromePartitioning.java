package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    /*
    bad attempt
     */
    public List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        backtrack(list, s, new ArrayList<>(), "", 0);
        return list;
    }

    private void backtrack(List<List<String>> list, String s, List<String> temp, String build, int index) {
        if (index == s.length()) {
            if (build.length()>1) {
                int start = 0, end = build.length()-1;
                while (start < end) {
                    if (build.charAt(start) != build.charAt(end)) return;
                    start++;
                    end--;
                }
                if (start >= end) list.add(new ArrayList<>(temp));
            }
        }
        if (build.length()>1) {
            int start = 0, end = build.length()-1;
            while (start < end) {
                if (build.charAt(start) != build.charAt(end)) return;
                start++;
                end--;
            }
        }

        for (int i=index; i < s.length(); i++) {
            temp.add(build + String.valueOf(s.charAt(i)));
            backtrack(list, s, temp, build + String.valueOf(s.charAt(i)), index+1);
            temp.remove(temp.size()-1);
        }
    }

    /*
    actual solution
     */
    public List<List<String>> partitionOptimal(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        dfs(0, result, new ArrayList<String>(), s);
        return result;
    }

    void dfs(int start, List<List<String>> result, List<String> currentList, String s) {
        if (start >= s.length()) result.add(new ArrayList<String>(currentList));
        for (int end = start; end < s.length(); end++) {
            if (isPalindrome(s, start, end)) {
                // add current substring in the currentList
                currentList.add(s.substring(start, end + 1));
                dfs(end + 1, result, currentList, s);
                // backtrack and remove the current substring from currentList
                currentList.remove(currentList.size() - 1);
            }
        }
    }

    boolean isPalindrome(String s, int low, int high) {
        while (low < high) {
            if (s.charAt(low++) != s.charAt(high--)) return false;
        }
        return true;
    }
}
