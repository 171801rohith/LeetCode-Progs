// 239. Sliding Window Maximum
// You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
// Return the max sliding window.

// Example 1:
// Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
// Output: [3,3,5,5,6,7]
// Explanation: 
// Window position                Max
// ---------------               -----
// [1  3  -1] -3  5  3  6  7       3
//  1 [3  -1  -3] 5  3  6  7       3
//  1  3 [-1  -3  5] 3  6  7       5
//  1  3  -1 [-3  5  3] 6  7       5
//  1  3  -1  -3 [5  3  6] 7       6
//  1  3  -1  -3  5 [3  6  7]      7

// Example 2:
// Input: nums = [1], k = 1
// Output: [1]

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMax {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> q = new ArrayDeque<>();
        int[] arr = new int[nums.length - k + 1];

        for (int r = 0, l = 0, i = 0; r < nums.length; r++) {
            while (!q.isEmpty() && nums[q.peekLast()] < nums[r]) q.pollLast();
            q.offer(r);
            if (q.peekFirst() < l) q.pollFirst();

            if ((r - l + 1) == k) {
                arr[i++] = nums[q.peekFirst()];
                l++;
            }
        }

        return arr;
    }
}
