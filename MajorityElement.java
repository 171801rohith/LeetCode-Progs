// 169. Majority Element
// Given an array nums of size n, return the majority element.
// The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
// Example 1:
// Input: nums = [3,2,3]
// Output: 3

// Example 2:
// Input: nums = [2,2,1,1,1,2,2]
// Output: 2


// 229. Majority Element II
// Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

// Example 1:
// Input: nums = [3,2,3]
// Output: [3]

// Example 2:
// Input: nums = [1]
// Output: [1]

// Example 3:
// Input: nums = [1,2]
// Output: [1,2]

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public List<Integer> majorityElement2(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num: nums) map.put(num, map.getOrDefault(num, 0) + 1);
        
        List<Integer> majority = new ArrayList<>();
        int n = nums.length / 3;
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (entry.getValue() > n) majority.add(entry.getKey());
        }
        return majority;
    }
}
