// 387. First Unique Character in a String
// Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.

// Example 1:
// Input: s = "leetcode"
// Output: 0
// Explanation:
// The character 'l' at index 0 is the first character that does not occur at any other index.

// Example 2:
// Input: s = "loveleetcode"
// Output: 2

// Example 3:
// Input: s = "aabb"
// Output: -1

import java.util.HashMap;

public class FirstUniqueChar {
    public int firstUniqChar(String s) {
        char[] letters = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : letters) {
            if (map.containsKey(ch)) {
                map.compute(ch, (key, value) -> value + 1);
            } else {
                map.put(ch, 1);
            }
        }

        for (int i = 0; i < letters.length; i++) {
            if (map.get(letters[i]) == 1)
                return i;
        }
        return -1;
    }
}
