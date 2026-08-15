// 152. Maximum Product Subarray
// Given an integer array nums, find a subarray that has the largest product, and return the product.
// The test cases are generated so that the answer will fit in a 32-bit integer.
// Note that the product of an array with a single element is the value of that element.

// Example 1:
// Input: nums = [2,3,-2,4]
// Output: 6
// Explanation: [2,3] has the largest product 6.

// Example 2:
// Input: nums = [-2,0,-1]
// Output: 0
// Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 

public class MaxProductSubArr {
    public int maxProduct(int[] nums) {
        int minPro = nums[0], maxPro = nums[0], bestPro = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int cur = nums[i];
            int oldMax = maxPro;
            int oldMin = minPro;

            maxPro = Math.max(cur, Math.max(cur * oldMax, cur * oldMin));
            minPro = Math.min(cur, Math.min(cur * oldMax, cur * oldMin));

            bestPro = Math.max(bestPro, maxPro);
        }
        
        return bestPro;
    }
}
