// 3174. Clear Digits
// You are given a string s.
// Your task is to remove all digits by doing this operation repeatedly:
// Delete the first digit and the closest non-digit character to its left.
// Return the resulting string after removing all digits.
// Note that the operation cannot be performed on a digit that does not have any non-digit character to its left.

// Example 1:
// Input: s = "abc"
// Output: "abc"
// Explanation:
// There is no digit in the string.

// Example 2:
// Input: s = "cb34"
// Output: ""
// Explanation:
// First, we apply the operation on s[2], and s becomes "c4".
// Then we apply the operation on s[1], and s becomes "".

public class ClearDigits {
    public boolean isAlpha(char c) {
        return c >= 'a' && c <= 'z';
    }

    public String clearDigits(String s) {

        boolean[] keep = new boolean[s.length()];
        int lc = -1; 

        for (int i = 0; i < s.length(); i++) {

            if (isAlpha(s.charAt(i))) {
                keep[i] = true;
                lc = i;
            } else {
                while (lc >= 0 && !keep[lc]) lc--;

                if (lc >= 0) keep[lc--] = false;
            }
        }

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < keep.length; i++) if (keep[i]) res.append(s.charAt(i));
        return res.toString();
    }
}
 