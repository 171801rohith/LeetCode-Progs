// 698. Partition to K Equal Sum Subsets
// Given an integer array nums and an integer k, return true if it is possible to divide this array into k non-empty subsets whose sums are all equal.

// Example 1:
// Input: nums = [4,3,2,3,5,2,1], k = 4
// Output: true
// Explanation: It is possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.

// Example 2:
// Input: nums = [1,2,3,4], k = 3
// Output: false
 

public class PartitionToKEqualSumSubsets {
    private boolean backtrack(int start, int[] nums, int krem, int rem, int target, boolean[] used) {
        if (krem == 1) return true;

        if (rem == 0) return backtrack(0, nums, krem - 1, target, target, used);

        for (int i = start; i < nums.length; i++) {
            if (used[i] || nums[i] > rem) continue;

            used[i] = true;
            if (backtrack(i + 1, nums, krem, rem - nums[i], target, used)) return true;
            used[i] = false;
        }
        return false;
    }

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int totalSum = 0;
        for (int num: nums) totalSum += num;

        if (totalSum % k != 0) return false;

        int targetPerBucket = totalSum / k;

        boolean[] used = new boolean[nums.length];
        
        return backtrack(0, nums, k, targetPerBucket, targetPerBucket, used);
    }
}
