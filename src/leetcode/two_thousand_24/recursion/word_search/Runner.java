package leetcode.two_thousand_24.recursion.word_search;

public class Runner {
    public static void main(String[] args) {
        char[][] array = {
                { 'A', 'B', 'C', 'E' },
                { 'S', 'F', 'C', 'S' },
                { 'A', 'D', 'E', 'E' }
        };
        String word = "ABCB";
        new Solution().exist(array, word);
    }
}