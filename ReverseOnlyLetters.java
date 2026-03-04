// 917. Reverse Only Letters
// Given a string s, reverse the string according to the following rules:
// All the characters that are not English letters remain in the same position.
// All the English letters (lowercase or uppercase) should be reversed.
// Return s after reversing it.

// Example 1:
// Input: s = "ab-cd"
// Output: "dc-ba"

// Example 2:
// Input: s = "a-bC-dEf-ghIj"
// Output: "j-Ih-gfE-dCba"

// Example 3:
// Input: s = "Test1ng-Leet=code-Q!"
// Output: "Qedo1ct-eeLg=ntse-T!"

public class ReverseOnlyLetters {
        public boolean isAlpha(char ch) {
        if (ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z') return true;
        return false;
    }

    public void swap(StringBuilder sb, int i, int j) {
        char temp = sb.charAt(i);
        sb.setCharAt(i, sb.charAt(j));
        sb.setCharAt(j, temp);
    }

    public String reverseOnlyLetters(String s) {
        StringBuilder sb = new StringBuilder(s);
        int left = 0, right = sb.length() - 1;
        while (left < right) {
            char lCh = sb.charAt(left);
            char rCh = sb.charAt(right);

            if (isAlpha(lCh) && isAlpha(rCh)) {
                swap(sb, left, right);
                left++; right--;
            } else if (!isAlpha(lCh) && isAlpha(rCh)) left++; 
            else if (isAlpha(lCh) && !isAlpha(rCh)) right--; 
            else {
                left++; right--;
            }
        }

        return sb.toString();
    }
}
