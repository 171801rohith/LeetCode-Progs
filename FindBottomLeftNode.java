// 513. Find Bottom Left Tree Value
// You are given the root of a binary tree.
// Return the leftmost value in the last row of the tree.

// Example 1:
// Input: root = [2,1,3]
// Output: 1
// Explanation: The last row is [1,3], so the leftmost value is 1.

// Example 2:
// Input: root = [1,2,3,4,null,5,6,null,null,7]
// Output: 7
// Explanation: The last row contains only the node 7.
 
import java.util.ArrayDeque;
import java.util.Deque;

public class FindBottomLeftNode {
    public int findBottomLeftValue(TreeNode root) {
        Deque<TreeNode> q = new ArrayDeque<>();
        int left = -1;

        q.offer(root);

        while (!q.isEmpty()) {
            int lvlSize = q.size();

            for (int i = 0; i < lvlSize; i++) {
                TreeNode node = q.poll();
                if (i == 0) left = node.val;

                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
        }   
        return left;
    }
}
