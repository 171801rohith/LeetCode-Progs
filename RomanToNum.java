
// Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

// Symbol       Value
// I             1
// V             5
// X             10
// L             50
// C             100
// D             500
// M             1000
// For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

// Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

// I can be placed before V (5) and X (10) to make 4 and 9. 
// X can be placed before L (50) and C (100) to make 40 and 90. 
// C can be placed before D (500) and M (1000) to make 400 and 900.
// Given a roman numeral, convert it to an integer.

// Example 1:

// Input: s = "III"
// Output: 3
// Explanation: III = 3.
// Example 2:

// Input: s = "LVIII"
// Output: 58
// Explanation: L = 50, V= 5, III = 3.
// Example 3:

// Input: s = "MCMXCIV"
// Output: 1994
// Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.

import java.util.ArrayList;

public class RomanToNum {
    public int romanToInt(String s) {
        int num = 0;

        ArrayList<String> grpS = new ArrayList<>();
        if (s.length() == 1) {
            String s2 = Character.toString(s.charAt(s.length() - 1));
            grpS.add(s2);
        } else {

            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i - 1) == 'I' && s.charAt(i) == 'V') {
                    grpS.add("IV");
                    i++;
                } else if (s.charAt(i - 1) == 'I' && s.charAt(i) == 'X') {
                    grpS.add("IX");
                    i++;
                } else if (s.charAt(i - 1) == 'X' && s.charAt(i) == 'L') {
                    grpS.add("XL");
                    i++;
                } else if (s.charAt(i - 1) == 'X' && s.charAt(i) == 'C') {
                    grpS.add("XC");
                    i++;
                } else if (s.charAt(i - 1) == 'C' && s.charAt(i) == 'D') {
                    grpS.add("CD");
                    i++;
                } else if (s.charAt(i - 1) == 'C' && s.charAt(i) == 'M') {
                    grpS.add("CM");
                    i++;
                } else {
                    String s1 = Character.toString(s.charAt(i - 1));
                    grpS.add(s1);
                }
                if (i == s.length() - 1) {
                    String s2 = Character.toString(s.charAt(i));
                    grpS.add(s2);
                }
            }

        }
        for (int i = 0; i < grpS.size(); i++) {
            switch (grpS.get(i)) {
                case "I":
                    num += 1;
                    break;
                case "V":
                    num += 5;
                    break;
                case "X":
                    num += 10;
                    break;
                case "L":
                    num += 50;
                    break;
                case "C":
                    num += 100;
                    break;
                case "D":
                    num += 500;
                    break;
                case "M":
                    num += 1000;
                    break;
                case "IV":
                    num += 4;
                    break;
                case "IX":
                    num += 9;
                    break;
                case "XL":
                    num += 40;
                    break;
                case "XC":
                    num += 90;
                    break;
                case "CD":
                    num += 400;
                    break;
                case "CM":
                    num += 900;
                    break;
            }
        }
        // System.out.println(grpS.get(grpS.size() - 1));
        return num;
    }
}
