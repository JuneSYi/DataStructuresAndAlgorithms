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
        for (int num : nums)
            pq.add(num); // for each num in the array, add it to the p.queue

        while (k-->0) { //while k> 0
            int top = pq.poll() + 1 ; //take the first number of p.queue (it'll be the lowest) and add one
            pq.add(top); // add the number back into the p.queue
        } // k will decrement by 1 every loop because of the --

        long res = 1; // start with variable
        while (!pq.isEmpty()) { //while p.queue is not empty
            res = (res*pq.poll()) % 1000000007; //multiply number by res. final result modulo 10^9+7.
        }

        return (int)(res);
    }
}
