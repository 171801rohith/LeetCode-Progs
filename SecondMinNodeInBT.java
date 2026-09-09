// 671. Second Minimum Node In a Binary Tree
// Given a non-empty special binary tree consisting of nodes with the non-negative value, where each node in this tree has exactly two or zero sub-node. If the node has two sub-nodes, then this node's value is the smaller value among its two sub-nodes. More formally, the property root.val = min(root.left.val, root.right.val) always holds.
// Given such a binary tree, you need to output the second minimum value in the set made of all the nodes' value in the whole tree.
// If no such second minimum value exists, output -1 instead.

// Example 1:
// Input: root = [2,2,5,null,null,5,7]
// Output: 5
// Explanation: The smallest value is 2, the second smallest value is 5.

// Example 2:
// Input: root = [2,2,2]
// Output: -1
// Explanation: The smallest value is 2, but there isn't any second smallest value.

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

public class SecondMinNodeInBT {
private long dfs(TreeNode root, int min) {
        if (root == null) return Long.MAX_VALUE;
        if (root.val > min) return root.val;
        return Math.min(dfs(root.left, min), dfs(root.right, min));
    }

    public int findSecondMinimumValue(TreeNode root) {
        long ans = dfs(root, root.val);
        return ans == Long.MAX_VALUE ? -1 : (int) ans;
    }

    public int findSecondMinimumValueLazy(TreeNode root) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();  
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            minHeap.offer(node.val);

            if (node.left != null) q.offer(node.left);
            if (node.right != null) q.offer(node.right);
        }

        Integer fmin = minHeap.poll();

        while (!minHeap.isEmpty()) { 
            int smin = minHeap.poll(); 
            if (smin > fmin) return smin;  
        }

        return -1; 
    } 
}
