package leetcode.current.beginners_guide.running_sum_of_1_d_array;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    // https://leetcode.com/problems/running-sum-of-1d-array/
    public int[] runningSum(int[] nums) {
        // it's a cumulative sum actually
        List<Integer> sum = new ArrayList<>();
        int cumulative_sum = 0;
        for(int n : nums) {
            cumulative_sum += n;
            sum.add(cumulative_sum);
        }

        int[] ans = new int[sum.size()];
        for(int i = 0; i < sum.size(); i++) {
            ans[i] = sum.get(i);
        }
        return ans;
    }
}
