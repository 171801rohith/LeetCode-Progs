// 961. N-Repeated Element in Size 2N Array
// You are given an integer array nums with the following properties:
// nums.length == 2 * n.
// nums contains n + 1 unique values, n of which occur exactly once in the array.
// Exactly one element of nums is repeated n times.
// Return the element that is repeated n times.

// Example 1:
// Input: nums = [1,2,3,3]
// Output: 3

// Example 2:
// Input: nums = [2,1,2,5,3,2]
// Output: 2

// Example 3:
// Input: nums = [5,1,5,2,5,3,5,4]
// Output: 5

import java.util.HashSet;

public class NRepeatedElementIn2NArr {
    public int repeatedNTimes(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();
        for (int num: nums) 
            if (!seen.add(num)) return num;
        return -1;
    }
}