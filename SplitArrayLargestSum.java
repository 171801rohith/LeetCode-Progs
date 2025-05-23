// 410. Split Array Largest Sum
// Given an integer array nums and an integer k, split nums into k non-empty subarrays such that the largest sum of any subarray is minimized.
// Return the minimized largest sum of the split.
// A subarray is a contiguous part of the array.

// Example 1:
// Input: nums = [7,2,5,10,8], k = 2
// Output: 18
// Explanation: There are four ways to split nums into two subarrays.
// The best way is to split it into [7,2,5] and [10,8], where the largest sum among the two subarrays is only 18.

// Example 2:
// Input: nums = [1,2,3,4,5], k = 2
// Output: 9
// Explanation: There are four ways to split nums into two subarrays.
// The best way is to split it into [1,2,3] and [4,5], where the largest sum among the two subarrays is only 9.


public class SplitArrayLargestSum {
    public int[] maxSumAndMaxVal(int[] nums) {
        int[] res = { nums[0], 0 };
        for (int i : nums) {
            res[1] += i;
            if (i > res[0])
                res[0] = i;
        }
        return res;
    }

    public int splitArray(int[] nums, int k) {
        int[] range = maxSumAndMaxVal(nums);
        int low = range[0], high = range[1];
        while (low < high) {
            int mid = low + (high - low) / 2;
            int pieces = 1, sum = 0;

            for (int num : nums) {
                if (sum + num > mid) {
                    pieces++;
                    sum = num;
                } else {
                    sum += num;
                }
            }
            if (pieces <= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}