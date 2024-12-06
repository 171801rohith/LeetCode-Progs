// 125. Valid Palindrome
// A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
// Given a string s, return true if it is a palindrome, or false otherwise.

// Example 1:
// Input: s = "A man, a plan, a canal: Panama"
// Output: true
// Explanation: "amanaplanacanalpanama" is a palindrome.

// Example 2:
// Input: s = "race a car"
// Output: false
// Explanation: "raceacar" is not a palindrome.

// Example 3:
// Input: s = " "
// Output: true
// Explanation: s is an empty string "" after removing non-alphanumeric characters.
// Since an empty string reads the same forward and backward, it is a palindrome.

// Constraints:
// 1 <= s.length <= 2 * 105
// s consists only of printable ASCII characters.

public class ValidPalindrome {
    public boolean isAlphaNumeric(char c) {
        if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9')) {
            return true;
        }
        return false;
    }

    public boolean isPalindrome(String s) {
        String noSpecialChar = "";
        String revString = "";
        if (s == "") {
            return true;
        }
        for (int i = 0; i < s.length(); i++) {
            if (isAlphaNumeric(s.charAt(i))) {
                noSpecialChar += s.charAt(i);
            }
        }
        noSpecialChar = noSpecialChar.toLowerCase();
        for (int i = noSpecialChar.length() - 1; i >= 0; i--) {
            revString += noSpecialChar.charAt(i);
        }
        if (noSpecialChar.equals(revString)) {
            return true;
        }
        return false;
    }
}
