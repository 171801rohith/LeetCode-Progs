// 101. Symmetric Tree
// Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

// Example 1:
// Input: root = [1,2,2,3,4,4,3]
// Output: true

// Example 2:
// Input: root = [1,2,2,null,3,null,3]
// Output: false

public class SymmetricTree {
    private boolean isMirror(TreeNode l, TreeNode r) {
        if(l  == null || r == null) return l == r;
        
        return l.val == r.val && isMirror(l.left, r.right) && isMirror(l.right, r.left);
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isMirror(root.left, root.right);     
    }
}
