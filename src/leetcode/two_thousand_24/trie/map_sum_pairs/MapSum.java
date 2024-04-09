package leetcode.two_thousand_24.trie.map_sum_pairs;

import java.util.HashMap;
import java.util.Map;

class TrieNode {
    public String str;
    public Map<Character, TrieNode> children = new HashMap<>();
    public boolean isWord;
    public int val;
};

public class MapSum {
    private TrieNode root;

    public MapSum() {
        root = new TrieNode();
        root.str = "";
    }

    public void insert(String key, int val) {
        char[] charArr = key.toCharArray();
        TrieNode itrNode = root;
        for (char c : charArr) {
            if (!itrNode.children.containsKey(c)) {
                TrieNode newNode = new TrieNode();
                newNode.str = itrNode.str + c;
                itrNode.children.put(c, newNode);
            }
            itrNode = itrNode.children.get(c);
        }
        itrNode.isWord = true;
        itrNode.val = val;
    }

    private int recSum(TrieNode node) {
        if (node.isWord && node.children.size() == 0) {
            return node.val;
        }

        int sum = node.isWord ? node.val : 0;
        for (Map.Entry<Character, TrieNode> entry : node.children.entrySet()) {
            sum += recSum(entry.getValue());
        }

        return sum;
    }

    public int sum(String prefix) {
        char[] charArr = prefix.toCharArray();
        TrieNode itrNode = root;
        for (char c : charArr) {
            if (!itrNode.children.containsKey(c)) {
                return 0;
            }
            itrNode = itrNode.children.get(c);
        }

        return recSum(itrNode);
    }
}
