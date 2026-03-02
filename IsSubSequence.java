// 392. Is Subsequence
// Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
// A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).

// Example 1:
// Input: s = "abc", t = "ahbgdc"
// Output: true

// Example 2:
// Input: s = "axc", t = "ahbgdc"
// Output: false

public class IsSubSequence {
    public boolean isSubsequence(String s, String t) {
        int p1 = 0, p2 = 0;
        if (s.equals(""))
            return true;
        while (p2 != t.length()) {
            if (s.charAt(p1) == t.charAt(p2)) {
                p1++;
                p2++;
                if (p1 == s.length())
                    return true;
            } else {
                p2++;
                if (p1 == s.length())
                    p1 = 0;
            }
        }
        return false;
    }
}
