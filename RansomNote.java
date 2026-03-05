// 383. Ransom Note
// Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.
// Each letter in magazine can only be used once in ransomNote.

// Example 1:
// Input: ransomNote = "a", magazine = "b"
// Output: false

// Example 2:
// Input: ransomNote = "aa", magazine = "ab"
// Output: false

// Example 3:
// Input: ransomNote = "aa", magazine = "aab"
// Output: true

import java.util.HashMap;

public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            if (!map.containsKey(magazine.charAt(i))) map.put(magazine.charAt(i), 1);
            else map.computeIfPresent(magazine.charAt(i), (k, v) -> v + 1);
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            char key = ransomNote.charAt(i);
            if (!map.containsKey(key)) return false;
            else if(map.get(key) > 0){
                map.computeIfPresent(key, (k, v) -> v - 1);
            } else return false;
        }
        return true;
    }
}
