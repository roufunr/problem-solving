package leetcode.daily_challenge.july_25.find_the_original_typed_string_i_01;

public class Solution {
    public int possibleStringCount(String word) {
        int ans = 0;
        char prevChar = word.charAt(0);
        int count = 1;
        for(int i = 1; i < word.length(); i++) {
            if(prevChar != word.charAt(i)) {
                ans += count - 1;
                count = 1;
                prevChar = word.charAt(i);
                continue;
            }
            prevChar = word.charAt(i);
            count++;
        }
        ans += count - 1;
        return ans + 1;
    }
}

