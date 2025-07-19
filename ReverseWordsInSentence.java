// 557. Reverse Words in a String III
// Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order. 

// Example 1:
// Input: s = "Let's take LeetCode contest"
// Output: "s'teL ekat edoCteeL tsetnoc"

// Example 2:
// Input: s = "Mr Ding"
// Output: "rM gniD"

public class ReverseWordsInSentence {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder reverseSentence = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            reverseSentence.append((new StringBuilder(words[i])).reverse());
            reverseSentence.append((i == words.length - 1) ? "" : " ");
        }
        return reverseSentence.toString();
    }
}
