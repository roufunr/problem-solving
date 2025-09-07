package leetcode.daily_challenge.september_25.find_n_unique_integers_sum_upto_zero_07;

public class Solution {
    public int[] sumZero(int n) {
        int[] ans = new int[n];
        for(int i = 0; i < n; i++) {
            if(i == 0 && n % 2 != 0) {
                continue;
            }
            ans[i] = (i + 1);
            ans[i + 1] = - (i + 1);
            i+=1;
        }
        return ans;
    }
}