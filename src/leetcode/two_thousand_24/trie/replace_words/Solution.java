package leetcode.two_thousand_24.trie.replace_words;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TrieNode {
    public String str;
    public Map<Character, TrieNode> children = new HashMap<>();
    public boolean isWord;
};
public class Solution {
    private TrieNode root;

    public Solution() {
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

    public String startsWith(String prefix) {
        char[] cWord = prefix.toCharArray();
        TrieNode node = root;                        
        for (char c : cWord) {
            if (!node.children.containsKey(c)) {
                return "";
            }
            node = node.children.get(c);
        }
        return node.str;
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        
        for(String word: dictionary) {
            insert(word);
        }

        String[] wordStrings = sentence.split(" ");
        StringBuffer buffer = new StringBuffer();
        for(int i = 0; i < dictionary.size(); i++) {
            String prefixString = startsWith(dictionary.get(i));
            String word = "".equals(prefixString) ? dictionary.get(i) : prefixString;
            if(i < wordStrings.length - 1) {
               buffer.append(word).append(" ");
            } else {
               buffer.append(word);
            }
        }
        return buffer.toString();
    }
}