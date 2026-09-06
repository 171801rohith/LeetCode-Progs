// 212. Word Search II
// Given an m x n board of characters and a list of strings words, return all words on the board.
// Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

// Example 1:
// Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
// Output: ["eat","oath"]

// Example 2:
// Input: board = [["a","b"],["c","d"]], words = ["abcb"]
// Output: []
 

import java.util.ArrayList;
import java.util.List;

class TrieWS {
    class TrieNode {
        TrieNode[] children;
        String word;

        TrieNode() {
            children = new TrieNode[26];
        }
    }

    TrieNode root;

    TrieWS() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode cur = root;

        for (char c: word.toCharArray()) {
            int idx = c - 'a';
            if (cur.children[idx] == null) cur.children[idx] = new TrieNode();
            cur = cur.children[idx]; 
        }
        cur.word = word;
    }
}

public class WordSearchII {
    public void dfs(int i, int j, char[][] board, TrieWS.TrieNode node, List<String> list) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) return;
        if (board[i][j] == '$') return;

        char c = board[i][j];
        int idx = c - 'a';

        if (node.children[idx] == null) return;

        node = node.children[idx];

        if (node.word != null) {
            list.add(node.word);
            node.word = null;
        }

        board[i][j] = '$';
        dfs(i, j - 1, board, node, list);
        dfs(i, j + 1, board, node, list);
        dfs(i - 1, j, board, node, list);
        dfs(i + 1, j, board, node, list);
        board[i][j] = c;
    }


    public List<String> findWords(char[][] board, String[] words) {
        TrieWS trie = new TrieWS();
        List<String> list = new ArrayList<>();
        for (String word: words) trie.insert(word);
        
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++)
                dfs(i, j, board, trie.root, list);
        return list;
    }
}
