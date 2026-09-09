// 3870. Count Commas in Range
// You are given an integer n.
// Return the total number of commas used when writing all integers from [1, n] (inclusive) in standard number formatting.
// In standard formatting:
// A comma is inserted after every three digits from the right.
// Numbers with fewer than 4 digits contain no commas.

// Example 1:
// Input: n = 1002
// Output: 3
// Explanation:
// The numbers "1,000", "1,001", and "1,002" each contain one comma, giving a total of 3.

// Example 2:
// Input: n = 998
// Output: 0
// Explanation:
// All numbers from 1 to 998 have fewer than four digits. Therefore, no commas are used.



public class CountCommasInRange {
    public int countCommas(int n) {
        if (n <= 999) return 0;
        int count = 0;

        if (n >= 1000) count += Math.min(n, 999999) - 1000 + 1;
        if (n >= 1000000) count += (Math.min(n, 999999999) - 1000000 + 1) * 2;
        if (n >= 1000000000) count += (n - 1000000000 + 1) * 3;
    
        return count;
    }

    public int countCommaslazy(int n) {
        if (n <= 999) return 0;
        int count = 0;
        for (int i = 1000; i <= n; i++){
            int digits = String.valueOf(i).length();
            count += (digits - 1) / 3;
        }
        return count;
    }
}
