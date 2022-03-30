package Amazon.DynamicProgramming;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        // base case
        // check each index, check if to see if -1 == +1, if true, we go further. until false. we record length
        // keep doing checks until we end. longest length
        String[] arr = s.split("");
        String[] sum = new String[s.length()+1];

        sum[0] = arr[0];
        if (arr[0] == arr[2]) {
            sum[1] = s.substring(0,3);
        }
        return s;
    }

    private int lo, maxLen;

    public String longestPalindromeOptimal(String s) {
        int len = s.length();
        if (len < 2)
            return s;

        for (int i = 0; i < len-1; i++) {
            extendPalindrome(s, i, i);  //assume odd length, try to extend Palindrome as possible
            extendPalindrome(s, i, i+1); //assume even length.
        }
        return s.substring(lo, lo + maxLen);
    }

    private void extendPalindrome(String s, int j, int k) {
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) { // while both ends equal each other, we increment/decrement
            j--;
            k++;
        }
        if (maxLen < k - j - 1) { //if the maxlen is less then the newest length of palindrome, then maxlen is changed.
            lo = j + 1;
            maxLen = k - j - 1;
        }
    }
}
