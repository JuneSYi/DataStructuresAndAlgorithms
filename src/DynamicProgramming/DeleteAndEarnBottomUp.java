package DynamicProgramming;

import java.util.HashMap;

public class DeleteAndEarnBottomUp {
    public int deleteAndEarn(int[] nums) {
        HashMap<Integer, Integer> points = new HashMap<>();
        int maxNumber = 0;

        // Precompute how many points we gain from taking an element
        for (int num : nums) {
            points.put(num, points.getOrDefault(num, 0) + num); // puts all the points in one number
            maxNumber = Math.max(maxNumber, num); // finds the highest number after loop is complete
        }

        // Declare our array along with base cases
        int[] maxPoints = new int[maxNumber + 1]; // creates an array with highest number + 1
        maxPoints[1] = points.getOrDefault(1, 0); // we create base case for index 1, index 0 = 0 so we can skip (auto filled to zero)

        for (int num = 2; num < maxPoints.length; num++) { // base case 0 and 1 established, start at 2
            // Apply recurrence relation
            int gain = points.getOrDefault(num, 0);
            maxPoints[num] = Math.max(maxPoints[num - 1], maxPoints[num - 2] + gain); // recursive relation applied
        }

        return maxPoints[maxNumber]; // return highest value
    }
}
