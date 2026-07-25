// 1302. Deepest Leaves Sum
// Given the root of a binary tree, return the sum of values of its deepest leaves.
 
// Example 1:
// Input: root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
// Output: 15

// Example 2:
// Input: root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
// Output: 19
 

import java.util.LinkedList;
import java.util.Queue;

public class DeepestLeavesSum {
    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int sum = 0;
        while (!q.isEmpty()) {
            int levelSize = q.size();
            sum = 0;
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = q.poll();
                
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
                sum+= node.val;
            }

        }
        return sum;
    }

    private int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        return 1 + Math.max(l, r);
    }

    private int bfs(TreeNode root, int targetLevel) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int sum = 0;
        int level = 0;
        while (!q.isEmpty()) {
            int levelSize = q.size();
            level++;
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = q.poll();
                if (level == targetLevel) sum+= node.val;
                
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);

            }

            if (level == targetLevel) return sum;
        }
        return 0;
    }

    public int deepestLeavesSumLazy(TreeNode root) {
        return bfs(root, maxDepth(root));
    }
}
