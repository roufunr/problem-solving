package leetcode.two_thousand_24.trie.trie;

import java.util.HashMap;
import java.util.Map;

class TrieNode {
    public String str;
    public Map<Character, TrieNode> children = new HashMap<>();
    public boolean isWord;
};

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
        root.str = "";
    }

    public void insert(String word) {
        char[] cWord = word.toCharArray();
        TrieNode node = root;
        for (char c : cWord) {
            if (!node.children.containsKey(c)) {
                TrieNode newNode = new TrieNode();
                newNode.str = node.str + c;
                node.children.put(c, newNode);
            }
            node = node.children.get(c);
        }
        node.isWord = true;
    }

    public boolean search(String word) {
        char[] cWord = word.toCharArray();
        TrieNode node = root;
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
        TrieNode node = root;
        for (char c : cWord) {
            if (!node.children.containsKey(c)) {
                return false;
            }
            node = node.children.get(c);
        }
        return true;
    }
}
