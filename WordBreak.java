// 139. Word Break
// Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.
// Note that the same word in the dictionary may be reused multiple times in the segmentation.

// Example 1:
// Input: s = "leetcode", wordDict = ["leet","code"]
// Output: true
// Explanation: Return true because "leetcode" can be segmented as "leet code".

// Example 2:
// Input: s = "applepenapple", wordDict = ["apple","pen"]
// Output: true
// Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
// Note that you are allowed to reuse a dictionary word.

// Example 3:
// Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
// Output: false

import java.util.List;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Trie trie = new Trie();
        for (String str: wordDict) trie.insert(str);

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 0; i < s.length(); i++) {
            if (!dp[i]) continue;

            Trie.TrieNode cur = trie.root;

            for (int j = i; j < s.length(); j++) {
                int idx = s.charAt(j) - 'a';

                if (cur.children[idx] == null) break;

                cur = cur.children[idx];

                if (cur.isWord) dp[j + 1] = true;
            }
        }

        return dp[s.length()]; 
    }
}
