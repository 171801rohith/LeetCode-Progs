// 3517. Smallest Palindromic Rearrangement I
// You are given a palindromic string s.
// Return the lexicographically smallest palindromic permutation of s.

// Example 1:
// Input: s = "z"
// Output: "z"
// Explanation:
// A string of only one character is already the lexicographically smallest palindrome.

// Example 2:
// Input: s = "babab"
// Output: "abbba"
// Explanation:
// Rearranging "babab" → "abbba" gives the smallest lexicographic palindrome.

// Example 3:
// Input: s = "daccad"
// Output: "acddca"
// Explanation:
// Rearranging "daccad" → "acddca" gives the smallest lexicographic palindrome.

public class SmallestPalindromicRearrangementI {
    public String smallestPalindrome(String s) {
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) freq[s.charAt(i) - 'a']++;

        StringBuilder left = new StringBuilder();
        char middle = 0;
        for (int idx = 0; idx < 26; idx++) {
            for (int i = 0; i < freq[idx] / 2; i++) left.append((char)('a' + idx));
            
            if ((freq[idx] & 1) == 1) middle = (char)('a' + idx);
        }

        StringBuilder ans = new StringBuilder();
        ans.append(left);

        if (middle != 0) ans.append(middle);
        
        ans.append(left.reverse());

        return ans.toString();
    }
}
