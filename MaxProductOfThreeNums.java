// 628. Maximum Product of Three Numbers
// Given an integer array nums, find three numbers whose product is maximum and return the maximum product.

// Example 1:
// Input: nums = [1,2,3]
// Output: 6

// Example 2:
// Input: nums = [1,2,3,4]
// Output: 24

// Example 3:
// Input: nums = [-1,-2,-3]
// Output: -6

import java.util.Arrays;

public class MaxProductOfThreeNums {
    // public void swap(int[] a, int i, int j) {
    // int temp = a[i];
    // a[i] = a[j];
    // a[j] = temp;
    // }

    // public int maximumProduct(int[] nums) {
    // for (int i = 0; i < nums.length; i++) {
    // int minIndex = i;
    // for (int j = i + 1; j < nums.length; j++) {
    // if (nums[minIndex] > nums[j])
    // minIndex = j;
    // }
    // if (minIndex != i)
    // swap(nums, i, minIndex);
    // }
    // int n = nums.length;
    // return Math.max(nums[0] * nums[1] * nums[n - 1], nums[n - 1] * nums[n - 2] *
    // nums[n - 3]);
    // }

    public int maximumProduct(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        return Math.max(nums[n - 1] * nums[n - 2] * nums[n - 3], nums[0] * nums[1] * nums[n - 1]);
    }
}

// Two possibilities:
// 1. Product of top 3 numbers (all positive)
// 2. Product of 2 smallest (possibly negative) and largest number