// 720. Longest Word in Dictionary
// Given an array of strings words representing an English Dictionary, return the longest word in words that can be built one character at a time by other words in words.
// If there is more than one possible answer, return the longest word with the smallest lexicographical order. If there is no answer, return the empty string.
// Note that the word should be built from left to right with each additional character being added to the end of a previous word. 

// Example 1:
// Input: words = ["w","wo","wor","worl","world"]
// Output: "world"
// Explanation: The word "world" can be built one character at a time by "w", "wo", "wor", and "worl".

// Example 2:
// Input: words = ["a","banana","app","appl","ap","apply","apple"]
// Output: "apple"
// Explanation: Both "apply" and "apple" can be built from other words in the dictionary. However, "apple" is lexicographically smaller than "apply".
 

import java.util.Arrays;

public class LongestWordInDictionary {
        class Trie {
        class TrieNode {
            TrieNode[] children;
            boolean isWord;

            TrieNode() {
                children = new TrieNode[26];
                isWord = false; 
            }
        }

        TrieNode root = new TrieNode();

        public void insert(String word) {
            TrieNode cur = root;
            for (char c: word.toCharArray()) {
                int idx = c - 'a';
                if (cur.children[idx] == null) cur.children[idx] = new TrieNode();
                cur = cur.children[idx];
            }
            cur.isWord = true;
        }

        public boolean isBuildable(String word) {
            TrieNode cur = root;
            for (char c: word.toCharArray()) {
                int idx = c - 'a';
                if (!cur.children[idx].isWord) return false;
                cur = cur.children[idx];
            }
            return true;
        }
    }

    public String longestWord(String[] words) {
        Arrays.sort(words);
        Trie trie = new Trie();
        for (String str: words) trie.insert(str);

        int idx = -1, max = Integer.MIN_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (trie.isBuildable(words[i])) 
                if (words[i].length() > max) {
                    max = words[i].length();
                    idx = i;
                }
        }

        return idx == -1 ? "" :words[idx];
    }
}
