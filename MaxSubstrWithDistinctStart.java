// 3760. Maximum Substrings With Distinct Start
// You are given a string s consisting of lowercase English letters.
// Return an integer denoting the maximum number of substrings you can split s into such that each substring starts with a distinct character (i.e., no two substrings start with the same character).

// Example 1:
// Input: s = "abab"
// Output: 2
// Explanation:
// Split "abab" into "a" and "bab".
// Each substring starts with a distinct character i.e 'a' and 'b'. Thus, the answer is 2.

// Example 2:
// Input: s = "abcd"
// Output: 4
// Explanation:
// Split "abcd" into "a", "b", "c", and "d".
// Each substring starts with a distinct character. Thus, the answer is 4.

// Example 3:
// Input: s = "aaaa"
// Output: 1
// Explanation:
// All characters in "aaaa" are 'a'.
// Only one substring can start with 'a'. Thus, the answer is 1.

import java.util.HashSet;
import java.util.Set;

public class MaxSubstrWithDistinctStart {
    public int maxDistinct(String s) {
        boolean[] lettersSeen = new boolean[26];
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';

            if (!lettersSeen[idx]) {
                lettersSeen[idx] = true;
                count++;
            }
        }
        return count;
    }

    public int maxDistinctLazy(String s) {
        Set<Character> starts = new HashSet<Character>();
        for (int i = 0; i < s.length(); i++) {
            starts.add(s.charAt(i));
        }
        return starts.size();
    }
}