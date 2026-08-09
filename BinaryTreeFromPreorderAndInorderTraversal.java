// 105. Construct Binary Tree from Preorder and Inorder Traversal
// Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.

// Example 1:
// Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
// Output: [3,9,20,null,null,15,7]

// Example 2:
// Input: preorder = [-1], inorder = [-1]
// Output: [-1]
 

import java.util.HashMap;

public class BinaryTreeFromPreorderAndInorderTraversal {
    HashMap<Integer, Integer> map = new HashMap<>();

    private TreeNode build(int[] pre, int[] in, int pStart, int pEnd, int iStart, int iEnd) {
        if (pStart > pEnd) return null;

        TreeNode root = new TreeNode(pre[pStart]);

        int idx = map.get(pre[pStart]);
        int lSize = idx - iStart;

        root.left = build(pre, in, pStart + 1, pStart + lSize, iStart, idx - 1);
        root.right = build(pre, in, pStart + lSize + 1, pEnd, idx + 1, iEnd);

        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) map.put(inorder[i], i);

        return build(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }
}
