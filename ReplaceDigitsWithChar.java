// 1844. Replace All Digits with Characters
// You are given a 0-indexed string s that has lowercase English letters in its even indices and digits in its odd indices.
// You must perform an operation shift(c, x), where c is a character and x is a digit, that returns the xth character after c.
// For example, shift('a', 5) = 'f' and shift('x', 0) = 'x'.
// For every odd index i, you want to replace the digit s[i] with the result of the shift(s[i-1], s[i]) operation.
// Return s after replacing all digits. It is guaranteed that shift(s[i-1], s[i]) will never exceed 'z'.
// Note that shift(c, x) is not a preloaded function, but an operation to be implemented as part of the solution.

// Example 1:
// Input: s = "a1c1e1"
// Output: "abcdef"
// Explanation: The digits are replaced as follows:
// - s[1] -> shift('a',1) = 'b'
// - s[3] -> shift('c',1) = 'd'
// - s[5] -> shift('e',1) = 'f'

// Example 2:
// Input: s = "a1b2c3d4e"
// Output: "abbdcfdhe"
// Explanation: The digits are replaced as follows:
// - s[1] -> shift('a',1) = 'b'
// - s[3] -> shift('b',2) = 'd'
// - s[5] -> shift('c',3) = 'f'
// - s[7] -> shift('d',4) = 'h'

public class ReplaceDigitsWithChar {
    public String replaceDigits(String s) {
        char[] letters = s.toCharArray();
        for (int i = 1; i < letters.length; i += 2)
            letters[i] = (char)(letters[i - 1] + (letters[i] - '0'));
        return new String(letters);
    }

    public boolean isLetter(char ch) {
        if (ch >= 'a' && ch <= 'z') return true;
        return false;
    }
    public String replaceDigitsLazy(String s) {
        StringBuilder rd = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (isLetter(ch)) rd.append(ch);
            else {
                int digit = ch - '0';
                rd.append((char)(s.charAt(i - 1) + digit));
            }
        }
        return rd.toString();
    }
}