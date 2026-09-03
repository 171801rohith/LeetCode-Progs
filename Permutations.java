// 46. Permutations
// Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

// Example 1:
// Input: nums = [1,2,3]
// Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

// Example 2:
// Input: nums = [0,1]
// Output: [[0,1],[1,0]]

// Example 3:
// Input: nums = [1]
// Output: [[1]]


import java.util.ArrayList;
import java.util.List;

public class Permutations {
    private void backtrack(int[] nums, List<Integer> cur, List<List<Integer>> list, boolean[] used) {
        if (cur.size() == nums.length) {
            list.add(new ArrayList<>(cur));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;

            cur.add(nums[i]);
            used[i] = true;
            backtrack(nums, cur, list, used);
            cur.remove(cur.size() - 1);
            used[i] = false;
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(nums, new ArrayList<>(), list, used);
        return list;
    }
}
