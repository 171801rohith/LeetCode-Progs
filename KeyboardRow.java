// 500. Keyboard Row
// Given an array of strings words, return the words that can be typed using letters of the alphabet on only one row of American keyboard like the image below.
// Note that the strings are case-insensitive, both lowercased and uppercased of the same letter are treated as if they are at the same row.
// In the American keyboard:
// the first row consists of the characters "qwertyuiop",
// the second row consists of the characters "asdfghjkl", and
// the third row consists of the characters "zxcvbnm".

// Example 1:
// Input: words = ["Hello","Alaska","Dad","Peace"]
// Output: ["Alaska","Dad"]
// Explanation:
// Both "a" and "A" are in the 2nd row of the American keyboard due to case insensitivity.

// Example 2:
// Input: words = ["omk"]
// Output: []

// Example 3:
// Input: words = ["adsdf","sfd"]
// Output: ["adsdf","sfd"]


public class KeyboardRow {
    private boolean typedInRow(String s, char[] c) {
        char curRow = c[Character.toLowerCase(s.charAt(0)) - 'a'];
            for (int i = 1; i < s.length(); i++)
                if (curRow != c[Character.toLowerCase(s.charAt(i)) - 'a']) return false;
        
        return true;
    }

    public String[] findWords(String[] words) {
        char[] c = new char[26];
        String r1 = "qwertyuiop";
        String r2 = "asdfghjkl";
        String r3 = "zxcvbnm";

        for (int i = 0; i < r1.length(); i++) c[r1.charAt(i) - 'a'] = '#'; 
        for (int i = 0; i < r2.length(); i++) c[r2.charAt(i) - 'a'] = '$'; 
        for (int i = 0; i < r3.length(); i++) c[r3.charAt(i) - 'a'] = '&'; 

        boolean[] inc = new boolean[words.length];
        int included = 0;

        for (int i = 0; i < words.length; i++) {
            if (typedInRow(words[i], c)) {
                inc[i] = true;
                included++;            
            }
        }

        String[] ans = new String[included];
        for (int i = 0, j = 0; i < inc.length; i++) 
            if (inc[i]) ans[j++] = words[i];
        
        return ans;
    }
}
