// 1636. Sort Array by Increasing Frequency
// Given an array of integers nums, sort the array in increasing order based on the frequency of the values. If multiple values have the same frequency, sort them in decreasing order.
// Return the sorted array.

// Example 1:
// Input: nums = [1,1,2,2,2,3]
// Output: [3,1,1,2,2,2]
// Explanation: '3' has a frequency of 1, '1' has a frequency of 2, and '2' has a frequency of 3.

// Example 2:
// Input: nums = [2,3,1,3,2]
// Output: [1,3,3,2,2]
// Explanation: '2' and '3' both have a frequency of 2, so they are sorted in decreasing order.

// Example 3:
// Input: nums = [-1,1,-6,4,5,-6,1,4,1]
// Output: [5,-1,4,4,-6,-6,1,1,1]

import java.util.HashMap;

public class SortByIncreasingFreq {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);

        int[] freq = new int[nums.length];
        for (int i = 0; i < nums.length; i++)
            freq[i] = map.get(nums[i]);

        for (int i = 0; i < nums.length; i++) {
            int minIdx = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (freq[minIdx] > freq[j] || (freq[minIdx] == freq[j] && nums[minIdx] < nums[j]))
                    minIdx = j;
            }
            if (minIdx != i) {
                int temp = nums[i];
                nums[i] = nums[minIdx];
                nums[minIdx] = temp;

                temp = freq[i];
                freq[i] = freq[minIdx];
                freq[minIdx] = temp;
            }
        }
        return nums;
    }
}