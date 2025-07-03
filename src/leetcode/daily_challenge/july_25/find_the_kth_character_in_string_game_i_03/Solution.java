package leetcode.daily_challenge.july_25.find_the_kth_character_in_string_game_i_03;

public class Solution {
    private char[] str;
    public Solution() {
        str = new char[512];
        str[0] = 'a';
        for(int i = 0; i < 9; i++) {
            int newLen = (int) Math.pow(2, i);
            for(int j = 0; j < newLen; j++) {
                str[newLen + j] = (char)((((int)(str[j] - 'a') + 1) % 26) + 'a');
            }
        }
    }
    public char kthCharacter(int k) {
        return str[k - 1];
    }
}
