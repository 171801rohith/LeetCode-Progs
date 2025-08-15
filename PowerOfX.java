// 231. Power of Two
// Given an integer n, return true if it is a power of two. Otherwise, return false.
// An integer n is a power of two, if there exists an integer x such that n == 2x.

// Example 1:
// Input: n = 1
// Output: true
// Explanation: 2^0 = 1

// Example 2:
// Input: n = 16
// Output: true
// Explanation: 2^4 = 16

// Example 3:
// Input: n = 3
// Output: false

// 342. Power of Four
// Given an integer n, return true if it is a power of four. Otherwise, return false.
// An integer n is a power of four, if there exists an integer x such that n == 4x.

// Example 1:
// Input: n = 16
// Output: true

// Example 2:
// Input: n = 5
// Output: false

// Example 3:
// Input: n = 1
// Output: true

public class PowerOfX {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0)
            return false;
        if ((n & (n - 1)) == 0)
            return true;
        return false;
    }

    public boolean isPowerOfFour(int n) {
        if (n <= 0)
            return false;
        int count = 0;
        while ((n & 1) == 0) {
            n >>= 1;
            count++;
        }
        System.out.println(count);
        return (n | 0) == 1 && (count & 1) != 1;
    }
}

// 00000001 - 1

// 00000100 - 4

// 00010000 - 16

// 01000000 - 64
