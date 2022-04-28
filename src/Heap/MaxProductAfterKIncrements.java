package Heap;

import java.util.PriorityQueue;
import java.util.Queue;

public class MaxProductAfterKIncrements {
    public int maximumProduct(int[] nums, int k) {

        increment(nums, k);

        int prod = 1;
        for (int i = 0; i<nums.length; i++) {
            prod *= nums[i];
        }
        return prod % ((int)Math.pow(10, 9) + 7);
    }

    private void increment(int[] nums, int k) {
        if (k == 0) return;
        int temp = Integer.MAX_VALUE;
        int index = 0;
        for (int i =0; i<nums.length; i++) {
            if (temp > nums[i]) {
                temp = nums[i];
                index = i;
            }
        }
        nums[index]++;
        increment(nums, k-1);

    }

    public static void main(String[] args) {
        int[] go = {6,3,3,2};
        int su = 2;
        MaxProductAfterKIncrements test = new MaxProductAfterKIncrements();
        //System.out.println(test.maximumProduct(go, su));
        int[] two = {24,5,64,53,26,38};
        int gu = 54;
        System.out.println(test.maximumProduct(two,gu));
    }

    public int maximumProductOptimal(int[] nums, int k) {

        Queue<Integer> pq = new PriorityQueue<>();
        for (int num : nums)    pq.add(num);

        while (k-->0) {
            int top = pq.poll() + 1 ;
            pq.add(top);
        }

        long res = 1;
        while (!pq.isEmpty()) {
            res = (res*pq.poll()) % 1000000007;
        }

        return (int)(res);
    }
}
