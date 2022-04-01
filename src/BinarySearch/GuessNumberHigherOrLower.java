package BinarySearch;

public class GuessNumberHigherOrLower {
    public int guessNumber(int n) {
        // n is the max, 1 is the low
        int[] arr = new int[n];
        for (int i = 0; i <n; i++) {
            arr[i] = i;
        }
        int lo = 0, hi = n, mid = (hi+lo)/2;
        while (guess(mid) != 0) {
            if (guess(mid) == 1) {
                lo = mid;
                mid = (hi-lo)/2 + lo;
            } else if(guess(mid) == -1) {
                hi = mid;
                mid = (hi-lo)/2 + lo;
            }
        }
        return mid;
    }

    public int guessNumberOptimal(int n) {
        int lo = 1, hi = n; // start with lowest value, assign n to hi
        while(lo < hi) { // while lo is < hi
            int mid = lo + (hi - lo) / 2; // mid = difference between hi and lo,
            if(guess(mid) == 0) { // if number is right on, return mid.
                return mid;
            } else if(guess(mid) == 1) {
                lo = mid + 1; // why add 1?
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    public int guess( int n) {
        return 1;
    }
}
