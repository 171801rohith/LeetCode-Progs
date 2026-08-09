// 106. Construct Binary Tree from Inorder and Postorder Traversal
// Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree, construct and return the binary tree.

// Example 1:
// Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
// Output: [3,9,20,null,null,15,7]

// Example 2:
// Input: inorder = [-1], postorder = [-1]
// Output: [-1]


import java.util.HashMap;

public class BinaryTreeFromPostorderAndInorderTraversal {
    HashMap<Integer, Integer> map = new HashMap<>();

    private TreeNode build(int[] in, int[] post, int iStart, int iEnd, int pStart, int pEnd) {
        if (pStart > pEnd) return null;

        TreeNode root = new TreeNode(post[pEnd]);

        int idx = map.get(post[pEnd]);
        int lSize = idx - iStart;

        root.right = build(in, post, idx + 1, iEnd, pStart + lSize, pEnd - 1);
        root.left = build(in, post, iStart, idx - 1, pStart, pStart + lSize - 1);

        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) map.put(inorder[i], i);

        return build(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }
}
