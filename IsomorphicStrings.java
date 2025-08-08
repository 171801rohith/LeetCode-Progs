// 205. Isomorphic Strings
// Given two strings s and t, determine if they are isomorphic.
// Two strings s and t are isomorphic if the characters in s can be replaced to get t.
// All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.

// Example 1:
// Input: s = "egg", t = "add"
// Output: true
// Explanation:
// The strings s and t can be made identical by:
// Mapping 'e' to 'a'.
// Mapping 'g' to 'd'.

// Example 2:
// Input: s = "foo", t = "bar"
// Output: false
// Explanation:
// The strings s and t can not be made identical as 'o' needs to be mapped to both 'a' and 'r'.

// Example 3:
// Input: s = "paper", t = "title"
// Output: true

import java.util.Hashtable;

public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        Hashtable<Character, Character> map = new Hashtable<Character, Character>();
        for (int i = 0; i < s.length(); i++) {
            Character key = s.charAt(i);
            Character value = t.charAt(i);
            if (map.containsKey(key)) {
                if (map.get(key) != value)
                    return false;

            } else {
                if (map.containsValue(value))
                    return false;
                map.put(key, value);
            }
        }
        return true;
    }
}
