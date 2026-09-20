// 395. Longest Substring with At Least K Repeating Characters
// Given a string s and an integer k, return the length of the longest substring of s such that the frequency of each character in this substring is greater than or equal to k.
// if no such substring exists, return 0.

// Example 1:
// Input: s = "aaabb", k = 3
// Output: 3
// Explanation: The longest substring is "aaa", as 'a' is repeated 3 times.

// Example 2:
// Input: s = "ababbc", k = 2
// Output: 5
// Explanation: The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
 

public class LongestSubstringWithAtleastKRepeatingChars {
    public int longestSubstring(String s, int k) {
        int max = 0;

        for (int tarUnique = 1; tarUnique <= 26; tarUnique++) {
            int[] freq = new int[26];
            int unique = 0, countAtleastK = 0;

            for (int r = 0, l = 0; r < s.length(); r++) {
                char c = s.charAt(r);
                freq[c - 'a']++;
                if (freq[c - 'a'] == 1) unique++;
                if (freq[c - 'a'] == k) countAtleastK++;

                while (unique > tarUnique) {
                    char ch = s.charAt(l);
                    freq[ch - 'a']--;
                    if (freq[ch - 'a'] == 0) unique--;
                    if (freq[ch - 'a'] == k - 1) countAtleastK--;
                    l++;
                }
                if (unique == tarUnique && countAtleastK == tarUnique) 
                    max = Math.max(max, r - l + 1);      
            }
        }

        return max;
    }
}
