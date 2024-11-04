package leetcode.daily_challenge.november_24.string_compression_iii_04;

public class Solution {
    public String compressedString(String word) {
        StringBuilder sb = new StringBuilder();
        char currentChar = ' ';
        int currentLen = 0;
        for(char c : word.toCharArray()) {
            if(currentChar == ' ') {
                currentChar = c;
                currentLen = 1;
                continue;
            }
            if(currentChar == c) {
                if(currentLen == 9) {
                    sb.append(currentLen + "" + currentChar);
                    currentLen = 1;
                } else {
                    currentLen++;
                }
            } else {
                sb.append(currentLen + "" + currentChar);
                currentLen = 1;
                currentChar = c;
            }
        }
        sb.append(currentLen + "" + currentChar);
        return sb.toString();
    }
}