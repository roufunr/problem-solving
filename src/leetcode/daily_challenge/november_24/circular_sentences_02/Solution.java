package leetcode.daily_challenge.november_24.circular_sentences_02;

public class Solution {
    public boolean isCircularSentence(String sentence) {
        String[] words = sentence.split(" ");
        for(int i = 1; i < words.length; i++) {
            if(words[i-1].charAt(words[i-1].length() - 1) != words[i].charAt(0)) {
                return false;
            } 
        }
        if(words[words.length - 1].charAt(words[words.length - 1].length() - 1) != words[0].charAt(0)) {
            return false;
        }
        return true;
    }
}