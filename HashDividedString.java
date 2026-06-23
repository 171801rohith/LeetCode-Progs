// 3271. Hash Divided String
// You are given a string s of length n and an integer k, where n is a multiple of k. Your task is to hash the string s into a new string called result, which has a length of n / k.
// First, divide s into n / k substrings, each with a length of k. Then, initialize result as an empty string.
// For each substring in order from the beginning:
// The hash value of a character is the index of that character in the English alphabet (e.g., 'a' → 0, 'b' → 1, ..., 'z' → 25).
// Calculate the sum of all the hash values of the characters in the substring.
// Find the remainder of this sum when divided by 26, which is called hashedChar.
// Identify the character in the English lowercase alphabet that corresponds to hashedChar.
// Append that character to the end of result.
// Return result.

// Example 1:
// Input: s = "abcd", k = 2
// Output: "bf"
// Explanation:
// First substring: "ab", 0 + 1 = 1, 1 % 26 = 1, result[0] = 'b'.
// Second substring: "cd", 2 + 3 = 5, 5 % 26 = 5, result[1] = 'f'.

// Example 2:
// Input: s = "mxz", k = 3
// Output: "i"
// Explanation:
// The only substring: "mxz", 12 + 23 + 25 = 60, 60 % 26 = 8, result[0] = 'i'.

public class HashDividedString {
    public String stringHash(String s, int k) {
        StringBuilder sb = new StringBuilder();
        char[] letters = s.toCharArray();

        for (int i = 0, j = 0; i < letters.length / k; i++, j += k) {
            int sum = 0;
            for (int z = j; z < j + k; z++) {
                sum += (letters[z] - 'a');
            }
            sb.append((char)('a' + (sum % 26)));
        }

        return sb.toString();
    }

    public String stringHashLazy(String s, int k) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0, j = 0; i < s.length() / k; i++, j += k) {
            String str = s.substring(j, j + k);
            int sum = 0;
            for (char ch: str.toCharArray()) {
                sum += (ch - 'a');
            }
            sb.append((char)('a' + (sum % 26)));
        }

        return sb.toString();
    }
}