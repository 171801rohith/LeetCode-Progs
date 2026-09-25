// 658. Find K Closest Elements
// Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array. The result should also be sorted in ascending order.
// An integer a is closer to x than an integer b if:
// |a - x| < |b - x|, or
// |a - x| == |b - x| and a < b

// Example 1:
// Input: arr = [1,2,3,4,5], k = 4, x = 3
// Output: [1,2,3,4]

// Example 2:
// Input: arr = [1,1,2,3,4,5], k = 4, x = -1
// Output: [1,1,2,3]

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class FindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) -> {
                int diff = Integer.compare(Math.abs(b - x), Math.abs(a - x)); 
                if (diff == 0) return Integer.compare(b, a);
                return diff;
            }
        );
        for (int i: arr) {
            pq.offer(i);
            if (pq.size() > k) pq.poll();
        }

        List<Integer> list = new ArrayList<>();
        while (!pq.isEmpty()) list.add(pq.poll());
        Collections.sort(list);
        return list;
    }
}
