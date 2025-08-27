// 1796. Second Largest Digit in a String
// Given an alphanumeric string s, return the second largest numerical digit that appears in s, or -1 if it does not exist.
// An alphanumeric string is a string consisting of lowercase English letters and digits.

// Example 1:
// Input: s = "dfa12321afd"
// Output: 2
// Explanation: The digits that appear in s are [1, 2, 3]. The second largest digit is 2.

// Example 2:
// Input: s = "abc1111"
// Output: -1
// Explanation: The digits that appear in s are [1]. There is no second largest digit.

public class SecLargestDigitInStr {
    public int secondHighest(String s) {
        int max = -1, secMax = -1;
        for (int i = 0; i < s.length(); i++) {
            int n = s.charAt(i) - '0';
            if (n >= 0 && n <= 9) {
                if (n > max) {
                    secMax = max;
                    max = n;
                }
                if (n > secMax && n != max)
                    secMax = n;
            }
        }
        return secMax;
    }
}
