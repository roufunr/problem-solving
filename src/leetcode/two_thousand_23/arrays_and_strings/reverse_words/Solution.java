package leetcode.two_thousand_23.arrays_and_strings.reverse_words;

public class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        String[] words = s.split(" ");
        StringBuffer buffer = new StringBuffer();
        s = "";
        for(int i = 0; i < (words.length/2); i++) {
            String temp = words[i];
            words[i] = words[words.length - i - 1];
            words[words.length - i - 1] = temp;
        }
        for(String word : words) {
            if(word.isEmpty()) {
                continue;
            }
            buffer.append(word).append(" ");
        }
        return buffer.toString().trim();
    }
}
