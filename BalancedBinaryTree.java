// 110. Balanced Binary Tree
// Given a binary tree, determine if it is height-balanced.

// Example 1:
// Input: root = [3,9,20,null,null,15,7]
// Output: true

// Example 2:
// Input: root = [1,2,2,3,3,null,null,4,4]
// Output: false

// Example 3:
// Input: root = []
// Output: true

public class BalancedBinaryTree {
    private int check(TreeNode root) {
        if (root == null) return 0;

        int left = check(root.left);
        if (left == -1) return -1;

        int right = check(root.right);
        if (right == -1) return -1;

        if (Math.abs(left - right) > 1) return -1;
        
        return 1 + Math.max(left, right);
        
    }

    public boolean isBalanced(TreeNode root) {
        return check(root) != -1;
    }

    private int depth(TreeNode root) {
        if (root == null) return 0;
        int left = depth(root.left);
        int right = depth(root.right);

        return 1 + Math.max(left, right);
    }

    public boolean isBalancedLazy(TreeNode root) {
        if (root == null) return true;

        int left = depth(root.left);
        int right = depth(root.right);

        return Math.abs(left - right) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }
}
