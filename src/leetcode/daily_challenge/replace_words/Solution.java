package leetcode.daily_challenge.replace_words;

import java.util.*;

class TrieNode {
    public Map<Character, TrieNode> children = new HashMap<>();
    public boolean isWord = false;
    public String word = "";
}

public class Solution {
    private TrieNode root;

    private void insert(String word) {
        TrieNode itrNode = root;
        char[] wc = word.toCharArray();
        for (char c : wc) {
            if (!itrNode.children.containsKey(c)) {
                TrieNode newNode = new TrieNode();
                newNode.word = itrNode.word + c;
                itrNode.children.put(c, newNode);
            }
            itrNode = itrNode.children.get(c);
        }
        itrNode.isWord = true;
    }

    private String getRoot(String word) {
        TrieNode itrNode = root;
        char[] cWord = word.toCharArray();
        for (char c : cWord) {
            if (itrNode.isWord) {
                return itrNode.word;
            } else {
                if (!itrNode.children.containsKey(c)) {
                    return word;
                } else {
                    itrNode = itrNode.children.get(c);
                }
            }
        }
        return word;
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        root = new TrieNode();
        for (String word : dictionary) {
            insert(word);
        }
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            words[i] = getRoot(words[i]);
        }
        StringBuffer newSentence = new StringBuffer();
        for (String word : words) {
            newSentence.append(word).append(" ");
        }
        String ans = newSentence.toString();
        ans = ans.length() > 0 ? ans.substring(0, ans.length() - 1) : ans;
        return ans.toString();
    }
}