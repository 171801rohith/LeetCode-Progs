// 242. Valid Anagram
// Given two strings s and t, return true if t is an anagram of s, and false otherwise.

// Example 1:
// Input: s = "anagram", t = "nagaram"
// Output: true

// Example 2:
// Input: s = "rat", t = "car"
// Output: false

import java.util.HashMap;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> set = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (!set.containsKey(s.charAt(i))) {
                set.put(s.charAt(i), 1);
            } else if (set.containsKey(s.charAt(i))) {
                set.computeIfPresent(s.charAt(i), (key, value) -> value + 1);
            }
        }
        // System.out.println(set);

        for (int i = 0; i < t.length(); i++) {
            if (!set.containsKey(t.charAt(i))) {
                return false;
            } else if (set.containsKey(t.charAt(i))) {
                set.computeIfPresent(t.charAt(i), (key, value) -> value - 1);
            }
        }
        // System.out.println(set);

        for (Character key : set.keySet()) {
            if (set.get(key) != 0)
                return false;
        }
        return true;
    }
}
