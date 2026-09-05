// 377. Combination Sum IV
// Given an array of distinct integers nums and a target integer target, return the number of possible combinations that add up to target.
// The test cases are generated so that the answer can fit in a 32-bit integer.

// Example 1:
// Input: nums = [1,2,3], target = 4
// Output: 7
// Explanation:
// The possible combination ways are:
// (1, 1, 1, 1)
// (1, 1, 2)
// (1, 2, 1)
// (1, 3)
// (2, 1, 1)
// (2, 2)
// (3, 1)
// Note that different sequences are counted as different combinations.

// Example 2:
// Input: nums = [9], target = 3
// Output: 0
 

import java.util.Arrays;

public class CombinationSumIV {
    private int helper(int[] nums, int rem, int[] dp) {
        if (rem == 0) return 1;
        else if (rem < 0) return 0;

        if (dp[rem] != -1) return dp[rem];

        int ways = 0;
        for (int num: nums) 
            ways += helper(nums, rem - num, dp);
        
        dp[rem] = ways;
        return ways;
    }

    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp, -1);
        return helper(nums, target, dp);
    }
}
