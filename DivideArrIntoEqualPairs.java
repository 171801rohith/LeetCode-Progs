// 2206. Divide Array Into Equal Pairs
// You are given an integer array nums consisting of 2 * n integers.
// You need to divide nums into n pairs such that:
// Each element belongs to exactly one pair.
// The elements present in a pair are equal.
// Return true if nums can be divided into n pairs, otherwise return false.

// Example 1:
// Input: nums = [3,2,3,2,2,2]
// Output: true
// Explanation: 
// There are 6 elements in nums, so they should be divided into 6 / 2 = 3 pairs.
// If nums is divided into the pairs (2, 2), (3, 3), and (2, 2), it will satisfy all the conditions.

// Example 2:
// Input: nums = [1,2,3,4]
// Output: false
// Explanation: 
// There is no way to divide nums into 4 / 2 = 2 pairs such that the pairs satisfy every condition.
 

import java.util.HashMap;
import java.util.Map;

public class DivideArrIntoEqualPairs {
        public boolean divideArray(int[] nums) {
        int[] count = new int[501];
        for (int num: nums) count[num]++;
        
        for (int num: nums) 
            if ((count[num] & 1) == 1) return false;

        return true; 
    }

    public boolean divideArrayLazy(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num: nums) map.put(num, map.getOrDefault(num, 0) + 1);
        
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) 
            if ((entry.getValue() & 1) == 1) return false;
        
        return true; 
    }
}
