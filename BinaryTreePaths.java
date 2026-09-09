// 257. Binary Tree Paths
// You are given the root of a binary tree.
// Return all root-to-leaf paths in any order.
// A leaf is a node with no children.

// Example 1:
// Input: root = [1,2,3,null,5]
// Output: ["1->2->5","1->3"]

// Example 2:
// Input: root = [1]
// Output: ["1"]


import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
 private void dfs(TreeNode root, StringBuilder cur, List<String> list) {
        if (root == null) return;

        int len = cur.length();
        cur.append(root.val);

        if (root.left == null && root.right == null) {
            list.add(cur.toString());
        } else {
            cur.append("->");
            dfs(root.left, cur, list);
            dfs(root.right, cur, list);
        }
        cur.setLength(len);

    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        dfs(root, new StringBuilder(), list);
        return list;
    }
}
