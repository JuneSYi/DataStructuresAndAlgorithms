package LeetcodeChallenge.MarchTwentySix;

public class MinimumDeletionsToMakeArrayBeautiful {
    //5236
    public int minDeletion(int[] nums) {
        // nums length is even
        // for all i% 2 == 0; all even numbers don't equal i+1

        /*
        how do we know what to delete?
        what to check first and what to check last

        we can iterate through FIRST to see if i = i+1 and delete those. they have to all go.
        since we want minimum deletion, we go left to right
        we have a counter for each mistake we see

         */
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i%2 == 0) {
                if (i == nums.length-1) break;
                if (nums[i] == nums[i+1]) count++;
            }

        }
        if (count % 2 == 1 && nums.length%2 ==1) return count;

        return count++;
    }

    public int Optimal(int[] nums) {
        boolean even = true;
        int size = 0, c = 0;
        for (int i = 0; i < nums.length; i++) {
            //current index is even and i+1 is same
            while (i + 1 < nums.length && even && nums[i] == nums[i + 1]) { // use i+<nums.length to keep within index bounds since we use nums[i+1]
                i++;
                c++; // if all those are true, we increment i by 1 and the count by 1, why?
            }
            //change index parity
            even = !even; // why?
            size++; // why?
        }
        return c + size % 2; // as even number of elements needed
    }
}
