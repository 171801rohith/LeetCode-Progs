// Write a function to find the longest common prefix string amongst an array of strings.
// If there is no common prefix, return an empty string "".
// Example 1:
// Input: strs = ["flower","flow","flight"]
// Output: "fl"
// Example 2:
// Input: strs = ["dog","racecar","car"]
// Output: ""
// Explanation: There is no common prefix among the input strings.

public class LongestPrefix {
    public String longestCommonPrefix(String[] strs) {
        String longPrefix = "";
        char ch1, ch2;
        int minLen = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            if (minLen > strs[i].length()) {
                minLen = strs[i].length();
            }
        }
        for (int i = 0; i < minLen; i++) {
            ch1 = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                ch2 = strs[j].charAt(i);
                if (ch1 != ch2) {
                    return longPrefix;
                }
            }
            longPrefix += ch1;
        }
        return longPrefix;
    }
}
