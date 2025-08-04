package leetcode.daily_challenge.june_25.divide_a_string_into_groups_of_size_k_22;

public class Solution {
    public String[] divideString(String s, int k, char fill) {
        if(s.length() % k != 0) {
            int remaining = k - (s.length() % k);
            // System.out.println(remaining);
            StringBuilder x = new StringBuilder(s);
            for(int i = 0; i < remaining; i++) {
                x.append(fill);
            }
            s = x.toString();
            // System.out.println(x.toString());
        }
        // System.out.println(s);
        String[] ans = new String[s.length() / k];
        for(int i = 0; i < ans.length; i++) {
            ans[i] = s.substring(i * k, k * (i + 1));
        }
        return ans;
    }
}