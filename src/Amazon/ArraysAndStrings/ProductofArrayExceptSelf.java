package Amazon.ArraysAndStrings;

public class ProductofArrayExceptSelf {
    /**
     * O(1) - space
     */
    public int[] productExceptSelfMoreOptimal(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        // Calculate lefts and store in res.
        int left = 1;
        for (int i = 0; i < n; i++) {
            if (i > 0)
                left = left * nums[i - 1];
            res[i] = left;
        }
        // Calculate rights and the product from the end of the array.
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            if (i < n - 1)
                right = right * nums[i + 1];
            res[i] *= right;
        }
        return res;
    }

    /**
     * O(n) - space
     */
    public int[] productExceptSelfOptimal(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] res = new int[n];
        left[0] = 1; right[n-1] = 1;
        for (int i = 1; i < n; i++) {
            left[i] = left[i-1] * nums[i-1];
        }
        for (int i = n-2; i >=0 ; i--) {
            right[i] = right[i+1] * nums[i+1];
        }
        for (int i = 0; i < n; i++) {
            res[i] = left[i] * right[i];
        }
        return res;
    }
}
