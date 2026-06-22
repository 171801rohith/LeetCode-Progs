// 1941. Check if All Characters Have Equal Number of Occurrences
// Given a string s, return true if s is a good string, or false otherwise.
// A string s is good if all the characters that appear in s have the same number of occurrences (i.e., the same frequency).

// Example 1:
// Input: s = "abacbc"
// Output: true
// Explanation: The characters that appear in s are 'a', 'b', and 'c'. All characters occur 2 times in s.

// Example 2:
// Input: s = "aaabb"
// Output: false
// Explanation: The characters that appear in s are 'a' and 'b'.
// 'a' occurs 3 times while 'b' occurs 2 times, which is not the same number of times.

import java.util.HashMap;
import java.util.Map;

public class EqualNoOfOccurancesInStr {
    public boolean areOccurrencesEqual(String s) {
        char[] freq = new char[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            freq[c - 'a']++;
        }
        int count = freq[s.charAt(0) - 'a'];
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] == 0) continue;
            else if (count != freq[i]) return false;
        }
        return true;
    }

    public boolean areOccurrencesEqualLazy(String s) {
        HashMap<Character, Integer> freq = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        int count = freq.get(s.charAt(0));
        for (Map.Entry<Character, Integer> entry: freq.entrySet()) 
            if (entry.getValue() != count) return false;
        
        return true;
    }
}