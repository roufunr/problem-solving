package leetcode.two_thousand_24.recursion.word_search;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    private boolean ans;

    private void dfs(String target, int idx, int x, int y, char[][] board, Set<String> visited) {
        int rows = board.length;
        int cols = board[0].length;
        
        if (idx == target.length()) {
            ans = true;
            return;
        }

        if (x >= rows || x < 0 || y >= cols || y < 0 || board[x][y] != target.charAt(idx) || visited.contains(x + "_" + y)) {
            return;
        }
        
        visited.add(x + "_" + y);

        dfs(target, idx + 1, x + 1, y, board, visited);
        dfs(target, idx + 1, x - 1, y, board, visited);
        dfs(target, idx + 1, x, y + 1, board, visited);
        dfs(target, idx + 1, x, y - 1, board, visited);

        visited.remove(x + "_" + y);
    }

    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == word.charAt(0)) {
                    // call dfs from here
                    // if dfs return true then return this function as well
                    ans = false;
                    Set<String> visited = new HashSet<>();
                    dfs(word, 0, i, j, board, visited);
                    if (ans) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
