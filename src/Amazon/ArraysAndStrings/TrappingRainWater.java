package Amazon.ArraysAndStrings;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it can trap after raining.
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        /*
        water can be trapped if height[x+1] < height[x] && height[length-1] >= height[x]

        since it's constantly changing it doesn't work
        two conditions need to exist
        1- index after x needs to be at least -1
        2- after -1 happens, another index needs to the same number.
        2.1 - then you take the same number and use Math.min of the 2
        2.2 - the area will be the height of (math.min * yindex-xindex) -the height of the index between y and x
         */
        int i = 1;
        int total =0;
        while (i<height.length) {
            if (height[i-1] > height[i]) {
                for (int j = i; j < height.length; j++) {
                    if (height[j] >= height[i-1] || j == height.length-1 || height[j+1] < height[j]) {
                        int minheight = Math.min(height[i-1], height[j]);
                        int minus = 0;
                        for (int k = i; k <j ; k++) {
                            minus += height[k];
                        }
                        int area = (minheight*(j-i))-minus;
                        total += area;
                        i = j-1;
                        break;
                    }
                }
            }

            i++;
        }
        return total;
    }

    public static void main(String[] args) {
        TrappingRainWater func = new TrappingRainWater();
        int[] sol = {0,1,0,2,1,0,1,3,2,1,2,1};
        int[] can = {4,2,3};
        int[] fas = {0,1,0,2,1,0,1};
        System.out.println(func.trap(fas));
    }

    /**
     * Solution
     */
    public int trapSol(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int left = 0; int right = height.length - 1; // Pointers to both ends of the array.
        int maxLeft = 0; int maxRight = 0;

        int totalWater = 0;
        while (left < right) {
            // Water could, potentially, fill everything from left to right, if there is nothing in between.
            if (height[left] < height[right]) {
                // If the current elevation is greater than the previous maximum, water cannot occupy that point at all.
                // However, we do know that everything from maxLeft to the current index, has been optimally filled, as we've
                // been adding water to the brim of the last maxLeft.
                if (height[left] >= maxLeft) {
                    // So, we say we've found a new maximum, and look to see how much water we can fill from this point on.
                    maxLeft = height[left];
                    // If we've yet to find a maximum, we know that we can fill the current point with water up to the previous
                    // maximum, as any more will overflow it. We also subtract the current height, as that is the elevation the
                    // ground will be at.
                } else {
                    totalWater += maxLeft - height[left];
                }
                // Increment left, we'll now look at the next point.
                left++;
                // If the height at the left is NOT greater than height at the right, we cannot fill from left to right without over-
                // flowing; however, we do know that we could potentially fill from right to left, if there is nothing in between.
            } else {
                // Similarly to above, we see that we've found a height greater than the max, and cannot fill it whatsoever, but
                // everything before is optimally filled
                if (height[right] >= maxRight) {
                    // We can say we've found a new maximum and move on.
                    maxRight = height[right];
                    // If we haven't found a greater elevation, we can fill the current elevation with maxRight - height[right]
                    // water.
                } else {
                    totalWater += maxRight - height[right];
                }
                // Decrement left, we'll look at the next point.
                right--;
            }
        }
        // Return the sum we've been adding to.
        return totalWater;
    }
}
