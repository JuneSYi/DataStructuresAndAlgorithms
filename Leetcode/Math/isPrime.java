package Math;

public class isPrime {
    public static void main(String[] args) {
//        int n = 20;
//        for (int i = 2; i<=n; i++) {
//            System.out.println(i + " " + prime(i));
//        }
        int t = 40;
        boolean[] primes = new boolean[t+1];
        System.out.println("sieveOfEratosthenes changes all multiples of the number starting with 2 and up (excluding " +
                "the number j is on) and makes them true, the last part prints out only the ones" +
                "that remain as" + primes[0]);
        sieveOfEratosthenes(t, primes);
    }
    //false in array means number is prime
    static void sieveOfEratosthenes(int n, boolean[] primes) {
        for (int j = 2; j*j <=n; j++) {
            if (!primes[j]) { //all booleans start with false
                for (int k = j*2; k <= n; k+=j) {
                    primes[k] = true;
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            if (!primes[i]) {
                System.out.print(i + " ");
            }

        }
    }

    //another way to find all prime
    static boolean prime(int n) {
        if (n <= 1) {
            return false;
        }

        int c = 2;
        while (c*c <= n) {
            if (n % c == 0) {
                return false;
            }
            c++;
        }
        return true;
    }
}
