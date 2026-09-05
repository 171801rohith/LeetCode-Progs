// 1155. Number of Dice Rolls With Target Sum
// You have n dice, and each dice has k faces numbered from 1 to k.
// Given three integers n, k, and target, return the number of possible ways (out of the kn total ways) to roll the dice, so the sum of the face-up numbers equals target. Since the answer may be too large, return it modulo 109 + 7.

// Example 1:
// Input: n = 1, k = 6, target = 3
// Output: 1
// Explanation: You throw one die with 6 faces.
// There is only one way to get a sum of 3.

// Example 2:
// Input: n = 2, k = 6, target = 7
// Output: 6
// Explanation: You throw two dice, each with 6 faces.
// There are 6 ways to get a sum of 7: 1+6, 2+5, 3+4, 4+3, 5+2, 6+1.

// Example 3:
// Input: n = 30, k = 30, target = 500
// Output: 222616187
// Explanation: The answer must be returned modulo 109 + 7.
 

import java.util.Arrays;

public class NoOfDiceRollsWithTargetSum {
    // static final int MOD = (int)(Math.pow(10, 9)) + 7;
    static final int MOD = 1_000_000_007;

    private int helper(int dLeft, int k, int rem, int[][] dp) {
        if (dLeft == 0) {
            if (rem == 0) return 1;
            return 0;
        }

        if (rem <= -1) return 0;
        if (dp[dLeft][rem] != -1) return dp[dLeft][rem];

        int ways = 0;
        for (int i = 1; i <= k; i++) {
            ways += helper(dLeft - 1, k, rem - i, dp);
            ways %= MOD;
        }
        dp[dLeft][rem] = ways;
        return ways;
    }

    public int numRollsToTarget(int n, int k, int target) {
        int[][] dp = new int[n + 1][target + 1]; 
        for (int[] row: dp) Arrays.fill(row, -1);

        return helper(n, k, target, dp);
    }
}
