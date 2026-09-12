// 508. Most Frequent Subtree Sum
// Given the root of a binary tree, return the most frequent subtree sum. If there is a tie, return all the values with the highest frequency in any order.
// The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node (including the node itself).

// Example 1:
// Input: root = [5,2,-3]
// Output: [2,-3,4]

// Example 2:
// Input: root = [5,2,-5]
// Output: [2]

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MostFreqSubtreeSum {
    private int dfs(TreeNode root, Map<Integer, Integer> map) {
        if (root == null) return 0;

        int lsum = dfs(root.left, map);
        int rsum = dfs(root.right, map);
        int sum = root.val + lsum + rsum;

        map.put(sum, map.getOrDefault(sum, 0) + 1);

        return sum;
    }

    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> sumFreq = new HashMap<>();
        dfs(root, sumFreq);
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(b[1], a[1])
        );

        for(Map.Entry<Integer, Integer> entry: sumFreq.entrySet()) 
            pq.offer(new int[]{entry.getKey(), entry.getValue()});

        int[] ans = new int[pq.size()];
        int k = 0;
        int[] most = pq.poll();
        ans[k++] = most[0];

        while (!pq.isEmpty() && pq.peek()[1] == most[1]) ans[k++] = pq.poll()[0];

        return Arrays.copyOf(ans, k);
    }    
}
