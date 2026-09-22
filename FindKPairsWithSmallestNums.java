// 373. Find K Pairs with Smallest Sums
// You are given two integer arrays nums1 and nums2 sorted in non-decreasing order and an integer k.
// Define a pair (u, v) which consists of one element from the first array and one element from the second array.
// Return the k pairs (u1, v1), (u2, v2), ..., (uk, vk) with the smallest sums.

// Example 1:
// Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
// Output: [[1,2],[1,4],[1,6]]
// Explanation: The first 3 pairs are returned from the sequence: [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]

// Example 2:
// Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
// Output: [[1,1],[1,1]]
// Explanation: The first 2 pairs are returned from the sequence: [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
 

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class FindKPairsWithSmallestNums {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(nums1[a[0]] + nums2[a[1]], nums1[b[0]] + nums2[b[1]])
        );
        List<List<Integer>> list = new ArrayList<>(k);        

        for (int i = 0; i < Math.min(nums1.length, k); i++)
            minHeap.offer(new int[] {i, 0});
        
        while (k-- > 0 && !minHeap.isEmpty()) {
            int[] cur = minHeap.poll();

            int i = cur[0];
            int  j = cur[1];

            list.add(List.of(nums1[i], nums2[j]));
            if (j + 1 < nums2.length) 
                minHeap.offer(new int[] {i, j + 1});
        }

        return list;
    }

    public List<List<Integer>> kSmallestPairsTLE(int[] nums1, int[] nums2, int k) {
        PriorityQueue<List<Integer>> maxHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(b.get(0) + b.get(1), a.get(0) + a.get(1))
        );
        for (int i = 0; i < nums1.length; i++){
            for (int j = 0; j < nums2.length; j++){
                List<Integer> pair = List.of(nums1[i], nums2[j]);
                maxHeap.offer(pair);
                if (maxHeap.size() > k) maxHeap.poll();
            }
        }
        List<List<Integer>> list = new ArrayList<>(k);

        while (!maxHeap.isEmpty()) list.add(maxHeap.poll());
        Collections.reverse(list);

        return list;
    }   
}
