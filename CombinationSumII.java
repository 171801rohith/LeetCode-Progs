// 40. Combination Sum II
// Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.
// Each number in candidates may only be used once in the combination.
// Note: The solution set must not contain duplicate combinations.

// Example 1:
// Input: candidates = [10,1,2,7,6,1,5], target = 8
// Output: 
// [
// [1,1,6],
// [1,2,5],
// [1,7],
// [2,6]
// ]

// Example 2:
// Input: candidates = [2,5,2,1,2], target = 5
// Output: 
// [
// [1,2,2],
// [5]
// ]
 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    private void backtrack(int start, List<List<Integer>> list, int[] nums, List<Integer> cur, int rem) {
        if (rem == 0) {
            list.add(new ArrayList<>(cur));
            return;
        }
        if (rem < 0) return;

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i - 1] == nums[i]) continue;

            if (nums[i] > rem) break;

            cur.add(nums[i]);
            backtrack(i + 1, list, nums, cur, rem - nums[i]);
            cur.remove(cur.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList();
        Arrays.sort(candidates);
        backtrack(0, list, candidates, new ArrayList<>(), target);
        return list;
    }
}
