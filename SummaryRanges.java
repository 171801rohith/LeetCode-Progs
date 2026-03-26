// 228. Summary Ranges
// You are given a sorted unique integer array nums.
// A range [a,b] is the set of all integers from a to b (inclusive).
// Return the smallest sorted list of ranges that cover all the numbers in the array exactly. That is, each element of nums is covered by exactly one of the ranges, and there is no integer x such that x is in one of the ranges but not in nums.
// Each range [a,b] in the list should be output as:
// "a->b" if a != b
// "a" if a == b

// Example 1:
// Input: nums = [0,1,2,4,5,7]
// Output: ["0->2","4->5","7"]
// Explanation: The ranges are:
// [0,2] --> "0->2"
// [4,5] --> "4->5"
// [7,7] --> "7"

// Example 2:
// Input: nums = [0,2,3,4,6,8,9]
// Output: ["0","2->4","6","8->9"]
// Explanation: The ranges are:
// [0,0] --> "0"
// [2,4] --> "2->4"
// [6,6] --> "6"
// [8,9] --> "8->9"

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> ranges = new ArrayList<>();
        if (nums.length == 0)
            return ranges;

        int start = nums[0], end = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - end == 1)
                end = nums[i];
            else {
                if (start == end) {
                    ranges.add(String.valueOf(start));
                } else {
                    String str = String.valueOf(start) + "->" + String.valueOf(end);
                    ranges.add(str);
                }
                start = nums[i];
                end = nums[i];
            }

        }
        if (start == end) {
            ranges.add(String.valueOf(start));
        } else {
            String str = String.valueOf(start) + "->" + String.valueOf(end);
            ranges.add(str);
        }
        return ranges;
    }
}