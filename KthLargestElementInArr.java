// 215. Kth Largest Element in an Array
// Given an integer array nums and an integer k, return the kth largest element in the array.
// Note that it is the kth largest element in the sorted order, not the kth distinct element.
// Can you solve it without sorting?

// Example 1:
// Input: nums = [3,2,1,5,6,4], k = 2
// Output: 5

// Example 2:
// Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
// Output: 4

import java.util.PriorityQueue;

public class KthLargestElementInArr {
     public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num: nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) minHeap.poll();
        }
        return minHeap.peek();
    }

    private int quickSelect(int[] nums, int l, int r, int target) {
        if (l == r) return nums[l];

        int pivotIdx = partition(nums, l, r);

        if (pivotIdx == target) return nums[pivotIdx];
        else if (pivotIdx < target) return quickSelect(nums, pivotIdx + 1, r, target);
        else return quickSelect(nums, l, pivotIdx - 1, target);
    }

    private int partition(int[] nums, int l, int r) {
        int pivot = nums[r];
        int i = l;

        for (int j = l; j < r; j++) {
            if (nums[j] < pivot) {
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, i, r);

        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int findKthLargestComplicated(int[] nums, int k) {
        int target = nums.length - k;
        return quickSelect(nums, 0, nums.length - 1, target);
    }
}
