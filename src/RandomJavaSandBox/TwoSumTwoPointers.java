package RandomJavaSandBox;

import java.util.Arrays;

public class TwoSumTwoPointers {
    public int[] twoSum(int[] nums, int target) {
        int[] temp = nums;
        Arrays.sort(temp);
        int start = 0, end = temp.length-1;
        while (start < end) {
            if (temp[start] + temp[end] == target) break;
            if (temp[start] + temp[end] > target) end--;
            if (temp[start] + temp[end] < target) start++;
        }
        int[] res = new int[2];
        res[0] = Arrays.asList(nums).indexOf(temp[start]);
        res[1] = Arrays.asList(nums).indexOf(temp[end]);
        return res;
    }

    public static void main(String[] args) {
        int[] test = {2, 7, 11, 15};
        TwoSumTwoPointers run = new TwoSumTwoPointers();
        System.out.println(Arrays.toString(run.twoSum(test, 9)));
    }
}
