// Find the position a target element in an Infinite array
// Don't use arr.length 

public class PositionOfElementInAnInfinteArray {
    public static int search(int[] arr, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target == arr[mid]) {
                return mid;
            }
            if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    public static int answer(int[] arr, int target) {
        int start = 0, end = 1;
        while (target > arr[end]) {
            int temp = end + 1;
            // end = previous end + boxSize * 2
            end = end + (end - start + 1) * 2;
            start = temp;
        }
        return search(arr, target, start, end);
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 6, 7, 8, 10, 11, 12, 15, 20, 23, 30, 33};
        System.out.println("Target Found At: " + answer(arr, 15));
    }
} 