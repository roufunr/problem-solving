package leetcode.daily_challenge.august_24.number_complement;

public class Solution {
    public int findComplement(int num) {
        int ans = 0;
        int k = 0;
        while (num > 0) {
            int remainder = num % 2;
            ans += remainder == 0 ? Math.pow(2, k) : 0;
            num /= 2;
            k++;
        }
        return ans;
    }
}