// 76. Minimum Window Substring
// Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".
// The testcases will be generated such that the answer is unique.

// Example 1:
// Input: s = "ADOBECODEBANC", t = "ABC"
// Output: "BANC"
// Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.

// Example 2:
// Input: s = "a", t = "a"
// Output: "a"
// Explanation: The entire string s is the minimum window.

// Example 3:
// Input: s = "a", t = "aa"
// Output: ""
// Explanation: Both 'a's from t must be included in the window.
// Since the largest window of s only has one 'a', return empty string.
 

import java.util.HashMap;
import java.util.Map;

public class MinWindowSubstr {
    public String minWindow(String s, String t) {
        Map<Character, Integer> freqT = new HashMap<>();
        Map<Character, Integer> freqWin = new HashMap<>();

        for (char c: t.toCharArray()) freqT.put(c, freqT.getOrDefault(c, 0) + 1);

        int required = freqT.size(), formed = 0;
        int bestLen = Integer.MAX_VALUE, bestLeft = -1; 

        for (int r = 0, l = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            freqWin.put(c, freqWin.getOrDefault(c, 0) + 1);

            if (freqWin.get(c).equals(freqT.get(c))) formed++;

            while (formed == required) {
                int curLen = r - l + 1;
                if (curLen < bestLen) {
                    bestLen = curLen;
                    bestLeft = l;
                }

                char lc = s.charAt(l);
                freqWin.put(lc, freqWin.getOrDefault(lc, 0) - 1);
                l++;

                if (freqT.containsKey(lc) && freqWin.get(lc) < freqT.get(lc)) formed--;
            }
        }

        if (bestLeft == -1) return "";
        return s.substring(bestLeft, bestLeft + bestLen);
    }
}
