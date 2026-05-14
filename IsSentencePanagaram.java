// 1832. Check if the Sentence Is Pangram
// A pangram is a sentence where every letter of the English alphabet appears at least once.
// Given a string sentence containing only lowercase English letters, return true if sentence is a pangram, or false otherwise.

// Example 1:
// Input: sentence = "thequickbrownfoxjumpsoverthelazydog"
// Output: true
// Explanation: sentence contains at least one of every letter of the English alphabet.

// Example 2:
// Input: sentence = "leetcode"
// Output: false

public class IsSentencePanagaram {
    public boolean checkIfPangram(String sentence) {
        boolean[] letterSeen = new boolean[26];
        for (char ch: sentence.toCharArray()) letterSeen[ch - 'a'] = true;

        for (boolean isSeen: letterSeen) if (!isSeen) return false;
        
        return true;
    }
}