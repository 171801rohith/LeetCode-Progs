// 1576. Replace All ?'s to Avoid Consecutive Repeating Characters
// Given a string s containing only lowercase English letters and the '?' character, convert all the '?' characters into lowercase letters such that the final string does not contain any consecutive repeating characters. You cannot modify the non '?' characters.
// It is guaranteed that there are no consecutive repeating characters in the given string except for '?'.
// Return the final string after all the conversions (possibly zero) have been made. If there is more than one solution, return any of them. It can be shown that an answer is always possible with the given constraints.

// Example 1:
// Input: s = "?zs"
// Output: "azs"
// Explanation: There are 25 solutions for this problem. From "azs" to "yzs", all are valid. Only "z" is an invalid modification as the string will consist of consecutive repeating characters in "zzs".

// Example 2:
// Input: s = "ubv?w"
// Output: "ubvaw"
// Explanation: There are 24 solutions for this problem. Only "v" and "w" are invalid modifications as the strings will consist of consecutive repeating characters in "ubvvw" and "ubvww".


import java.util.Random;

public class ReplaceQuestionMark {
    public char chooseRandomLetter() {
        Random rand = new Random();
        return (char) ('a' + rand.nextInt(26));
    }
    public String modifyString(String s) {
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '?') {
                char prev = (i >= 1) ? sb.charAt(i - 1) : '0';
                char next = (i <= sb.length() - 2) ? sb.charAt(i + 1) : '0';
                char replace = chooseRandomLetter();
                while (next == replace || prev == replace) replace = chooseRandomLetter();
                sb.setCharAt(i, replace);
            }
        }
        return sb.toString();
    }
}
