// 73. Set Matrix Zeroes
// Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
// You must do it in place.

// Example 1:
// Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
// Output: [[1,0,1],[0,0,0],[1,0,1]]

// Example 2:
// Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
// Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SetMatrixZero {
        public void setZeroes(int[][] matrix) {
        boolean[] rows = new boolean[matrix.length];
        boolean[] cols = new boolean[matrix[0].length];

        for(int i = 0; i < matrix.length; i++) 
            for(int j = 0; j < matrix[i].length; j++)
                if (matrix[i][j] == 0) {
                    rows[i] = true;
                    cols[j] = true;
                }
            
        for(int i = 0; i < matrix.length; i++) 
            for(int j = 0; j < matrix[i].length; j++)
                if (rows[i] || cols[j]) matrix[i][j] =  0;

    }   

    public void setZeroesLazy(int[][] matrix) {
        ArrayList<List<Integer>> zero_coords = new ArrayList<>(); 
        for(int i = 0; i < matrix.length; i++) 
            for(int j = 0; j < matrix[i].length; j++)
                if (matrix[i][j] == 0) zero_coords.add(Arrays.asList(i, j));
        
        int x, y;
        for (List<Integer> coord : zero_coords) {
            x = coord.get(0);
            y = coord.get(1);
            for(int i = 0; i < matrix.length; i++) 
                for(int j = 0; j < matrix[i].length; j++)
                    if (i == x || j == y) matrix[i][j] = 0;
        }
    }  
}
