package leetcode.daily_challenge.february_25.construct_smallest_number_from_di_string_18;
public class Solution {
    private String ans;
    private void bruteforce(String pattern, int idx, String currentNum, boolean[] used) {
        if(currentNum.length() == pattern.length() + 1) {
            if(currentNum.compareTo(ans) < 0) {
                ans = currentNum;
            }
            return;
        }
        for(int i = idx; i < pattern.length(); i++) {
            int lastDigit = (int)(currentNum.charAt(currentNum.length() - 1) - '0');
            if(pattern.charAt(i) == 'I') {
                for(int j = lastDigit + 1; j <= 9; j++) {
                    if(!used[j - 1]) {
                        used[j - 1] = true;
                        bruteforce(pattern, idx + 1, currentNum + j, used);
                        used[j - 1] = false;
                    }
                }
            } else {
                for(int j = lastDigit - 1; j > 0; j--) {
                    if(!used[j - 1]) {
                        used[j - 1] = true;
                        bruteforce(pattern, idx + 1, currentNum + j, used);
                        used[j - 1] = false;
                    }
                }
            }
        }
    }
    public String smallestNumber(String pattern) {
        boolean[] used = new boolean[9];
        String currentNum = "";
        ans = "999999999";
        for(int i = 1; i <= 9; i++) {
            used[i - 1] = true;
            bruteforce(pattern, 0, currentNum + i, used);
            used[i - 1] = false;
        }
        return ans;
    }   
}
