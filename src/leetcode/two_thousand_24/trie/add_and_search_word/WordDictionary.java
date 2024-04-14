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

    public boolean searchRecursively(char[] word, int idx, TrieNode base) {
        if (base.children.size() == 0) {
            return idx == word.length;
        }

        TrieNode itr = base;
        if (itr.children.containsKey(word[idx])) {
            return searchRecursively(word, idx + 1, base.children.get(word[idx]));
        } else if (word[idx] == '.') {
            boolean result = itr.children.size() == 0;
            for (Map.Entry<Character, TrieNode> entry : itr.children.entrySet()) {
                result |= searchRecursively(word, idx + 1, entry.getValue());
            }
            return result;
        } else {
            return false;
        }
    }

    public boolean search(String word) {
        return searchRecursively(word.toCharArray(), 0, root);
    }
}