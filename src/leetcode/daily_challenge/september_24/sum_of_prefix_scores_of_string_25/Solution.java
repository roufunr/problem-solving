package leetcode.daily_challenge.september_24.sum_of_prefix_scores_of_string_25;

class TrieNode {
    TrieNode[] next = new TrieNode[26];
    int count = 0;
}

public class Solution {
    TrieNode root = new TrieNode();

    void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.next[index] == null) {
                node.next[index] = new TrieNode();
            }
            node.next[index].count++;
            node = node.next[index];
        }
    }

    int countPrefix(String s) {
        TrieNode node = root;
        int total = 0;
        for (char c : s.toCharArray()) {
            int index = c - 'a';
            total += node.next[index].count;
            node = node.next[index];
        }
        return total;
    }

    public int[] sumPrefixScores(String[] words) {
        int N = words.length;
        for (int i = 0; i < N; i++) {
            insert(words[i]);
        }
        int[] scores = new int[N];
        for (int i = 0; i < N; i++) {
            scores[i] = countPrefix(words[i]);
        }
        return scores;
    }
}
