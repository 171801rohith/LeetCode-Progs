// 79. Word Search
// Given an m x n grid of characters board and a string word, return true if word exists in the grid.
// The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

// Example 1:
// Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
// Output: true

// Example 2:
// Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
// Output: true

// Example 3:
// Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
// Output: false
 

public class WordSearch {
    private boolean dfs(char[][] board, String word, int index, int i, int j) {

        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) return false;
        if (board[i][j] != word.charAt(index)) return false;
        if (index == word.length() - 1) return true;

        char temp = board[i][j];
        board[i][j] = '$';

        boolean found = dfs(board, word, index + 1, i - 1, j) ||
        dfs(board, word, index + 1, i + 1, j) ||
        dfs(board, word, index + 1, i, j - 1) ||
        dfs(board, word, index + 1, i, j + 1);

        board[i][j] = temp;

        return found;
    }

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) 
            for (int j = 0; j < board[i].length; j++) 
                if (board[i][j] == word.charAt(0) && dfs(board, word, 0, i, j))
                    return true;
        return false;
    }

}
