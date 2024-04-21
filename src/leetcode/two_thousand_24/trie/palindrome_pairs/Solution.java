package leetcode.two_thousand_24.trie.palindrome_pairs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Node {
    public StringBuffer str = new StringBuffer();
    public Map<Character, Node> children = new HashMap<>();
    public int wordIdx = -1;
}

public class Solution {
    private Node root;

    public Solution() {
        root = new Node();
        root.str.append("");
    }

    private void insert(String word, int idx) {
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
        node.wordIdx = idx;
    }

    private int matchWithSuffix(String suffix, int suffixIdx) {
        char[] suffixCharArray = suffix.toCharArray();
        Node itrNode = root;
        for (int i = suffixCharArray.length - 1; i >= 0; i--) {
            if (itrNode.wordIdx > -1 && suffixIdx != itrNode.wordIdx) {
                return itrNode.wordIdx;
            }
            if (!itrNode.children.containsKey(suffixCharArray[i])) {
                return -1;
            }
            itrNode = itrNode.children.get(suffixCharArray[i]);
        }

        if (itrNode.wordIdx > -1 && suffixIdx != itrNode.wordIdx) {
            return itrNode.wordIdx;
        } else {
            return -1;
        }
    }

    public List<List<Integer>> palindromePairs(String[] words) {
        for (int i = 0; i < words.length; i++) {
            insert(words[i], i);
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            int fromIdx = matchWithSuffix(words[i], i);
            if (fromIdx > -1) {
                List<Integer> pair = new ArrayList<>();
                pair.add(fromIdx);
                pair.add(i);
                ans.add(pair);
            }
        }
        return ans;
    }
}
