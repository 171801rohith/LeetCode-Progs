// 289. Game of Life
// According to Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."
// The board is made up of an m x n grid of cells, where each cell has an initial state: live (represented by a 1) or dead (represented by a 0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):
// Any live cell with fewer than two live neighbors dies as if caused by under-population.
// Any live cell with two or three live neighbors lives on to the next generation.
// Any live cell with more than three live neighbors dies, as if by over-population.
// Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
// The next state of the board is determined by applying the above rules simultaneously to every cell in the current state of the m x n grid board. In this process, births and deaths occur simultaneously.
// Given the current state of the board, update the board to reflect its next state.
// Note that you do not need to return anything.

// Example 1:
// Input: board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
// Output: [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]

// Example 2:
// Input: board = [[1,1],[1,0]]
// Output: [[1,1],[1,1]]

public class GameOfLife {
private int getState (int i, int j, int[][] a) {
        if (i < 0 || j < 0 || i >= a.length || j >= a[0].length) return 0;
        return a[i][j];
    }

    private boolean isDeadOrLive(int i, int j, int[][] a) {
        int curState = a[i][j];

        int countLiveNeighbours = (
            getState(i, j - 1, a) +
            getState(i, j + 1, a) +
            getState(i - 1, j, a) +
            getState(i + 1, j, a) +
            getState(i - 1, j - 1, a) +
            getState(i - 1, j + 1, a) +
            getState(i + 1, j - 1, a) +
            getState(i + 1, j + 1, a) 
        );
        
        if (curState == 1 && (countLiveNeighbours < 2 || countLiveNeighbours > 3)) return false;
        if (curState == 0 && countLiveNeighbours == 3) return true;
        if (curState == 1 && (countLiveNeighbours == 2 || countLiveNeighbours == 3)) return true;
        return false;
    }

    public void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;
        int[][] copy = new int[m][n];

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                copy[i][j] = board[i][j];

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (isDeadOrLive(i, j, copy))
                    board[i][j] = 1;
                else
                    board[i][j] = 0;
    }
}