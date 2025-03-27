package leetcode.daily_challenge.march_25.minimum_index_of_a_valid_split_27;
import java.util.*;
public class Solution {
    private int findDominantItem(List<Integer> nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        int max = Integer.MIN_VALUE;
        int maxItem = -1;
        for(Integer key : map.keySet()) {
            if(map.get(key) > max) {
                max = map.get(key);
                maxItem = key;
            }
        }
        return maxItem;
    }
    public int minimumIndex(List<Integer> nums) {
        int dominantItem = findDominantItem(nums);
        int[] prefSum = new int[nums.size()];
        int total = 0;
        for(int i = 0; i < nums.size(); i++) {
            if(nums.get(i) == dominantItem) {
                total++;
            }
            prefSum[i] = total;
        }
        int validSplitIdx = -1;
        for(int i = prefSum.length - 1; i >= 0; i--) {
            int leftCount = prefSum[i];
            int rightCount = total - prefSum[i];

            boolean leftCondition = leftCount > (i + 1)/2;
            boolean rightCondition = (prefSum.length - i - 1) / 2 < rightCount;
            if(leftCondition && rightCondition) {
                validSplitIdx = i;
            }
        }
        return validSplitIdx;
    }
}