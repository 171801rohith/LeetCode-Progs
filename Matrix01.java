// 542. 01 Matrix
// Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.
// The distance between two cells sharing a common edge is 1.

// Example 1:
// Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
// Output: [[0,0,0],[0,1,0],[0,0,0]]

// Example 2:
// Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
// Output: [[0,0,0],[0,1,0],[1,2,1]]

import java.util.LinkedList;
import java.util.Queue;

public class Matrix01 {
    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < mat.length; i++)
            for (int j = 0; j < mat[i].length; j++) 
                if (mat[i][j] == 0) q.offer(new int[] {i, j});
                else mat[i][j] = -1;
        
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int r = cell[0], c = cell[1];

            for (int[] d: dirs) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (
                    nr >= 0 && nr < mat.length &&
                    nc >= 0 && nc < mat[0].length &&
                    mat[nr][nc] == -1
                ) {
                    mat[nr][nc] = mat[r][c] + 1;
                    q.offer(new int[] {nr, nc});
                }
            }
        }
        return mat;
    }
}
