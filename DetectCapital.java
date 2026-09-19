// 520. Detect Capital
// We define the usage of capitals in a word to be right when one of the following cases holds:
// All letters in this word are capitals, like "USA".
// All letters in this word are not capitals, like "leetcode".
// Only the first letter in this word is capital, like "Google".
// Given a string word, return true if the usage of capitals in it is right.

// Example 1:
// Input: word = "USA"
// Output: true

// Example 2:
// Input: word = "FlaG"
// Output: false
 

public class DetectCapital {
    private boolean isAllLower(String s) {
        for (char c: s.toCharArray()) 
            if (c >= 'A' && c <= 'Z') return false;
        return true;
    }

    private boolean isAllUpper(String s) {
        for (char c: s.toCharArray()) 
            if (c >= 'a' && c <= 'z') return false;
        return true;
    }

    private boolean isCapitalized(String s) {
        char c = s.charAt(0); 
        if (c >= 'A' && c <= 'Z') 
            return isAllLower(s.substring(1));
        return false;
    }

    public boolean detectCapitalUse(String word) {
        return isAllLower(word) || isAllUpper(word) || isCapitalized(word);
    }
}
