// 1784. Check if Binary String Has at Most One Segment of Ones
// Solved
// Easy
// Topics
// premium lock icon
// Companies
// Hint
// Given a binary string s ​​​​​without leading zeros, return true​​​ if s contains at most one contiguous segment of ones. Otherwise, return false.

// Example 1:

// Input: s = "1001"
// Output: false
// Explanation: The ones do not form a contiguous segment.
// Example 2:

// Input: s = "110"
// Output: true

public class BinStrMostOne {
    public boolean checkOnesSegment(String s) {
        return s.contains("01") ? false : true;
    }
    // public boolean checkOnesSegment(String s) {
    // String[] ones = s.split("0");
    // return ones.length == 1 ? true : false;
    // }
}
