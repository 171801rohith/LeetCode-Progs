// 567. Permutation in String
// Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
// In other words, return true if one of s1's permutations is the substring of s2.

// Example 1:
// Input: s1 = "ab", s2 = "eidbaooo"
// Output: true
// Explanation: s2 contains one permutation of s1 ("ba").

// Example 2:
// Input: s1 = "ab", s2 = "eidboaoo"
// Output: false
 


import java.util.Arrays;

public class PermutationInStr {
    public boolean checkInclusion(String s1, String s2) {
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for (char c: s1.toCharArray()) freq1[c - 'a']++;

        for (int r = 0, l = 0; r < s2.length(); r++) {
            freq2[s2.charAt(r) - 'a']++;

            if ((r - l + 1) == s1.length()) {
                if (Arrays.equals(freq1, freq2)) return true;

                freq2[s2.charAt(l) - 'a']--;
                l++; 
            } 
        }
        return false;
    }
}
