// 1309. Decrypt String from Alphabet to Integer Mapping
// You are given a string s formed by digits and '#'. We want to map s to English lowercase characters as follows:
// Characters ('a' to 'i') are represented by ('1' to '9') respectively.
// Characters ('j' to 'z') are represented by ('10#' to '26#') respectively.
// Return the string formed after mapping.
// The test cases are generated so that a unique mapping will always exist.

// Example 1:
// Input: s = "10#11#12"
// Output: "jkab"
// Explanation: "j" -> "10#" , "k" -> "11#" , "a" -> "1" , "b" -> "2".

// Example 2:
// Input: s = "1326#"
// Output: "acz"

public class DecryptFromStr {
    public String freqAlphabets(String s) {
        StringBuilder str = new StringBuilder();
        int i = s.length() - 1;
        while (i >= 0) {
            char ch = s.charAt(i);
            if (ch == '#') {
                int num = Integer.parseInt(s.substring(i - 2, i));
                str.insert(0, (char) ('a' + num - 1));
                i -= 3;
            } else {
                int num = Integer.parseInt(String.valueOf(ch));
                str.insert(0, (char) ('a' + num - 1));
                i--;
            }
        }
        return str.toString();
    }
}
