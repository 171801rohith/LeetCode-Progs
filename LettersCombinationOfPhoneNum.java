// 17. Letter Combinations of a Phone Number
// Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
// A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

// Example 1:
// Input: digits = "23"
// Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

// Example 2:
// Input: digits = "2"
// Output: ["a","b","c"]
 

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LettersCombinationOfPhoneNum {
    Map<Integer, String> keyMap = Map.of(
                2, "abc",
                3, "def",
                4, "ghi",
                5, "jkl",
                6, "mno",
                7, "pqrs",
                8, "tuv",
                9, "wxyz");
    List<String> list = new ArrayList<>();

    private void backtrack(int idx, StringBuilder cur, String digits) {
        if (idx == digits.length()) {
            list.add(cur.toString());
            return;
        }

        String choices = keyMap.get(digits.charAt(idx) - '0');

        for (int i = 0; i < choices.length(); i++) {
            cur.append(choices.charAt(i));
            backtrack(idx + 1, cur, digits);
            cur.deleteCharAt(cur.length() - 1);
        }
    }

    public List<String> letterCombinations(String digits) {
        backtrack(0, new StringBuilder(), digits);
        return list;
    }
}
