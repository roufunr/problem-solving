package leetcode.two_thousand_24.trie.word_search_II;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Node {
    public String str;
    public Map<Character, Node> children = new HashMap<>();
    public boolean isWord;
}

public class Solution {
    private Node root;

    public Solution() {
        root = new Node();
        root.str = "";
    }

    public void insert(String word) {
        char[] cWord = word.toCharArray();
        Node node = root;
        for (char c : cWord) {
            if (!node.children.containsKey(c)) {
                Node newNode = new Node();
                newNode.str = node.str + c;
                node.children.put(c, newNode);
            }
            node = node.children.get(c);
        }
        node.isWord = true;
    }

    private void dfs(int x, int y, char[][] board, Set<String> visited, Node trieNode,
            Set<String> foundWords) {
        int rows = board.length;
        int cols = board[0].length;

        if (x >= rows || x < 0 || y >= cols || y < 0 || !trieNode.children.containsKey(board[x][y])
                || visited.contains(x + "_" + y)) {
            return;
        }

        trieNode = trieNode.children.get(board[x][y]);

        if (trieNode.isWord) {
            foundWords.add(trieNode.str);
        }
        
        visited.add(x + "_" + y);

        dfs(x + 1, y, board, visited, trieNode, foundWords);
        dfs(x - 1, y, board, visited, trieNode, foundWords);
        dfs(x, y + 1, board, visited, trieNode, foundWords);
        dfs(x, y - 1, board, visited, trieNode, foundWords);

        visited.remove(x + "_" + y);
    }

    public List<String> findWords(char[][] board, String[] words) {
        for (String word : words) {
            insert(word);
        }
        Set<String> foundWords = new HashSet<>();
        int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Set<String> visited = new HashSet<>();
                dfs(i, j, board, visited, root, foundWords);
            }
        }

        List<String> ans = new ArrayList<>();
        for (String word : foundWords) {
            ans.add(word);
        }
        return ans;

    }
}