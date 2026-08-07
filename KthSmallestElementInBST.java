// 230. Kth Smallest Element in a BST
// Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.

// Example 1:
// Input: root = [3,1,4,null,2], k = 1
// Output: 1

// Example 2:
// Input: root = [5,3,6,2,4,null,null,1], k = 3
// Output: 3
 

import java.util.ArrayList;
import java.util.List;

public class KthSmallestElementInBST {
    int count = 0;
    int ans = -1; 

    private void inOrder(TreeNode root, int k) {
        if (root == null) return;
        if (ans != -1) return;

        inOrder(root.left, k);
        if (++count == k) ans = root.val;
        inOrder(root.right, k);

    }
    
    public int kthSmallest(TreeNode root, int k) {
        inOrder(root, k); 
        return ans;
    }

    List<Integer> list = new ArrayList<>();

    private void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);

    }

    public int kthSmallestLazy(TreeNode root, int k) {
        inOrder(root); 
        return list.get(k - 1);
    }
}
