import java.util.ArrayList;
import java.util.Collections;

public class MathsInDSA {
    public static boolean isPrime(int n) {
        if (n <= 1)
            return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public static void primesInRange(int s, int e) {
        ArrayList<Integer> primes = new ArrayList<>();
        for (int i = s; i <= e; i++) {
            if (isPrime(i))
                primes.add(i);
        }
        System.out.println(primes);
    }

    public static void seive(int n) {
        boolean[] primes = new boolean[n + 1]; // default fasle
        for (int i = 2; i * i <= n; i++) {
            if (!primes[i]) {
                for (int j = i * 2; j <= n; j += i) {
                    primes[j] = true;
                }
            }
        }

        for (int i = 2; i < primes.length; i++) {
            if (!primes[i])
                System.out.print(i + ", ");
        }
        System.out.println();
    }

    public static double sqrt(int n, int p) {
        int low = 0, high = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid * mid > n)
                high = mid - 1;
            else if (mid * mid < n)
                low = mid + 1;
            else
                return mid;
        }

        double root = high;
        double incr = 0.1;
        for (int i = 0; i < p; i++) {
            while (root * root <= n) {
                root += incr;
            }

            root -= incr;
            incr /= 10;
        }

        return root;
    }

    public static void factorsOfN(int n) {
        ArrayList<Integer> factors = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                factors.add(i);
                if (!(n / i == i))
                    factors.add(n / i);
            }

        }
        Collections.sort(factors);
        System.out.println(factors);
    }

    public static int gcd(int a, int b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    public static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    public static void main(String[] args) {
        System.out.println(isPrime(7));
        primesInRange(0, 40);
        seive(40);
        System.out.println(sqrt(40, 2));
        factorsOfN(36);
        System.out.println(gcd(3, 9));
        System.out.println(lcm(3, 9));
    }
}
