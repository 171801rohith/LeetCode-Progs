// 128. Longest Consecutive Sequence
// Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
// You must write an algorithm that runs in O(n) time.

// Example 1:
// Input: nums = [100,4,200,1,3,2]
// Output: 4
// Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.

// Example 2:
// Input: nums = [0,3,7,2,5,8,4,6,0,1]
// Output: 9

// Example 3:
// Input: nums = [1,0,1,2]
// Output: 3

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSeq {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        for (int num: nums) set.add(num);

        int max = 0;
        for (int num: set) {
           if (!set.contains(num - 1)) {
                int cur = num, len = 1;

                while (set.contains(cur + 1)) {
                    cur++;
                    len++;
                }

                max = Math.max(max, len);
            }
        }
        return max;
    }

    public int longestConsecutiveLazy(int[] nums) {

        Arrays.sort(nums);
        
        int count = 1, max = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] + 1 == nums[i + 1]) count++;
            else if (nums[i] != nums[i + 1]) {
                max = Math.max(max, count);
                count = 1;
            }
        }
        return Math.max(max, count);
    }
}
