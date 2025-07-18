// 1704. Determine if String Halves Are Alike
// You are given a string s of even length. Split this string into two halves of equal lengths, and let a be the first half and b be the second half.
// Two strings are alike if they have the same number of vowels ('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'). Notice that s contains uppercase and lowercase letters.
// Return true if a and b are alike. Otherwise, return false.

// Example 1:
// Input: s = "book"
// Output: true
// Explanation: a = "bo" and b = "ok". a has 1 vowel and b has 1 vowel. Therefore, they are alike.

// Example 2:
// Input: s = "textbook"
// Output: false
// Explanation: a = "text" and b = "book". a has 1 vowel whereas b has 2. Therefore, they are not alike.
// Notice that the vowel o is counted twice.


public class HalvesAreAlike {
    public boolean halvesAreAlike(String s) {
        StringBuilder a = new StringBuilder();
        StringBuilder b = new StringBuilder();
        String vowels = "aeiouAEIOU";

        for (int i = 0; i < s.length(); i++) {
            if (i < s.length() / 2)
                a.append(s.charAt(i));
            else
                b.append(s.charAt(i));
        }
        int countVowels = 0;
        for (int i = 0; i < a.length(); i++)
            if (vowels.contains(String.valueOf(a.charAt(i))))
                countVowels++;
        for (int i = 0; i < b.length(); i++)
            if (vowels.contains(String.valueOf(b.charAt(i))))
                countVowels--;

        return countVowels == 0 ? true : false;
    }
}
