// 2325. Decode the Message
// You are given the strings key and message, which represent a cipher key and a secret message, respectively. The steps to decode message are as follows:
// Use the first appearance of all 26 lowercase English letters in key as the order of the substitution table.
// Align the substitution table with the regular English alphabet.
// Each letter in message is then substituted using the table.
// Spaces ' ' are transformed to themselves.
// For example, given key = "happy boy" (actual key would have at least one instance of each letter in the alphabet), we have the partial substitution table of ('h' -> 'a', 'a' -> 'b', 'p' -> 'c', 'y' -> 'd', 'b' -> 'e', 'o' -> 'f').
// Return the decoded message.

// Example 1:
// Input: key = "the quick brown fox jumps over the lazy dog", message = "vkbs bs t suepuv"
// Output: "this is a secret"
// Explanation: The diagram above shows the substitution table.
// It is obtained by taking the first appearance of each letter in "the quick brown fox jumps over the lazy dog".

// Example 2:
// Input: key = "eljuxhpwnyrdgtqkviszcfmabo", message = "zwx hnfx lqantp mnoeius ycgk vcnjrdb"
// Output: "the five boxing wizards jump quickly"
// Explanation: The diagram above shows the substitution table.
// It is obtained by taking the first appearance of each letter in "eljuxhpwnyrdgtqkviszcfmabo".

import java.util.HashMap;
import java.util.LinkedHashMap;

public class DecodeMsg {
public String decodeMessage(String key, String message) {
        boolean[] seen = new boolean[26];
        HashMap<Character, Character> map = new LinkedHashMap<>();
        for (int i = 0, j = 0; i < 26 && j < key.length(); j++) {
            char ch = key.charAt(j);
            if (ch == ' ') map.put(' ', ' ');
            else if (!seen[ch - 'a']) {
                seen[ch - 'a'] = true;
                map.put(ch, (char)('a' + i++));
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char ch: message.toCharArray()) {
            if (ch == ' ') sb.append(ch);
            else sb.append(map.get(ch));
        }
        
        return sb.toString();
    }
}
