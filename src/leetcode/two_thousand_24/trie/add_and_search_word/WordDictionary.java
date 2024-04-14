package leetcode.two_thousand_24.trie.add_and_search_word;

import java.util.HashMap;
import java.util.Map;

class TrieNode {
    public String str;
    public Map<Character, TrieNode> children = new HashMap<>();
    public boolean isWord;
};

public class WordDictionary {
    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
        root.str = "";
    }

    public void addWord(String word) {
        if (search(word)) {
            return;
        }
        char[] chars = word.toCharArray();
        TrieNode itr = root;
        for (char c : chars) {
            if (!itr.children.containsKey(c)) {
                TrieNode newNode = new TrieNode();
                newNode.str = itr.str + c;
                itr.children.put(c, newNode);
            }
            itr = itr.children.get(c);
        }
        itr.isWord = true;
    }

    public boolean search(String word) {
        char[] chars = word.toCharArray();
        TrieNode itr = root;
        for (char c : chars) {
            if (itr.children.containsKey(c) || c == '.') {
                itr = itr.children.get(c);
            } else if (itr.children.containsKey('.')) {
                itr = itr.children.get('.');
            } else {
                return false;
            }
        }
        return itr.isWord;
    }
}