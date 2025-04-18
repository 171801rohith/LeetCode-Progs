// 34. Find First and Last Position of Element in Sorted Array
// Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
// If target is not found in the array, return [-1, -1].
// You must write an algorithm with O(log n) runtime complexity. 

// Example 1:
// Input: nums = [5,7,7,8,8,10], target = 8
// Output: [3,4]

// Example 2:
// Input: nums = [5,7,7,8,8,10], target = 6
// Output: [-1,-1]

// Example 3:
// Input: nums = [], target = 0
// Output: [-1,-1]

public class FirstAndLastPosition {
    public int[] searchRange(int[] nums, int target) {
        int[] result = { -1, -1 };
        result[0] = findFirst(nums, target);
        result[1] = findLast(nums, target);
        return result;
    }

    public int findLast(int[] nums, int target) {
        int index = -1;
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] <= target)
                low = mid + 1;
            else
                high = mid - 1;
            if (nums[mid] == target)
                index = mid;
        }
        return index;
    }

    public int findFirst(int[] nums, int target) {
        int index = -1;
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] >= target)
                high = mid - 1;
            else
                low = mid + 1;
            if (nums[mid] == target)
                index = mid;
        }
        return index;
    }
}
