package Amazon;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    /*
    Backtracking
    best explanation to this backtracking: https://leetcode.com/problems/generate-parentheses/discuss/10100/Easy-to-understand-Java-backtracking-solution/10980
     */
    public List<String> generateParenthesis(int n) {
        List<String> output_arr = new ArrayList<>();
        backtrack(output_arr, "", 0, 0, n); // string starts as empty, open and close at 0
        return output_arr;
    }

    public void backtrack(List<String> output_arr, String current_string, int open, int close, int max) {
        if (current_string.length() == max * 2) { // base case, if current_string reaches length of n*2
            output_arr.add(current_string); // then we add it to final arraylist
            return; // finish it out
        }
        /**
         * for these
         */
        if (open < max) backtrack(output_arr, current_string + "(", open + 1, close, max);
        if (close < open) backtrack(output_arr, current_string + ")", open, close + 1, max);
        // this only executes if there is more open than close,
    }

// ----------------------------------------------------------------------------------------------------------------
    /*
    Brute Force with recursions
    we start with creating an array of max length since we know n represents a pair of (), pos=index starts at 0 and we input our arraylist
    the generateAll function enters a recursion that splits into every possibility of '(' and ')' and at max length,
    if (pos == current.length), it checks true or false if it's a valid combination. if valid, then it adds it to the arraylist.
    this continues through every combination

    time complexity O(2^2n * n)
     */
    public List<String> bruteForce(int n) {
        List<String> combinations = new ArrayList<>();
        generateAll(new char[2 * n], 0, combinations); // new char[2*n] will create an array length of 2n, since n represents a pair of (), we create it 2x length
        return combinations;
    }

    /**
     *
     * @param current
     * @param pos - represents the index, starts with 0
     * @param result - continues the final list<string>
     */
    public void generateAll(char[] current, int pos, List<String> result) {
        if (pos == current.length) {
            if (valid(current)) { //if balance is equal to zero, we add to list, new String(char[])
                result.add(new String(current)); // adds the char array as a string
            }
        } else { // if pos != current.length then
                current[pos] = '('; //we add ( at index pos
                generateAll(current, pos+1, result); // recurse and adds (, index + 1
                current[pos] = ')';
                generateAll(current, pos+1, result);
            }
        }

    /**
     *
     * @param current - input char array as parameter and checks if '(' is more/equal/less than ')'
     * @return - true if balance = 0
     */
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
