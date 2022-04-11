package Amazon;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> output_arr = new ArrayList<>();
        backtrack(output_arr, "", 0, 0, n);
        return output_arr;
    }

    public void backtrack(List<String> output_arr, String current_string, int open, int close, int max) {
        if (current_string.length() == max * 2) { // some base case
            output_arr.add(current_string);
            return;
        }

        if (open < max) backtrack(output_arr, current_string + "(", open + 1, close, max);
        if (close < open) backtrack(output_arr, current_string + ")", open, close + 1, max);
    }

    /*
    Brute Force with recursions
     */
    public List<String> bruteForce(int n) {
        List<String> combinations = new ArrayList<>();
        generateAll(new char[2 * n], 0, combinations);
        return combinations;
    }

    public void generateAll(char[] current, int pos, List<String> result) {
        if (pos == current.length) {
            if (valid(current)) { //if balance is equal to zero, we add to list, new String(char[])
                result.add(new String(current));
            }
        } else {
                current[pos] = '(';
                generateAll(current, pos+1, result);
                current[pos] = ')';
                generateAll(current, pos+1, result);
            }
        }

    public boolean valid(char[] current) {
        int balance = 0; // initialize balance
        for (char c : current) { // for every char in current
            if (c == '(') balance++; // if we have open parentheses, we add to balance
            else balance--; // else it's minus
            if (balance < 0 ) return false; // if we have more closed then open, then false
            // we have this because a ) should never exceed (. ( should always exceed or equal
        }
        return (balance == 0); // if balance = 0, return true, else return false;
    }

}
