// 994. Rotting Oranges
// You are given an m x n grid where each cell can have one of three values:
// 0 representing an empty cell,
// 1 representing a fresh orange, or
// 2 representing a rotten orange.
// Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
// Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

// Example 1:
// Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
// Output: 4

// Example 2:
// Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
// Output: -1
// Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.

// Example 3:
// Input: grid = [[0,2]]
// Output: 0
// Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    public int orangesRotting(int[][] grid) {
        int min = 0;
        
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[i].length; j++) 
                if (grid[i][j] == 2) q.offer(new int[] {i, j});
                else if (grid[i][j] == 1) fresh++;
        
        while (!q.isEmpty() && fresh > 0) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int[] coods = q.poll();
                int r = coods[0], c = coods[1];

                if (r > 0 && grid[r - 1][c] == 1) {
                    grid[r - 1][c] = 2;
                    fresh--;
                    q.offer(new int[] {r - 1, c});
                }
                if ( r < grid.length - 1  && grid[r + 1][c] == 1) {
                    grid[r + 1][c] = 2;
                    fresh--;
                    q.offer(new int[] {r + 1, c});
                }
                if (c > 0 &&grid[r][c - 1] == 1) {
                    grid[r][c - 1] = 2;
                    fresh--;
                    q.offer(new int[] {r, c - 1});
                }
                if (c < grid[0].length - 1 && grid[r][c + 1] == 1) {
                    grid[r][c + 1] = 2;
                    fresh--;
                    q.offer(new int[] {r, c + 1});
                }
            }
            min++;
        }
        
        if (fresh != 0) return -1;
        return min;   
    }
}
