package leetcode.two_thousand_24.trie.palindrome_pairs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TrieNode {
    public Map<Character, TrieNode> children = new HashMap<>();
    public int wordIdx = -1;
    List<Integer> palindromeIdxs = new ArrayList<>();
}

public class Solution {
    private TrieNode root;

    public Solution() {
        root = new TrieNode();
    }

    private boolean isPalindrome(String word, int fromIdx) {
        int left = fromIdx;
        int right = word.length() - 1;
        while (left <= right) {
            if (word.charAt(left) != word.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    private void insertInTrie(String word, int idx) {
        if (word.isEmpty() || "".equals(word)) {
            root.wordIdx = idx;
        }
        String reverseWord = new StringBuffer(word).reverse().toString();
        TrieNode itrNode = root;
        for (int i = 0; i < reverseWord.length(); i++) {
            if (isPalindrome(reverseWord, i)) {
                itrNode.palindromeIdxs.add(idx);
            }
            char c = reverseWord.charAt(i);
            if (!itrNode.children.containsKey(c)) {
                TrieNode newNode = new TrieNode();
                itrNode.children.put(c, newNode);
            }
            itrNode = itrNode.children.get(c);
        }
        itrNode.wordIdx = idx;
    }

    public List<List<Integer>> palindromePairs(String[] words) {
        for (int i = 0; i < words.length; i++) {
            insertInTrie(words[i], i);
        }

        List<List<Integer>> results = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            TrieNode itrNode = root;
            boolean isTrieBranchEqualOrGreater = false;
            for (int j = 0; j < words[i].length(); j++) {
                char c = words[i].charAt(j);
                if (!itrNode.children.containsKey(c)) {
                    if (isPalindrome(words[i], j)) {
                        results.add(Arrays.asList(itrNode.wordIdx, i));
                    }
                    break;
                }
                itrNode = itrNode.children.get(c);
                if (j == words[i].length() - 1 && itrNode.wordIdx == -1) {
                    isTrieBranchEqualOrGreater = true;
                }
            }

            if (itrNode.wordIdx > -1 && !isTrieBranchEqualOrGreater) {
                if (i != itrNode.wordIdx)
                    results.add(Arrays.asList(i, itrNode.wordIdx));
            }

            if (itrNode.palindromeIdxs.size() > 0) {
                for (int j = 0; j < itrNode.palindromeIdxs.size(); j++) {
                    if (i != itrNode.palindromeIdxs.get(j))
                        results.add(Arrays.asList(i, itrNode.palindromeIdxs.get(j)));
                }
            }
        }
        return results;
    }
}
