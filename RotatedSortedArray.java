// 33. Search in Rotated Sorted Array
// There is an integer array nums sorted in ascending order (with distinct values).
// Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
// Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
// You must write an algorithm with O(log n) runtime complexity.

// Example 1:
// Input: nums = [4,5,6,7,0,1,2], target = 0
// Output: 4

// Example 2:
// Input: nums = [4,5,6,7,0,1,2], target = 3
// Output: -1

// Example 3:
// Input: nums = [1], target = 0
// Output: -1

public class RotatedSortedArray {
    public int findMaxLocation(int[] nums, int low, int high) {
        if (low == high)
            return low;
        else if (low == high - 1) {
            if (nums[low] > nums[high])
                return low;
            else
                return high;
        }
        int mid = low + (high - low) / 2;
        int left = findMaxLocation(nums, low, mid);
        int right = findMaxLocation(nums, mid + 1, high);

        return (nums[left] > nums[right]) ? left : right;
    }

    public int binarySearch(int[] nums, int target, int start, int end) {

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                start = mid + 1;
            else if (nums[mid] > target)
                end = mid - 1;
        }
        return -1;
    }

    public static int pivot(int[] arr){
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid < high && arr[mid] > arr[mid + 1]) return mid;
            if (mid > low && arr[mid] < arr[mid - 1]) return mid - 1;
            if (arr[mid] <= arr[low]) high = mid - 1;
            else low = mid + 1;
        }
        return -1;
    }

    public static int pivotIfDuplicates(int[] arr) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid < high && arr[mid] > arr[mid + 1])
                return mid;
            if (mid > low && arr[mid] < arr[mid - 1])
                return mid - 1;
            if (arr[mid] == arr[low] && arr[mid] == arr[high]) {

                if (arr[low] > arr[low + 1])
                    return low;
                low++;

                if (arr[high] < arr[high - 1])
                    return high;
                high--;
            } else if (arr[low] < arr[mid] || (arr[low] == arr[mid] && arr[mid] > arr[high]))
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }

    public int search(int[] nums, int target) {
        // int mid = findMaxLocation(nums, 0, nums.length - 1);
        // int mid = pivot(nums);
        int mid = pivotIfDuplicates(nums);
        int loc = binarySearch(nums, target, 0, mid);
        if (loc == -1) {
            return binarySearch(nums, target, mid + 1, nums.length - 1);
        }
        return loc;
    }
}
