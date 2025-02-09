package leetcode.daily_challenge.february_25.count_number_of_bad_pairs_09;

import java.util.*;

class Solution {
    public long countBadPairs(int[] nums) {
        // idea is to count good pairs first
        Map<Integer, Integer> diffCountMap = new HashMap<>();
        long badPairsCount = 0;
        for (int i = 0; i < nums.length; i++) {
            int diff = i - nums[i];
            int countOfAlreadyExistedGoodPairs = diffCountMap.getOrDefault(diff, 0);
            int possiblePairTillThisPosition = i;
            badPairsCount += possiblePairTillThisPosition - countOfAlreadyExistedGoodPairs;
            diffCountMap.put(diff, countOfAlreadyExistedGoodPairs + 1);
        }
        return badPairsCount;
    }
}
