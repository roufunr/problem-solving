package leetcode.daily_challenge.november_24.min_number_of_changes_to_make_binary_string_beautiful_05;


public class Solution {
    public int minChanges(String s) {
        int ans = 0;
        for(int i = 1; i < s.length(); i += 2) {
            if(s.charAt(i-1) != s.charAt(i)) {
                ans++;
            }
        }
        return ans;
    }
}