// 16. 3Sum Closest
// Given an integer array nums of length n and an integer target, find three integers at distinct indices in nums such that the sum is closest to target.
// Return the sum of the three integers.
// You may assume that each input would have exactly one solution.

// Example 1:
// Input: nums = [-1,2,1,-4], target = 1
// Output: 2
// Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

// Example 2:
// Input: nums = [0,0,0], target = 1
// Output: 0
// Explanation: The sum that is closest to the target is 0. (0 + 0 + 0 = 0).

import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = -1;
        for (int i = 0; i < nums.length - 1; i++) {
            int left = i + 1, right = nums.length - 1;

            if (i > 0  && nums[i] == nums[i - 1]) continue;
            if (closest == -1) closest = nums[i] + nums[left] + nums[right];

            while (left< right) {
                int sum = nums[i] + nums[left] + nums[right];;
                if (sum == target) return sum;
                else if (sum < target) {
                    if (Math.abs(sum - target) < Math.abs(closest - target)) closest = sum;
                    left++;
                } else {
                    if (Math.abs(sum - target) < Math.abs(closest - target)) closest = sum;
                    right--;
                }
            }
        }
        return closest;
    }
}
