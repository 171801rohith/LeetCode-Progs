// 78. Subsets
// Given an integer array nums of unique elements, return all possible subsets (the power set).
// The solution set must not contain duplicate subsets. Return the solution in any order.

// Example 1:
// Input: nums = [1,2,3]
// Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

// Example 2:
// Input: nums = [0]
// Output: [[],[0]]

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    private void backtrack(int[] nums, int i, List<Integer> current, List<List<Integer>> ans) {
        if (i == nums.length) {
            ans.add(new ArrayList<>(current));
            return;
        }
        backtrack(nums, i + 1, current, ans);
        
        current.add(nums[i]);
        backtrack(nums, i + 1, current, ans);
        current.remove(current.size() - 1);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        
        backtrack(nums, 0, current, ans);

        return ans;
    }
}
