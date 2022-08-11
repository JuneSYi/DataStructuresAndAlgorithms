package Amazon.ArraysAndStrings;

import java.util.ArrayList;
import java.util.List;

public class ContainerWithMostWater {
    /**
     * given an integer array height of length n. there are n vertical lines drawn such that the two endpoints of the i^th line are (i, 0) and i, height[i]).
     *
     * so we want height[i] to be a big number and we want i to be the farthest apart
     */
    public int maxArea(int[] height) {
        /*
        we want to multiple the difference between i and i and the
        brute force
        we put into an int array the value of i - j * Math.max(height[i], height[j]);
         */
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < height.length; i++) {
            for (int j = i+1; j < height.length; j++) {
                int idiff = j-i;
                int tall = Math.min(height[i], height[j]);
                int waterVolume = tall*idiff;
                ans.add(waterVolume);
            }
        }
        int can = 0;
        for (int i = 0; i < ans.size(); i++) {
            if (ans.get(i) > can) can = ans.get(i);
        }
        return can;
    }

    public int twoPointerApproach(int[] height) {
        int maxarea = 0 ;
        int l = 0;
        int r = height.length - 1;
        while (l < r) {
            maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r])
                l++;
            else
                r--;
        }
        return maxarea;
    }
}
