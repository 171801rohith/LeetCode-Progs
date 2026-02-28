// 345. Reverse Vowels of a String
// Given a string s, reverse only all the vowels in the string and return it.
// The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.

// Example 1:
// Input: s = "IceCreAm"
// Output: "AceCreIm"
// Explanation:
// The vowels in s are ['I', 'e', 'e', 'A']. On reversing the vowels, s becomes "AceCreIm".

// Example 2:
// Input: s = "leetcode"
// Output: "leotcede"


public class ReverseVowelsInStr {
        private boolean isVowel(char ch) {
        if ((ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o'
            || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I'
            || ch == 'O' || ch == 'U')) return true;
        return false;
    }

    private void swap(StringBuilder sb, int i, int j) {
        char temp = sb.charAt(i);
        sb.setCharAt(i, sb.charAt(j));
        sb.setCharAt(j, temp);
    }

    public String reverseVowels(String s) {
        StringBuilder sb = new StringBuilder(s);
        int left = 0, right =  sb.length() - 1;

        while (left < right) {
            boolean lVowel = isVowel(sb.charAt(left));
            boolean rVowel = isVowel(sb.charAt(right));

            if (lVowel && rVowel) {
                swap(sb, left, right);
                left++; right--;
            }
            else if (lVowel && !rVowel) right--;
            else if (!lVowel && rVowel) left++;
            else {
                left++; right--;
            }
        }

        return sb.toString();
    }
}
