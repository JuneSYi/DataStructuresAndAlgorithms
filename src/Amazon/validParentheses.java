package Amazon;

import java.util.Map;
import java.util.Stack;

public class validParentheses {
    private static final Map<Character, Character> map = Map.of('(', ')', '{', '}', '[', ']');

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) { // iterate through char array
            if (map.containsKey(c)) { // if c contains one of the k1, k2, k3 values in the map
                stack.push(c); //we push onto stack
            } else { // if its not one of the k values, then it'll execute else
                if (stack.isEmpty()) { // if there's nothing in stack, we can return false nothing has been opened and c is a v value
                    return false;
                }
                char open = stack.pop(); //if stack has something, we pop it
                if (map.get(open) != c) { // we search our map to grab the v value for whats popped from stack, it should match c, if not then it's a bad value, return false;
                    return false;
                }
            }
        }
        return stack.isEmpty(); // if we got this far, then no false order has occured. can return true if stack is empty. if stack remains, then not everything that was pushed
        // has been popped.
    }
}
