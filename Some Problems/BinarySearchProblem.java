public class BinarySearchProblem {
    public static int ceil(int[] arr, int target) {
        if (target > arr[arr.length - 1])
            return -1;
        int end = arr.length - 1;
        int start = 0;
        int mid;

        while (start <= end) {
            mid = start + (end - start) / 2;
            if (target == arr[mid]) {
                return mid;
            }
            if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }

    public static int floor(int[] arr, int target) {
        if (target < arr[0])
            return -1;
        int end = arr.length - 1;
        int start = 0;
        int mid;

        while (start <= end) {
            mid = start + (end - start) / 2;
            if (target == arr[mid]) {
                return mid;
            }
            if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return end;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 6, 8, 12, 16};
        int target = -1;
        System.out.println("CEIL INDEX = " + ceil(arr, target));
        System.out.println("FLOOR INDEX = " + floor(arr, target));
    }
}
