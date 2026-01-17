public class Recursion {

    public static void printNums(int n) {
        if (n == 1) {
            System.out.println(1);
            return;
        }
        printNums(n - 1);
        System.out.println(n);
    }

    public static int fibonacci(int n) {
        if (n < 2)
            return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static int binarySearch(int low, int high, int[] nums, int target) {
        if (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                return binarySearch(mid + 1, high, nums, target);
            else
                return binarySearch(low, mid - 1, nums, target);
        }
        return -1;
    }

    public static double factorial(double n) {
        if (n == 1)
            return 1;
        return n * factorial(n - 1);
    }

    public static int sumOfDigits(int n) {
        if (n <= 0)
            return 0;
        return (n % 10) + sumOfDigits(n / 10);
    }

    public static int profuctOfDigits(int n) {
        if (n <= 0)
            return 1;
        return (n % 10) * profuctOfDigits(n / 10);
    }

    static int sum = 0;

    public static void reverseNumMeth1(int n) {
        if (n <= 0) {
            return;
        }
        sum = (sum * 10) + (n % 10);
        reverseNumMeth1(n / 10);
    }

    public static int reverseNum(int n) {
        int digits = (int) (Math.log10(n)) + 1; // No of Digits
        return helper(n, digits);
    }

    private static int helper(int n, int digits) {
        if (n % 10 == n)
            return n;
        return (int) ((n % 10) * Math.pow(10, digits - 1)) + helper(n / 10, digits - 1);
    }

    public static boolean pallindromeMeth1(int n) {
        return n == reverseNum(n);
    }

    public static int noOfZeros(int n, int count) {
        if (n == 0)
            return count;
        if (n % 10 == 0)
        return noOfZeros(n / 10, count + 1);
            
        return noOfZeros(n / 10, count);
    }

    public static void main(String[] args) {
        // printNums(6);
        // for (int i = 0; i <= 5; i++) {
        // System.out.print(fibonacci(i) + " ");
        // }

        // int[] nums = {2, 4, 6, 7, 9, 10, 11};
        // System.out.println(binarySearch(0, nums.length - 1, nums, 9));

        System.out.println(factorial(3));
        System.out.println(sumOfDigits(2344));
        System.out.println(profuctOfDigits(2304));
        reverseNumMeth1(21392);
        System.out.println(sum);
        System.out.println(reverseNum(1234));
        System.out.println(pallindromeMeth1(1234));
        System.out.println(noOfZeros(120304, 0));

    }
}
