// 409. Longest Palindrome
// Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.
// Letters are case sensitive, for example, "Aa" is not considered a palindrome.

// Example 1:
// Input: s = "abccccdd"
// Output: 7
// Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.

// Example 2:
// Input: s = "a"
// Output: 1
// Explanation: The longest palindrome that can be built is "a", whose length is 1.

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {
    public int longestPalindrome(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char c: s.toCharArray()) freq.put(c, freq.getOrDefault(c, 0) + 1);

        int count = 0;
        boolean odd = false;

        for (int i: freq.values()) 
            if ((i & 1) == 0) count += i;
            else {
                count += i - 1;
                odd = true;
            }
        
        return odd ? ++count : count;
    }   
}
