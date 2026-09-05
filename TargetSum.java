// 494. Target Sum
// You are given an integer array nums and an integer target.
// You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and then concatenate all the integers.
// For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".
// Return the number of different expressions that you can build, which evaluates to target.

// Example 1:
// Input: nums = [1,1,1,1,1], target = 3
// Output: 5
// Explanation: There are 5 ways to assign symbols to make the sum of nums be target 3.
// -1 + 1 + 1 + 1 + 1 = 3
// +1 - 1 + 1 + 1 + 1 = 3
// +1 + 1 - 1 + 1 + 1 = 3
// +1 + 1 + 1 - 1 + 1 = 3
// +1 + 1 + 1 + 1 - 1 = 3

// Example 2:
// Input: nums = [1], target = 1
// Output: 1
 


import java.util.HashMap;
import java.util.Map;

public class TargetSum {
    private int helper(int i, int curSum, int target, int[] nums, Map<String, Integer> map) {
        if (i == nums.length) {
            if (curSum == target) return 1;
            return 0;
        } 

        String state = i + "," + curSum;

        if (map.containsKey(state)) return map.get(state);

        int ways = helper(i + 1, curSum + nums[i], target, nums, map) + helper(i + 1, curSum - nums[i], target, nums, map);
        map.put(state, ways);
        return ways;
    }

    public int findTargetSumWays(int[] nums, int target) {
        Map<String, Integer> map = new HashMap<>();
        return helper(0, 0, target, nums, map);
    }

    int count = 0;

    private void backtrack(int i, int curSum, int[] nums, int target) {
        if (i == nums.length) {
            if (curSum == target) count++;
            return;
        }

        backtrack(i + 1, curSum + nums[i], nums, target);
        backtrack(i + 1, curSum - nums[i], nums, target);
    }

    public int findTargetSumWaysLazy(int[] nums, int target) {
        backtrack(0, 0, nums, target);
        return count;    
    }
}
