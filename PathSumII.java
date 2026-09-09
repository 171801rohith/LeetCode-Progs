// 113. Path Sum II
// Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where the sum of the node values in the path equals targetSum. Each path should be returned as a list of the node values, not node references.
// A root-to-leaf path is a path starting from the root and ending at any leaf node. A leaf is a node with no children.

// Example 1:
// Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
// Output: [[5,4,11,2],[5,8,4,5]]
// Explanation: There are two paths whose sum equals targetSum:
// 5 + 4 + 11 + 2 = 22
// 5 + 8 + 4 + 5 = 22

// Example 2:
// Input: root = [1,2,3], targetSum = 5
// Output: []

// Example 3:
// Input: root = [1,2], targetSum = 0
// Output: []

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
    private void dfs(TreeNode root, int rem, List<Integer> cur, List<List<Integer>> list) {
        if (root == null)
            return;
            
        cur.add(root.val);
        if (root.left == null && root.right == null && rem == root.val) {
            list.add(new ArrayList<>(cur));
        } else {
            dfs(root.left, rem - root.val, cur, list);
            dfs(root.right, rem - root.val, cur, list);
        }
        cur.remove(cur.size() - 1);
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();

        dfs(root, targetSum, cur, list);

        return list;
    }
}
