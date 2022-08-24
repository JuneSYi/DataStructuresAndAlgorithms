package Algoexpert.Easy;

import java.util.*;

class SortedSquaredArray {
    public static void main(String[] args) {
        int[] array = {-4,1,2,3,5};
        List<Integer> arr = new ArrayList<Integer>();
        for (int i = 0; i <array.length; i++) {
            arr.add(array[i]*array[i]);
        }
        Collections.sort(arr);
        System.out.println(arr);
        Integer[] ans = new Integer[arr.size()];
        ans = arr.toArray(ans);
        System.out.println(Arrays.toString(ans));
    }
}