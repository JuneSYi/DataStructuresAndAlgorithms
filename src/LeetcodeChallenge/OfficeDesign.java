package LeetcodeChallenge;

public class OfficeDesign {
    /**
     * A company is repainting its office and would like to choose colors that work well together.
     *
     * They are presented with several various-priced color options presented in a specific order so
     * that each color complements the surrounding colors.
     *
     * The company has a limited budget and would like to select the greatest number of consecutive colors
     * that fit within this budget.
     *
     * Given the prices of the colors and the company's budget, what is the maximum number of colors that can be
     * purchased for this repainting project?
     */
    public int optimalColors(int[] prices, int budget) {
        int max = 0;
        int left =0;
        int right = 0;
        while (right < prices.length) {
            //how do you add up the numbers between left and right?
            int temp = left;
            int total = 0;
            while (temp < right) {
                total += prices[temp];
                if (temp+1 == right) {
                    total+=prices[right];
                    break;
                }
                temp++;
            }
            if (total <= budget) {
                max = Math.max(max, right-left+1);
            }

            if (total >budget) {
                left++;

            } else {
                right++;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        OfficeDesign exe = new OfficeDesign();
        int[] test = {2,3,5,1,1,2,1};
        System.out.println(exe.optimalColors(test, 7));
    }
}
