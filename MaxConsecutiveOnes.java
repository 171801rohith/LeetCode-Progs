// 485. Max Consecutive Ones
// Given a binary array nums, return the maximum number of consecutive 1's in the array.

// Example 1:
// Input: nums = [1,1,0,1,1,1]
// Output: 3
// Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.

// Example 2:
// Input: nums = [1,0,1,1,0,1]
// Output: 2
 

public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max_count = 0, count = 0;
        for (int num: nums) {
            if (num == 1) count++;
            else {
                if (count > max_count) max_count = count;
                count = 0;
            }
        }
        if (count > max_count) max_count = count;
        return max_count;
    }
}
