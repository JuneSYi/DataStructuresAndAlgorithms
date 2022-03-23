package CompanyX;

import java.util.Arrays;

/*
 leetcode 31
 */
public class NextPermutation {
    /**
     * Good morning! Here's your coding interview problem for today.
     *
     * This problem was asked by Gotham.
     *
     * Given a number represented by a list of digits, find the next greater
     * permutation of a number, in terms of lexicographic ordering. If there is not
     * greater permutation possible, return the permutation with the lowest
     * value/ordering.
     *
     * For example, the list [1,2,3] should return [1,3,2]. The list [1,3,2] should
     * return [2,1,3]. The list [3,2,1] should return [1,2,3].
     *
     * Can you perform the operation without allocating extra memory (disregarding the
     * input memory)?
     */
    public void myAttempt(int[] nums) {
        int temp = 0;
        boolean chnge = false;
        for (int i = nums.length-1; i > 0 ; i--) {
            if (nums[i] > nums[i-1]) {
                temp = nums[i];
                nums[i] = nums[i-1];
                nums[i-1] = temp;
                chnge = true;
            }
        }
        if (chnge) {
            Arrays.stream(nums).sorted();
        }
    }

    public void realSolution(int[] num) {
        int n=num.length;
        if(n<2) return;
        int index=n-1;
        while(index>0){ // starting at the end, index decrements until the left before index is smaller then index
            if(num[index-1]<num[index])
                break;
            index--;
        }
        if(index==0){ // this is in the invent where no numbers can be permutated. all numbers were in descending order so we sort it to ascending
            reverseSort(num,0,n-1);
            return;
        }
        else{ // so we find a number where num[index-1] < num[index]
            int val=num[index-1]; // val is the number we want to swap
            int j=n-1; // length of entire num -1
            while(j>=index){ //while the length is greater than where index stopped, we'll slowly decrement j by 1
                if(num[j]>val) //if the value of num[j] is greater than num[index-1], we stop j there.
                    break;
                j--;
            }
            swap(num,j,index-1); // swap the 2 numbers
            reverseSort(num,index,n-1); //why reverse sort?
            return;
        }
    }

    public void swap(int[] num, int i, int j){
        int temp=num[i];
        num[i]=num[j];
        num[j]=temp;
    }

    public void reverseSort(int[] num, int start, int end){
        if(start>end)
            return;
        for(int i=start;i<=(end+start)/2;i++)
            swap(num,i,start+end-i);
    }
}
