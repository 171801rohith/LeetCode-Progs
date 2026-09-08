// 329. Longest Increasing Path in a Matrix
// Given an m x n integers matrix, return the length of the longest increasing path in matrix.
// From each cell, you can either move in four directions: left, right, up, or down. You may not move diagonally or move outside the boundary (i.e., wrap-around is not allowed).

// Example 1:
// Input: matrix = [[9,9,4],[6,6,8],[2,1,1]]
// Output: 4
// Explanation: The longest increasing path is [1, 2, 6, 9].

// Example 2:
// Input: matrix = [[3,4,5],[3,2,6],[2,2,1]]
// Output: 4
// Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.

// Example 3:
// Input: matrix = [[1]]
// Output: 1
 
public class LongestIncreasingPathInMat {
    private int dfs(int i, int j, int[][] mat, int m, int n, int[][] dp, int prev) {
        if (i < 0 || j < 0 || i >= m || j >= n) return 0;
        if (prev >= mat[i][j] || mat[i][j] == -1) return 0;

        if (dp[i][j] != 0) return dp[i][j];

        int temp = mat[i][j];
        mat[i][j] = -1;
        int lpath = dfs(i, j - 1, mat, m, n, dp, temp);
        int rpath = dfs(i, j + 1, mat, m, n, dp, temp);
        int upath = dfs(i + 1, j, mat, m, n, dp, temp);
        int dpath = dfs(i - 1, j, mat, m, n, dp, temp);
        mat[i][j] = temp;

        dp[i][j] = 1 + Math.max(Math.max(lpath, rpath), Math.max(upath, dpath));

        return dp[i][j];
    }

    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];

        int max = 0;
        for (int i = 0; i < m; i++) 
            for (int j = 0; j < n; j++)     
                max = Math.max(max, dfs(i, j, matrix, m, n, dp, Integer.MIN_VALUE));
        return max;
    }
}
