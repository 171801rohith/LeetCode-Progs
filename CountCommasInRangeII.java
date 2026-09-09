// 3871. Count Commas in Range II
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


public class CountCommasInRangeII {
    public long countCommas(long n) {
        long count = 0, start = 1000, commas = 1;
        while (start <= n) {
            long end = Math.min(n, start * 1000 - 1);
            count += (end - start + 1) * commas;
            start  *= 1000;
            commas++;
        }
        return count;
    }
}
