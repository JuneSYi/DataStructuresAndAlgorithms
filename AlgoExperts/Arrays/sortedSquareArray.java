import java.util.*;

class Program {

  public int[] sortedSquaredArray(int[] array) {
    // Write your code here.
    /*
    negatives would affect order
    create a new array of same length
    how would I know the order of array? i'd have to go through it once,
    sort by absolute value? place in priority queue?
    what if its -2, -1, 0, 3,4
set doesn't do anything
    */
    for (int i=0; i<array.length; i++) {
      array[i] = (int) Math.pow(array[i],2);
    }
    for (int j=0; j<array.length-1; j++) {
      int idx = -1;
      int templow = array[j];
      for (int k=j+1; k<array.length;k++) {
        if (array[k] < templow) {
          idx = k;
          templow = array[k];
        }
      }
      if (idx != -1) {
        int temp = array[j];
        array[j] = array[idx];
        array[idx] = temp;
      }
    }
    return array;
  }
}
