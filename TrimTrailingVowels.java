// 3856. Trim Trailing Vowels
// You are given a string s that consists of lowercase English letters.
// Return the string obtained by removing all trailing vowels from s.
// The vowels consist of the characters 'a', 'e', 'i', 'o', and 'u'.

// Example 1:
// Input: s = "idea"
// Output: "id"
// Explanation:
// Removing "idea", we obtain the string "id".

// Example 2:
// Input: s = "day"
// Output: "day"
// Explanation:
// There are no trailing vowels in the string "day".

// Example 3:
// Input: s = "aeiou"
// Output: ""
// Explanation:
// Removing "aeiou", we obtain the string "".

public class TrimTrailingVowels {
    public boolean isVowel(char ch) {
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') return true;
        return false;
    }

    public String trimTrailingVowels(String s) {
        int idx = -1;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (!isVowel(s.charAt(i))) {
                idx = i;
                break;
            }
        }

        return s.substring(0, idx + 1);
    }
}
