// 709. To Lower Case
// Given a string s, return the string after replacing every uppercase letter with the same lowercase letter.

// Example 1:
// Input: s = "Hello"
// Output: "hello"

// Example 2:
// Input: s = "here"
// Output: "here"

// Example 3:
// Input: s = "LOVELY"
// Output: "lovely"

public class ToLowercase {
    public boolean isUpperCase(char ch) {
        if (ch >= 'A' && ch <= 'Z')
            return true;
        return false;
    }

    public String toLowerCase(String s) {
        // return s.toLowerCase();
        // or

        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < sb.length(); i++) {
            char ch = sb.charAt(i);
            if (isUpperCase(ch))
                sb.setCharAt(i, (char) (ch + 32));
        }
        return sb.toString();
    }
}
