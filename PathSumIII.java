// 437. Path Sum III
// Given the root of a binary tree and an integer targetSum, return the number of paths where the sum of the values along the path equals targetSum.
// The path does not need to start or end at the root or a leaf, but it must go downwards (i.e., traveling only from parent nodes to child nodes).

// Example 1:
// Input: root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
// Output: 3
// Explanation: The paths that sum to 8 are shown.

// Example 2:
// Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
// Output: 3


import java.util.Stack;

public class PathSumIII {
 int count = 0;
    private void dfs(TreeNode root, long rem) {
        if (root == null) return;
        rem -= root.val;
        if (rem == 0) count++;

        dfs(root.left, rem);
        dfs(root.right, rem);
    }

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while (!st.isEmpty()) {
            TreeNode node = st.pop();
            dfs(node, targetSum);

            if (node.left != null) st.push(node.left);
            if (node.right != null) st.push(node.right);
        }
        return count;
    }
}