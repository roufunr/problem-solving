package leetcode.daily_challenge.december_24.check_if_a_word_occurs_as_a_prefix_of_any_word_in_a_sentence_02;
public class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] words = sentence.split(" ");
        for(int i = 0; i < words.length; i++) {
            boolean found = true;
            for(int j = 0; j < searchWord.length(); j++) {
                if(j >= words[i].length()) {
                    found = false;
                    break;
                } else {
                    if(words[i].charAt(j) != searchWord.charAt(j)) {
                        found = false;
                        break;
                    }
                }
            }
            if(found) {
                return i + 1;
            }
        }
        return -1;
    }
}