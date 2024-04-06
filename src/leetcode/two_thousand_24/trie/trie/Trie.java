package leetcode.two_thousand_24.trie.trie;

import java.util.HashMap;
import java.util.Map;



class TrieNode {
    public String str; 
    public Map<Character, TrieNode> children = new HashMap<>();
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
        for(char c : cWord) {
            if(!node.children.containsKey(c)) {
                TrieNode newNode = new TrieNode();
                newNode.str = node.str + c;
                node.children.put(c, newNode);
            }
            node = node.children.get(c);
        }
    }
    
    public boolean search(String word) {
        char[] cWord = word.toCharArray();
        TrieNode node = root;
        int i = 0;
        int wordLength = word.length();
        for(char c : cWord) {
            if(i < wordLength && !node.children.containsKey(c)) {
                return false;
            } else if(i == wordLength && node.children.size() == 0) {
                return true;
            }
            node = node.children.get(c);
            i++;
        }
        return false;
    }
    
    public boolean startsWith(String prefix) {
        char[] cWord = prefix.toCharArray();
        TrieNode node = root;
        int i = 0;
        int wordLength = prefix.length();
        for(char c : cWord) {
            if(!node.children.containsKey(c)) {
                return false;
            } else if(i == wordLength) {
                return true;
            }
            node = node.children.get(c);
            i++;
        }
        return false;
    }
}
