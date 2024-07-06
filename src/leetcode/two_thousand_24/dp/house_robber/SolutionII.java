package leetcode.two_thousand_24.dp.house_robber;

import java.util.ArrayList;
import java.util.List;

public class SolutionII { // bottom up // better
    public int rob(int[] nums) {
        if (nums.length < 2) {
            return nums[0];
        }
        List<Integer> dp = new ArrayList<>();
        dp.add(nums[0]);
        dp.add(Math.max(nums[0], nums[1]));
        for (int i = 2; i < nums.length; i++) {
            dp.add(Math.max(dp.get(i - 1), dp.get(i - 2) + nums[i]));
        }
        return dp.get(dp.size() - 1);
    }
}
