// 90. Subsets II
// Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
// The solution set must not contain duplicate subsets. Return the solution in any order.

// Example 1:
// Input: nums = [1,2,2]
// Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]

// Example 2:
// Input: nums = [0]
// Output: [[],[0]]

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubsetsII {
    private void backtrack(int[] nums, List<List<Integer>> list, List<Integer> cur, int start) {
        list.add(new ArrayList<>(cur));

        for (int i = start; i < nums.length; i++) {
            
            if (i > start && nums[i] == nums[i - 1]) continue;

            cur.add(nums[i]);
            backtrack(nums, list, cur, i + 1);
            cur.remove(cur.size() - 1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        backtrack(nums, list, current, 0);
        
        return list;
    }

    private void backtrack(int[] nums, Set<List<Integer>> set, List<Integer> cur, int i) {
        if (i == nums.length) {
            set.add(new ArrayList<>(cur));
            return;
        }

        backtrack(nums, set, cur, i + 1);

        cur.add(nums[i]);
        backtrack(nums, set, cur, i + 1);
        cur.remove(cur.size() - 1);
    }

    public List<List<Integer>> subsetsWithDupLazy(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        List<Integer> current = new ArrayList<>();

        backtrack(nums, set, current, 0);
        
        return new ArrayList<>(set);
    }
}
