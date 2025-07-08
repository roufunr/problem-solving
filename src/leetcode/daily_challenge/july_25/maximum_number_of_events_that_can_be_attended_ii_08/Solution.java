package leetcode.daily_challenge.july_25.maximum_number_of_events_that_can_be_attended_ii_08;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution { 
    Map<String, Integer> cache;
    private int findNextIndex(int[][] events, int currentIdx) {
        int left = currentIdx + 1;
        int right = events.length - 1;
        int val = events[currentIdx][1]; // endtime
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (events[mid][0] > val) {  // Found candidate
                right = mid - 1;          // Look for smaller index
            } else {
                left = mid + 1;           // Need larger value
            }
        }

        return left < events.length ? left : -1;  // Return -1 if not found
    }
    
    private int dp(int startIdx, int[][] events, int k) {
        if(startIdx >= events.length || startIdx == -1 || k == 0) {
            return 0;
        }
        
        String key = startIdx + "," + k;  // Simple string key
        if(cache.containsKey(key)) {
            return cache.get(key);
        }
        
        int nextIdx = findNextIndex(events, startIdx);
        int val1 = events[startIdx][2] + dp(nextIdx, events, k - 1);
        int val2 = dp(startIdx + 1, events, k);
        int val = Math.max(val1, val2);
        
        cache.put(key, val);  // Store with string key
        return val;
    }    
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, (a, b) -> (a[0] - b[0]));
        cache = new HashMap<>();
        return dp(0, events, k);
    }
}