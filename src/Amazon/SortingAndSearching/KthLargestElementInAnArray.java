package Amazon.SortingAndSearching;

import java.util.PriorityQueue;

public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);
        }
        int index = nums.length-k;
        for (int i = 0; i < index; i++) {
            queue.poll();
        }
        return queue.peek();
    }
}
