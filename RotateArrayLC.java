// 189. Rotate Array
// Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.

// Example 1:
// Input: nums = [1,2,3,4,5,6,7], k = 3
// Output: [5,6,7,1,2,3,4]
// Explanation:
// rotate 1 steps to the right: [7,1,2,3,4,5,6]
// rotate 2 steps to the right: [6,7,1,2,3,4,5]
// rotate 3 steps to the right: [5,6,7,1,2,3,4]

// Example 2:
// Input: nums = [-1,-100,3,99], k = 2
// Output: [3,99,-1,-100]
// Explanation: 
// rotate 1 steps to the right: [99,-1,-100,3]
// rotate 2 steps to the right: [3,99,-1,-100]

public class RotateArrayLC {
    public void reverseArray(int[] nums, int s, int e) {
        int temp;
        while (s < e) {
            temp = nums[s];
            nums[s] = nums[e];
            nums[e] = temp;

            s++;
            e--;
        }
    }

    public void rotateClockwise(int[] nums, int k) {
        k = k % nums.length;
        reverseArray(nums, 0, nums.length - 1);
        reverseArray(nums, 0, k - 1);
        reverseArray(nums, k, nums.length - 1);
    }

    public void rotateCounterClockwise(int[] nums, int k) {
        k = k % nums.length;
        reverseArray(nums, 0, k - 1);
        reverseArray(nums, k, nums.length - 1);
        reverseArray(nums, 0, nums.length - 1);
    }
}



// Input:
// Array arr of size n
// Number of positions to rotate, k

// Adjust k:
// If k > n, set k = k % n (to handle rotations greater than the array size).

// Steps to Rotate (Clockwise):
// 1. Reverse the entire array.
// 2. Reverse the first k elements.
// 3. Reverse the remaining n-k elements.

// Steps to Rotate (Counter-Clockwise):
// 1. Reverse the first k elements.
// 2. Reverse the remaining n-k elements.
// 3. Reverse the entire array.