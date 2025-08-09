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

    public static void main(String[] args) {
        // printNums(6);
        // for (int i = 0; i <= 5; i++) {
        //     System.out.print(fibonacci(i) + " ");
        // }

        int[] nums = {2, 4, 6, 7, 9, 10, 11};
        System.out.println(binarySearch(0, nums.length - 1, nums, 9));
    }
}
