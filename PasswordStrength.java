// 3941. Password Strength
// You are given a string password.
// The strength of the password is calculated based on the following rules:
// 1 point for each distinct lowercase letter ('a' to 'z').
// 2 points for each distinct uppercase letter ('A' to 'Z').
// 3 points for each distinct digit ('0' to '9').
// 5 points for each distinct special character from the set "!@#$".
// Each character contributes at most once, even if it appears multiple times.
// Return an integer denoting the strength of the password.

// Example 1:
// Input: password = "aA1!"
// Output: 11
// Explanation:
// The distinct characters are 'a', 'A', '1' and '!'.
// Thus, the strength = 1 + 2 + 3 + 5 = 11.

// Example 2:
// Input: password = "bbB11#"
// Output: 11
// Explanation:
// The distinct characters are 'b', 'B', '1' and '#'.
// Thus, the strength = 1 + 2 + 3 + 5 = 11.​​​​​​​
 

import java.util.HashSet;

public class PasswordStrength {
    private int getPoints(char ch) {
        if (Character.isLowerCase(ch)) return 1;
        if (Character.isUpperCase(ch)) return 2;
        if (Character.isDigit(ch)) return 3;
        if (ch == '!' || ch == '@' || ch == '#' || ch == '$') return 5;
        return 0;
    }

    public int passwordStrength(String password) {
        int strength = 0;
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            if (set.add(ch)) strength += getPoints(ch);
        }
        return strength;
    }
}
