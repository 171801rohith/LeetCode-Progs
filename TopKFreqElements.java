// 347. Top K Frequent Elements
// Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

// Example 1:
// Input: nums = [1,1,1,2,2,3], k = 2
// Output: [1,2]

// Example 2:
// Input: nums = [1], k = 1
// Output: [1]

// Example 3:
// Input: nums = [1,2,1,2,1,2,3,1,3,2], k = 2
// Output: [1,2]

 

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TopKFreqElements {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num: nums) map.put(num, map.getOrDefault(num, 0) + 1);
        
        List<Integer> list = new ArrayList<>(map.keySet());

        list.sort((a, b) -> Integer.compare(map.get(b), map.get(a)));

        int[] arr = new int[k];

        for (int i = 0; i < k; i++) arr[i] = list.get(i);

        return arr;
    }
}
