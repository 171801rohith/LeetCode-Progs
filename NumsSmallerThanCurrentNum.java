// 1365. How Many Numbers Are Smaller Than the Current Number
// Given the array nums, for each nums[i] find out how many numbers in the array are smaller than it. That is, for each nums[i] you have to count the number of valid j's such that j != i and nums[j] < nums[i].
// Return the answer in an array.

// Example 1:
// Input: nums = [8,1,2,2,3]
// Output: [4,0,1,1,3]
// Explanation: 
// For nums[0]=8 there exist four smaller numbers than it (1, 2, 2 and 3). 
// For nums[1]=1 does not exist any smaller number than it.
// For nums[2]=2 there exist one smaller number than it (1). 
// For nums[3]=2 there exist one smaller number than it (1). 
// For nums[4]=3 there exist three smaller numbers than it (1, 2 and 2).

// Example 2:
// Input: nums = [6,5,4,8]
// Output: [2,1,0,3]

// Example 3:
// Input: nums = [7,7,7,7]
// Output: [0,0,0,0]

import java.util.HashMap;
import java.util.Set;

public class NumsSmallerThanCurrentNum {
    public HashMap<Integer, Integer> createMap(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int num : nums) {
            if (hm.putIfAbsent(num, 1) != null) {
                hm.compute(num, (key, value) -> value + 1);
            }
        }
        return hm;
    }

    public int[] smallerNumbersThanCurrent(int[] nums) {
        HashMap<Integer, Integer> map = createMap(nums);
        int[] result = new int[nums.length];
        System.out.println(map);
        Set<Integer> keySet = map.keySet();
        for (int i = 0; i < nums.length; i++) {
            for (Integer key : keySet) {
                if (key < nums[i])
                    result[i] += map.get(key);
            }
        }
        return result;
    }
}
