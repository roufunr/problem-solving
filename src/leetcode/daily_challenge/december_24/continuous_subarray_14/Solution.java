package leetcode.daily_challenge.december_24.continuous_subarray_14;
import java.util.*;
public class Solution {
    public long continuousSubarrays(int[] nums) {
        int start = 0;
        int end = 0;
        long count = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        while(end < nums.length) {
            map.put(nums[end], map.getOrDefault(nums[end], 0) + 1);
            while(start<= end && Math.abs(map.firstKey() - map.lastKey()) > 2) {
                map.put(nums[start], map.get(nums[start]) - 1);
                if(map.get(nums[start]) == 0) {
                    map.remove(nums[start]);
                }
                start++;
            }
            count += (end - start + 1);
            end++;
        }
        return count;
    }
}