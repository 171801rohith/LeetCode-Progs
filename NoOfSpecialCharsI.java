// 3120. Count the Number of Special Characters I
// You are given a string word. A letter is called special if it appears both in lowercase and uppercase in word.
// Return the number of special letters in word.

// Example 1:
// Input: word = "aaAbcBC"
// Output: 3
// Explanation:
// The special characters in word are 'a', 'b', and 'c'.

// Example 2:
// Input: word = "abc"
// Output: 0
// Explanation:
// No character in word appears in uppercase.

// Example 3:
// Input: word = "abBCab"
// Output: 1
// Explanation:
// The only special character in word is 'b'.

 
public class NoOfSpecialCharsI {
        public int numberOfSpecialChars(String word) {
        boolean[] lowSeen = new boolean[26];
        boolean[] upSeen = new boolean[26];

        for (int i = 0; i < word.length(); i++) {
            int up = word.charAt(i) - 'A';
            int low = word.charAt(i) - 'a';

            if (up >= 0 && up <= 25) upSeen[up] = true;
            else lowSeen[low] = true;
        }

        int count = 0;
        for (int i = 0; i < 26; i++) if(lowSeen[i] && upSeen[i]) count++;

        return count; 
    }
}
