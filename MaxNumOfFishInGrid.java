// 2658. Maximum Number of Fish in a Grid
// You are given a 0-indexed 2D matrix grid of size m x n, where (r, c) represents:
// A land cell if grid[r][c] = 0, or
// A water cell containing grid[r][c] fish, if grid[r][c] > 0.
// A fisher can start at any water cell (r, c) and can do the following operations any number of times:
// Catch all the fish at cell (r, c), or
// Move to any adjacent water cell.
// Return the maximum number of fish the fisher can catch if he chooses his starting cell optimally, or 0 if no water cell exists.
// An adjacent cell of the cell (r, c), is one of the cells (r, c + 1), (r, c - 1), (r + 1, c) or (r - 1, c) if it exists.

// Example 1:
// Input: grid = [[0,2,1,0],[4,0,0,3],[1,0,0,4],[0,3,2,0]]
// Output: 7
// Explanation: The fisher can start at cell (1,3) and collect 3 fish, then move to cell (2,3) and collect 4 fish.

// Example 2:
// Input: grid = [[1,0,0,0],[0,0,0,0],[0,0,0,0],[0,0,0,1]]
// Output: 1
// Explanation: The fisher can start at cells (0,0) or (3,3) and collect a single fish. 
 

public class MaxNumOfFishInGrid {
    private int dfs (int i, int j, int[][] grid) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) return 0;

        int curFish = grid[i][j];
        grid[i][j] = 0;

        int up = dfs(i - 1, j, grid);
        int down = dfs(i + 1, j, grid);
        int left = dfs(i, j - 1, grid);
        int right = dfs(i, j + 1, grid);

        return curFish + left + right + up + down;
    }

    public int findMaxFish(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[i].length; j++)
                if (grid[i][j] != 0) 
                    max =  Math.max(max, dfs(i, j, grid));

        return max;
    }
}
