// 75. Sort Colors
// Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
// We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
// You must solve this problem without using the library's sort function.

// Example 1:
// Input: nums = [2,0,2,1,1,0]
// Output: [0,0,1,1,2,2]

// Example 2:
// Input: nums = [2,0,1]
// Output: [0,1,2]

public class SortColors {
    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j])
                    minIndex = j;
            }

            if (minIndex != i)
                swap(arr, i, minIndex);
        }
    }

    public static void merge(int[] arr, int low, int mid, int high) {
        int i = low, k = low, j = mid + 1;
        int[] buf = new int[arr.length];

        while (i <= mid && j <= high) {
            if (arr[i] < arr[j])
                buf[k++] = arr[i++];
            else
                buf[k++] = arr[j++];
        }
        while (i <= mid)
            buf[k++] = arr[i++];
        while (j <= high)
            buf[k++] = arr[j++];

        for (int l = low; l <= high; l++) {
            arr[l] = buf[l];
        }
    }

    public static void mergeSort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    public void sortColors(int[] nums) {
        // selectionSort(nums);
        mergeSort(nums, 0, nums.length - 1);
    }
}
