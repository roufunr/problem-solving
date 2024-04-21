package leetcode.two_thousand_24.trie.palindrome_pairs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Node {
    public StringBuffer str = new StringBuffer();
    public Map<Character, Node> children = new HashMap<>();
    public boolean isWord;
}

public class Solution {
    private Node root;

    public Solution() {
        root = new Node();
        root.str.append("");

    }

    public void insert(String word) {
        char[] cWord = word.toCharArray();
        Node node = root;
        for (char c : cWord) {
            if (!node.children.containsKey(c)) {
                Node newNode = new Node();
                newNode.str.append(node.str).append(c);
                node.children.put(c, newNode);
            }
            node = node.children.get(c);
        }
        node.isWord = true;
    }

    public List<List<Integer>> palindromePairs(String[] words) {

        return null;
    }
}
