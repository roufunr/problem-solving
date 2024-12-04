package leetcode.daily_challenge.december_24.make_string_a_subsequence_using_cyclic_increments_04;

public class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        int i = 0; 
        int j = 0;
        while(i < len1 && j < len2) {
            if(str1.charAt(i) == str2.charAt(j) 
            || str1.charAt(i) + 1 == str2.charAt(j)
            || str1.charAt(i) -25 == str2.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
            }
        }
        if(i == len1 && j < len2) {
            return false;
        }
        return true;
    }
}