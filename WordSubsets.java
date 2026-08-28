// 916. Word Subsets
// You are given two string arrays words1 and words2.
// A string b is a subset of string a if every letter in b occurs in a including multiplicity.
// For example, "wrr" is a subset of "warrior" but is not a subset of "world".
// A string a from words1 is universal if for every string b in words2, b is a subset of a.
// Return an array of all the universal strings in words1. You may return the answer in any order.

// Example 1:
// Input: words1 = ["amazon","apple","facebook","google","leetcode"], words2 = ["e","o"]
// Output: ["facebook","google","leetcode"]

// Example 2:
// Input: words1 = ["amazon","apple","facebook","google","leetcode"], words2 = ["lc","eo"]
// Output: ["leetcode"]

// Example 3:
// Input: words1 = ["acaac","cccbb","aacbb","caacc","bcbbb"], words2 = ["c","cc","b"]
// Output: ["cccbb"]


import java.util.ArrayList;
import java.util.List;

public class WordSubsets {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] reqFreq = new int[26];

        for (String word: words2) {
            int[] freq = new int[26];
            for (char c: word.toCharArray()) freq[c - 'a']++;

            for (int i = 0; i < 26; i++) reqFreq[i] = Math.max(reqFreq[i], freq[i]); 
        }

        List<String> list = new ArrayList<>();

        for (String word: words1) {
            int[] freq = new int[26];
            for (char c: word.toCharArray()) freq[c - 'a']++;

            boolean isUniversal = true;
            
            for (int i = 0; i < 26; i++) 
                if (freq[i] < reqFreq[i]) {
                    isUniversal = false;
                    break;
                } 

            if (isUniversal) list.add(word);
        }

        return list;
    }
}
