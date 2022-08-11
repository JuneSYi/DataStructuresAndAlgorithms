package Math;

public class Fibonacci {
    public static void main(String[] args) {
        int ans = fibo(6);
        System.out.println(ans);
    }

    public static int fibo(int n) {
        if (n < 2) {
            return n;
        }
        return fibo(n-1) + fibo(n-2);
    }
}

/**
 * why?
 * fibo 0 = 0
 * fib 1 = 1
 * fib 2 = 1
 * fibo 3 = 2 (3 is broken down to 2 and 1, 2 is broken down to 1, each 1 is returned as n and added to the top of the chain
 * fibo 4 = 3 (4 --> 3 and 2; 3 --> 2 and 1; 2 --> 1 and 0;
 *      back to the 2 from 4; 2 --> 1 and 0;
 *      add up all the 1s, total = 3
 * fibo 5 = (5 --> 4 and 3; 4 to 3 and 2; 3 to 2 and 1; 2 to 1;
 *      from 3: 3 to 2 and 1; 2 to 1;
 *      from 2 (4): 2 to 1, total = 5
 * fibo 6 = 6 to 5/4; we know when n = 5, that equals 5; we know when n = 4, that equals to 3
 *      so 5 + 3 = 8
 */
