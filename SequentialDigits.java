// 1291. Sequential Digits
// An integer has sequential digits if and only if each digit in the number is one more than the previous digit.
// Return a sorted list of all the integers in the range [low, high] inclusive that have sequential digits.

// Example 1:
// Input: low = 100, high = 300
// Output: [123,234]

// Example 2:
// Input: low = 1000, high = 13000
// Output: [1234,2345,3456,4567,5678,6789,12345]
 

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SequentialDigits {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> list = new ArrayList<>();
        String digits = "123456789";

        int lowLen = String.valueOf(low).length();
        int highLen = String.valueOf(high).length();

        for (int i = lowLen; i <= highLen; i++) {
            for (int j = 0; j <= 9 - i; j++) {
                int num = Integer.parseInt(digits.substring(j, j + i));
                if (num >= low && num <= high) list.add(num);
            }
        }

        return list;
    }

    public List<Integer> sequentialDigitsLazy(int low, int high) {
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= 9; i++) {
            int num = 0;
            for (int j = i; j <= 9; j++) {
                num = num * 10 + j;
                if (num >= low && num <= high) list.add(num);
                if (num > high) break;
            }
        }

        Collections.sort(list);
        return list;
    }
}
