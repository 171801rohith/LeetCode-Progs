// 169. Majority Element
// Given an array nums of size n, return the majority element.
// The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
// Example 1:
// Input: nums = [3,2,3]
// Output: 3

// Example 2:
// Input: nums = [2,2,1,1,1,2,2]
// Output: 2

import java.util.HashMap;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> majority = new HashMap<>();
        for (int num : nums) {
            if (!majority.containsKey(num)) {
                majority.put(num, 1);
            } else {
                majority.computeIfPresent(num, (key, value) -> value + 1);
            }
        }
        System.out.println(majority);
        for (Integer key : majority.keySet()) {
            if (majority.get(key) > (nums.length / 2))
                return key;
        }
        return -1;
    }
}
