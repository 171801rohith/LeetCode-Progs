// 283. Move Zeroes
// Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
// Note that you must do this in-place without making a copy of the array.

// Example 1:
// Input: nums = [0,1,0,3,12]
// Output: [1,3,12,0,0]

// Example 2:
// Input: nums = [0]
// Output: [0]

public class MoveZeros {
    public void moveZeroes(int[] nums) {
        int[] copy = nums.clone();
        int count = 0;
        for (int i = 0, j = 0; i < copy.length; i++) {
            if (copy[i] != 0) {
                nums[j++] = copy[i];
            } else {
                count++;
            }
        }
        for (int i = nums.length - 1; i >= nums.length - count; i--)
            nums[i] = 0;
    }
}
