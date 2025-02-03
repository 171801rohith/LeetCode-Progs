// 1945. Sum of Digits of String After Convert
// Hint
// You are given a string s consisting of lowercase English letters, and an integer k. Your task is to convert the string into an integer by a special process, and then transform it by summing its digits repeatedly k times. More specifically, perform the following steps:
// Convert s into an integer by replacing each letter with its position in the alphabet (i.e. replace 'a' with 1, 'b' with 2, ..., 'z' with 26).
// Transform the integer by replacing it with the sum of its digits.
// Repeat the transform operation (step 2) k times in total.

// For example, if s = "zbax" and k = 2, then the resulting integer would be 8 by the following operations:
// Convert: "zbax" ➝ "(26)(2)(1)(24)" ➝ "262124" ➝ 262124
// Transform #1: 262124 ➝ 2 + 6 + 2 + 1 + 2 + 4 ➝ 17
// Transform #2: 17 ➝ 1 + 7 ➝ 8
// Return the resulting integer after performing the operations described above.

// Example 1:
// Input: s = "iiii", k = 1
// Output: 36
// Explanation:
// The operations are as follows:
// - Convert: "iiii" ➝ "(9)(9)(9)(9)" ➝ "9999" ➝ 9999
// - Transform #1: 9999 ➝ 9 + 9 + 9 + 9 ➝ 36
// Thus the resulting integer is 36.

// Example 2:
// Input: s = "leetcode", k = 2
// Output: 6
// Explanation:
// The operations are as follows:
// - Convert: "leetcode" ➝ "(12)(5)(5)(20)(3)(15)(4)(5)" ➝ "12552031545" ➝ 12552031545
// - Transform #1: 12552031545 ➝ 1 + 2 + 5 + 5 + 2 + 0 + 3 + 1 + 5 + 4 + 5 ➝ 33
// - Transform #2: 33 ➝ 3 + 3 ➝ 6
// Thus the resulting integer is 6.

// Example 3:
// Input: s = "zbax", k = 2
// Output: 8

public class StringToNums {
    public int getLucky(String s, int k) {
        int j, i, c;
        int sum1 = 0;
        int sum2 = 0;
        int n, num, r, rem;
        int[] temp = new int[100];
        char[] str = new char[26];
        for (i = 0; i < 26; i++) {
            str[i] = (char) ('a' + i);
        }

        for (j = 0; j < s.length(); j++) {
            for (i = 0; i < 26; i++) {
                if (s.charAt(j) == str[i]) {
                    c = 0;
                    temp[c] = i + 1;
                    // System.out.println(temp[c]);
                    c++;
                }
            }
            for (i = 0; i < temp.length; i++) {
                num = temp[i];
                while (num > 0) {
                    rem = num % 10;
                    num = num / 10;
                    sum1 = sum1 + rem;
                }
            }
        }
        System.out.println("Transformation 1 :" + sum1);

        for (i = 1; i < k; i++) {
            n = sum1;
            while (n > 0) {
                r = n % 10;
                n = n / 10;
                sum2 = sum2 + r;
            }
            System.out.format("Transformation %d = %d", i + 1, sum2);
            sum1 = sum2;
            sum2 = 0;
            System.out.println();
        }
    return sum1;
    }
}
