package leetcode.hash_table.two_sum_1;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    //https://leetcode.com/explore/learn/card/hash-table/184/comparison-with-other-data-structures/1115/
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        Map<Integer, Integer> numberInMap = new HashMap();
        for(int i = 0; i < nums.length; i++) {
            numberInMap.put(nums[i], i);
        }

        for(int i = 0; i < nums.length; i++) {
            int firstNum = nums[i];
            int secondNum = target  - firstNum;
            if(numberInMap.containsKey(secondNum) && numberInMap.get(secondNum) != i) {
                int j = numberInMap.get(secondNum);
                ans[0] = i <= j ? i : j;
                ans[1] = i <= j ? j : 1;
                return ans;
            }
        }
        return ans;
    }
}
