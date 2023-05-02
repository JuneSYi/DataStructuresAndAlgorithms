import java.util.*;

class Program {
  public static int[] twoNumberSum(int[] array, int targetSum) {
    // brute force, n^2, 2 for loops, see if each iteration adds to targetSum, if yes, return [i,j]
    // put every number in hashmap
    // 2nd loop, if targetSum - array[j] = something in hashmap, then goal
    // how do we account for skipping same number? we have index as value, if j = value then continue
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i =0; i<array.length; i++) {
      map.put(array[i], i);
    }
    for (int j =0; j<array.length; j++) {
      if (map.get(targetSum-array[j]) != null && map.get(targetSum-array[j]) != j) {
        return new int[]{targetSum-array[j], array[j]};
      }
    }
    return new int[0];
  }
}
