// 1004. Max Consecutive Ones III
// Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.

// Example 1:
// Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
// Output: 6
// Explanation: [1,1,1,0,0,1,1,1,1,1,1]
// Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.

// Example 2:
// Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
// Output: 10
// Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
// Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.

public class MaxConsecutiveOnesIII {
    public int longestOnes(int[] nums, int k) {
        int best = 0;
        int[] freq = new int[2];

        for (int r = 0, l = 0; r < nums.length; r++) {
            freq[nums[r]]++;

            while (freq[0] > k) {
                freq[nums[l]]--;
                l++;
            }

            best = Math.max(best, (r - l + 1));
        }

        return best;
    }   
}
