import java.util.*;

class Program {
  public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
    /*
    sequence order needs to reflect array order
    brute force, for loop sequence, if number founds, moves to next number starting at index it stopped at +1
    */
    int num = 0;
    for (int i=0; i< sequence.size(); i++) {
      for (int j=num; j<array.size(); j++) {
        if (sequence.get(i) == array.get(j)) {
          if (i == sequence.size()-1) return true;
          if (j == array.size()-1) return false;
          num = j+1;
          break;
        }
        if (j == array.size()-1) return false;
      }
    }
    return false;
  }
}
