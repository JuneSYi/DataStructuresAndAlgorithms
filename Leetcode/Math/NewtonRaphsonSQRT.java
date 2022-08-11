package Math;

public class NewtonRaphsonSQRT {
    // sqrt(root) = (x+n/x)/2
    //where x = sqrt that you have assumed
    //root = actual sqrt
    public static void main(String[] args) {
        System.out.println(sqrt(40));
    }
    static double sqrt(double n) {
        double x = n;
        double root;
        while (true) {
            root = 0.5 * (x + (n/x));

            if (Math.abs(root - x) < 1) {
                break;
            }

            x = root;
        }

        return root;
    }
}
