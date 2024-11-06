package leetcode.daily_challenge.november_24.find_if_array_can_be_sorted_05;

import java.util.*;

class Solution {
    private Map<Integer, Integer> getCountMap(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            int count = 0;
            if (map.containsKey(n)) {
                continue;
            }
            int x = n;
            while (x > 0) {
                if (x % 2 == 1) {
                    count++;
                }
                x /= 2;
            }
            map.put(n, count);
        }
        return map;
    }

    public boolean canSortArray(int[] nums) {
        Map<Integer, Integer> map = getCountMap(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    if (map.get(nums[j]) != map.get(nums[j + 1])) {
                        return false;
                    } else {
                        int temp = nums[j];
                        nums[j] = nums[j + 1];
                        nums[j + 1] = temp;
                    }
                }
            }
        }
        return true;
    }
}