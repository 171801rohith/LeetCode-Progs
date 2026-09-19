// 438. Find All Anagrams in a String
// Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.

// Example 1:
// Input: s = "cbaebabacd", p = "abc"
// Output: [0,6]
// Explanation:
// The substring with start index = 0 is "cba", which is an anagram of "abc".
// The substring with start index = 6 is "bac", which is an anagram of "abc".

// Example 2:
// Input: s = "abab", p = "ab"
// Output: [0,1,2]
// Explanation:
// The substring with start index = 0 is "ab", which is an anagram of "ab".
// The substring with start index = 1 is "ba", which is an anagram of "ab".
// The substring with start index = 2 is "ab", which is an anagram of "ab".
 

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsInStr {
    private boolean isAnagram(int[] pfreq, int[] curfreq) {
        for (int i = 0; i < 26; i++) 
            if (pfreq[i] != curfreq[i]) return false;
        return true;
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int[] pfreq = new int[26];
        int[] curfreq = new int[26];

        for (char c: p.toCharArray()) pfreq[c - 'a']++;

        for (int r = 0, l = 0; r < s.length(); r++) {
            char cur = s.charAt(r);
            curfreq[cur - 'a']++;
            if (r - l + 1 == p.length()) {
                if(isAnagram(pfreq, curfreq)) list.add(l);

                char c = s.charAt(l);
                curfreq[c - 'a']--;
                l++;
            }
        }

        return list;
    }
}
