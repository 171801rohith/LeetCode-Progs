// 144. Binary Tree Preorder Traversal
// Given the root of a binary tree, return the preorder traversal of its nodes' values.

// Example 1:
// Input: root = [1,null,2,3]
// Output: [1,2,3]

// Example 2:
// Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]
// Output: [1,2,4,5,6,7,3,8,9]

// Example 3:
// Input: root = []
// Output: []

// Example 4:
// Input: root = [1]
// Output: [1]

import java.util.ArrayList;
import java.util.List;

public class PreorderTraversal {
    void preorder(TreeNode root, List<Integer> result) {
        if (root != null) {
            result.add(root.val);
            preorder(root.left, result);
            preorder(root.right, result);
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorder(root, result);
        return result;
    }
}
