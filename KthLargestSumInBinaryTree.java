// 2583. Kth Largest Sum in a Binary Tree
// You are given the root of a binary tree and a positive integer k.
// The level sum in the tree is the sum of the values of the nodes that are on the same level.
// Return the kth largest level sum in the tree (not necessarily distinct). If there are fewer than k levels in the tree, return -1.
// Note that two nodes are on the same level if they have the same distance from the root.

// Example 1:
// Input: root = [5,8,9,2,1,3,7,4,6], k = 2
// Output: 13
// Explanation: The level sums are the following:
// - Level 1: 5.
// - Level 2: 8 + 9 = 17.
// - Level 3: 2 + 1 + 3 + 7 = 13.
// - Level 4: 4 + 6 = 10.
// The 2nd largest level sum is 13.

// Example 2:
// Input: root = [1,2,null,3], k = 1
// Output: 3
// Explanation: The largest level sum is 3.

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

public class KthLargestSumInBinaryTree {
    public long kthLargestLevelSum(TreeNode root, int k) {
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int lvlSize = q.size();
            long sum = 0;

            for (int i = 0; i < lvlSize; i++) {
                TreeNode node = q.poll();
                sum += node.val;

                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }

            minHeap.offer(sum);
            if (minHeap.size() > k) minHeap.poll();
        }
        return minHeap.size() != k ? -1: minHeap.poll();
    }
}
