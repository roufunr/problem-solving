package leetcode.two_thousand_23.arrays_and_strings.reverse_words_in_a_string_III;

public class Solution {
    private String reverse(String word) {
        char[] chars = word.toCharArray();
        for(int i = 0; i < (chars.length / 2); i++) {
            char temp = chars[i];
            chars[i] = chars[chars.length - i - 1];
            chars[chars.length - i - 1] = temp;
        }
        return new String(chars);
    }
    public String reverseWords(String s) {
        s = s.trim();
        String[] words = s.split(" ");
        StringBuffer buffer = new StringBuffer();
        for(int i = 0; i < words.length; i++) {
            if(words[i].isEmpty()) {
                continue;
            }
            buffer.append(reverse(words[i])).append(" ");
        }
        return buffer.toString().trim();
    }
}
