package Amazon.ArraysAndStrings;

public class ProductofArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] arr = new int[nums.length];
        int max = 1;
        for (int i = 0; i < nums.length; i++) {
            max = max * nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            //(nums[i]-1)*ans=max;
        }
        /*
        ans * nums[i] = max
        24 * 1 = 24
        12 * 2 = 24
        8 * 3 = 24
        6 * 4 = 24
         */
        return new int[2];
    }

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
