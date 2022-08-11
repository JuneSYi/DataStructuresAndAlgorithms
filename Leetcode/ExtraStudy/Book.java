package ExtraStudy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Book {
    /**
     * '0': an ordinary page
     * '1': a bookmarked page
     *
     * Find the number of ways to select 3 pages in ascending index order such that no two adjacent selected pages are of the same type.
     *
     * Example
     *
     * book = '01001'
     *
     * The following sequences of pages match the criterion:
     *
     * [1, 2 ,3], that is, 01001 → 010.
     * [1, 2 ,4], that is, 01001 → 010.
     * [2, 3 ,5], that is, 01001 → 101.
     * [2, 4 ,5], that is, 01001 → 101.
     *
     * The answer is 4.
     */

    public static long numberOfWays(String book) {
        char[] books = book.toCharArray();
        Stack<Character> stack = new Stack<>();
        long ways = 0;
        for (int i = 0; i < book.length() - 2; i++) {
            stack.push(books[i]);
            for (int j = i+1; j < book.length()-1; j++) {
                if (stack.peek() == books[j]) continue;
                stack.push(books[j]);
                for (int k = j+1; k < book.length(); k++) {
                    if (stack.peek() == books[k]) continue;
                    ways++;
                }
                stack.pop();
            }
            stack.pop();
        }
        return ways;
    }

    public long someFunction(String book) {
        int n = book.length();
        long zeroTotal = 0, oneTotal = 0;
        for (int i = 0; i < n; i++) { // loop through string
            if (book.charAt(i) == '0') zeroTotal++; // count all the zeros
            else oneTotal++; //rest are all ones
        }
        long zeroSoFar = 0, oneSoFar = 0, ans = 0;
        for (int i = 0; i < n; i++) { // loop through again
            if (book.charAt(i) == '0') { // if it equals zero
                ans += oneSoFar * (oneTotal - oneSoFar); // add oneSoFar(oneTotal-oneSoFar), doesn't make any sense
                zeroSoFar++;
            } else {
                ans += zeroSoFar * (zeroTotal - zeroSoFar);
                oneSoFar++;
            }
            /*
            don't like this solution,

            all based on the concept where If we concentrate on 0, _ _ _ _ 0 _ _ _ _ ,
            suppose on the left there are x 1s and y 1s on the right hand side. The total number of ways to satisfy
            this pattern is x * y. Likewise for pattern 101. Thus all we need to do is to iterate through the string,
            and at each sequence count the number of 0s on LHS and the number of 1s on RHS do the product.
             */
        }
        return ans;
    }
}
