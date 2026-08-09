// 103. Binary Tree Zigzag Level Order Traversal
// Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).

// Example 1:
// Input: root = [3,9,20,null,null,15,7]
// Output: [[3],[20,9],[15,7]]

// Example 2:
// Input: root = [1]
// Output: [[1]]

// Example 3:
// Input: root = []
// Output: []

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class ZigZagTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();
        Deque<TreeNode> q = new LinkedList<>();
        if (root == null) return levels;

        q.offer(root);
        while (!q.isEmpty()) {
            int lvlSize = q.size();
            List<Integer> row = new ArrayList<>();

            for (int i = 0; i < lvlSize; i++) {
                TreeNode node = q.poll();
                row.add(node.val);
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right); 
            }
            levels.add(row);
        }

        for (int i = 0; i < levels.size(); i++) 
            if ((i & 1) == 1) Collections.reverse(levels.get(i));
        

        return levels;
    }
}
