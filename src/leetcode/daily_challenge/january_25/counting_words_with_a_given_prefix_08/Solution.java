package leetcode.daily_challenge.january_25.counting_words_with_a_given_prefix_08;

public class Solution {
    public int prefixCount(String[] words, String pref) {
        int count = 0;
        for(String word : words) {
            if(word.startsWith(pref)) {
                count++;
            }
        }
        return count;
    }
}