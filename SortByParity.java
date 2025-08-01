// 905. Sort Array By Parity
// Easy
// Topics
// premium lock icon
// Companies
// Given an integer array nums, move all the even integers at the beginning of the array followed by all the odd integers.

// Return any array that satisfies this condition.

// Example 1:

// Input: nums = [3,1,2,4]
// Output: [2,4,3,1]
// Explanation: The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
// Example 2:

// Input: nums = [0]
// Output: [0]

import java.util.ArrayList;
import java.util.List;

public class SortByParity {
    public int[] sortArrayByParity(int[] nums) {
        List<Integer> odd = new ArrayList<>();
        List<Integer> even = new ArrayList<>();
        for (int num : nums) {
            if (num % 2 == 0)
                even.add(num);
            else
                odd.add(num);
        }
        even.addAll(odd);
        return even.stream().mapToInt(Integer::intValue).toArray();
    }
}
