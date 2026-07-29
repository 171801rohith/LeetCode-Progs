// 114. Flatten Binary Tree to Linked List
// Given the root of a binary tree, flatten the tree into a "linked list":
// The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
// The "linked list" should be in the same order as a pre-order traversal of the binary tree.

// Example 1:
// Input: root = [1,2,5,3,4,null,6]
// Output: [1,null,2,null,3,null,4,null,5,null,6]

// Example 2:
// Input: root = []
// Output: []

// Example 3:
// Input: root = [0]
// Output: [0]


import java.util.ArrayList;
import java.util.List;

public class FlattenBinaryTreeToLinkedList {
    private void preOrderDfs(TreeNode root, List<TreeNode> list) {
        if (root == null) return;
        list.add(root);
        preOrderDfs(root.left, list);
        preOrderDfs(root.right, list);
    }

    public void flatten(TreeNode root) {
        if (root == null) return;
        
        List<TreeNode> list = new ArrayList<>();

        preOrderDfs(root, list);

        for(int i = 0; i < list.size() - 1; i++) {
            list.get(i).left = null;
            list.get(i).right = list.get(i + 1);
        }
        list.get(list.size() - 1).left = null;
        list.get(list.size() - 1).right = null;
    }
}
