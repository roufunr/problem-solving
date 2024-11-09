package leetcode.daily_challenge.november_24.minimum_array_end_09;

import java.util.*;
public class Solution {
    public long minEnd(int n, int x) {
        long ans = x;
        int itr = n - 1;
        List<Boolean> bits = new ArrayList<>();
        while(itr > 0) {
            if(itr % 2 == 1) {
                bits.add(true);
            } else {
                bits.add(false);
            }
            itr = itr / 2;
        }
        int k = 0;
        int j = 0;
        while(x > 0) {
            if(k == bits.size()) {
                return ans;
            }
            if(x % 2 == 0) {
                long one = 1;
                one = one << j;
                ans |= (bits.get(k++)? one : 0);
            }
            j++;
            x /= 2;
        }
        while(k < bits.size()) {
            long one = 1;
            one = one << j;
            // System.out.println(one);
            ans |= (bits.get(k++)? one : 0);
            j++;
        }
        return ans;
    }
}