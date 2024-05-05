package leetcode.two_thousand_24.bst.contains_duplicate_III;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {

    // bruteforce Solution
    // encounters TLE
    public boolean containsNearbyAlmostDuplicateV0(int[] nums, int indexDiff, int valueDiff) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i == j) {
                    continue;
                }
                int currentIdxDiff = Math.abs(i - j);
                int currentValueDiff = Math.abs(nums[i] - nums[j]);
                if (currentIdxDiff <= indexDiff && currentValueDiff <= valueDiff) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        Map<Integer, Integer> bucketMap = new HashMap<>();
        int windowSize = indexDiff + 1;
        for (int i = 0; i < nums.length; i++) {
            int bucket = Math.floorDiv(nums[i], (valueDiff + 1));
            if (bucketMap.containsKey(bucket)) {
                return true;
            }
            if (bucketMap.containsKey(bucket - 1) && Math.abs(bucketMap.get(bucket - 1) - nums[i]) <= valueDiff) {
                return true;
            }
            if (bucketMap.containsKey(bucket + 1) && Math.abs(bucketMap.get(bucket + 1) - nums[i]) <= valueDiff) {
                return true;
            }
            bucketMap.put(bucket, nums[i]);

            if (bucketMap.size() > indexDiff) {
                bucketMap.remove(Math.floorDiv(nums[i - indexDiff], valueDiff + 1));
            }
            
        }
        return false;
    }
}

// 2 <= nums.length <= 105
// -109 <= nums[i] <= 109
// 1 <= indexDiff <= nums.length
// 0 <= valueDiff <= 109