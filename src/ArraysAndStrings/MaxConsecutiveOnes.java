package ArraysAndStrings;

import java.util.Stack;

public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int count = 0;
        for (int i =0; i<nums.length; i++) {
            if (nums[i] == 0) {
                while (!stack.isEmpty()) {
                    stack.pop();
                }
            }
            if (nums[i] ==1 ) {
                stack.push(i);
            }
            if (stack.size() > count) count = stack.size();
        }
        return count;

    }
}
