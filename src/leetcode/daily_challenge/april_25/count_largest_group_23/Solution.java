package leetcode.daily_challenge.april_25.count_largest_group_23;

import java.util.Map;

public class Solution {
    public int countLargestGroup(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxCount = 0;
        for(int i = 1; i <= n; i++) {
            int sum = 0;
            int x = i;
            while(x > 0) {
                sum += (x % 10);
                x = x / 10;
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            maxCount = Math.max(map.get(sum), maxCount);
        }
        int ans = 0;
        for(int key : map.keySet()) {
            if(map.get(key) == maxCount) {
                ans++;
            }
        }
        return ans;
    }
}