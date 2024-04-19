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

class Trie {
    private Node root;

    public Trie() {
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

    public boolean search(String word) {
        char[] cWord = word.toCharArray();
        Node node = root;
        for (char c : cWord) {
            if (!node.children.containsKey(c)) {
                return false;
            }
            node = node.children.get(c);
        }
        return word.equals(node.str) && node.isWord;
    }

    public boolean startsWith(String prefix) {
        char[] cWord = prefix.toCharArray();
        Node node = root;
        for (char c : cWord) {
            if (!node.children.containsKey(c)) {
                return false;
            }
            node = node.children.get(c);
        }
        return true;
    }
}

public class Solution {

    private void dfs(String prefix, int x, int y, char[][] board, Set<String> visited, Trie trie,
            Set<String> foundWords) {
        int rows = board.length;
        int cols = board[0].length;

        if (x >= rows || x < 0 || y >= cols || y < 0 || !trie.startsWith(prefix)
                || visited.contains(x + "_" + y)) {
            return;
        }

        prefix += board[x][y];

        if (trie.search(prefix)) {
            foundWords.add(prefix);
        }
        visited.add(x + "_" + y);

        dfs(prefix, x + 1, y, board, visited, trie, foundWords);
        dfs(prefix, x - 1, y, board, visited, trie, foundWords);
        dfs(prefix, x, y + 1, board, visited, trie, foundWords);
        dfs(prefix, x, y - 1, board, visited, trie, foundWords);

        visited.remove(x + "_" + y);
    }

    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        Set<String> foundWords = new HashSet<>();
        int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (trie.search("" + board[i][j])) {
                    String prefix = "";
                    Set<String> visited = new HashSet<>();
                    dfs(prefix, i, j, board, visited, trie, foundWords);
                }
            }
        }

        List<String> ans = new ArrayList<>();
        for (String word : foundWords) {
            ans.add(word);
        }
        return ans;

    }
}