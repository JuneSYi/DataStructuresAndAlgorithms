package Amazon.ArraysAndStrings;

public class TwoSumTwo {
    public int[] twoSum(int[] numbers, int target) {
        int lo = 0, hi = numbers.length-1;
        while (hi>lo) {
            if (numbers[hi]+numbers[lo] == target) break;
            if (numbers[hi]+numbers[lo] > target) {
                hi--;
            } else {
                lo++;
            }
        }
        int[] ans = {lo+1, hi+1};
        return ans;
    }
}
