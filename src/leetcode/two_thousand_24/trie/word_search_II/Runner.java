package leetcode.two_thousand_24.trie.word_search_II;

public class Runner {
    public static void main(String[] args) {
        char[][] board = {
                { 'o', 'a', 'a', 'n' },
                { 'e', 't', 'a', 'e' },
                { 'i', 'h', 'k', 'r' },
                { 'i', 'f', 'l', 'v' }
        };

        String[] words = { "oath", "pea", "eat", "rain" };

        new Solution().findWords(board, words);
    }
}
