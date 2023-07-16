package leetcode.two_thousand_23.weekly_contest.wc_354.maximum_index_of_valid_split;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    // https://leetcode.com/contest/weekly-contest-354/problems/minimum-index-of-a-valid-split/
    private int findDomainatElement(List<Integer> nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(Integer n : nums) {
            if(map.containsKey(n)) {
                map.put(n, map.get(n) + 1);
            } else {
                map.put(n, 1);
            }
        }
        int max = map.get(nums.get(0));
        int dominantelement = nums.get(0);
        for(Map.Entry<Integer, Integer> keyValue : map.entrySet()) {
            if(max < keyValue.getValue()) {
                dominantelement = keyValue.getKey();
                max = keyValue.getValue();
            }
        }
        return dominantelement;
    }
    public int minimumIndex(List<Integer> nums) {
        int dominantElement = findDomainatElement(nums);
        List<Integer> dominantElementIndices = new ArrayList<>();
        for(int i = 0; i < nums.size(); i++) {
            if(nums.get(i) == dominantElement) {
                dominantElementIndices.add(i);
            }
        }
        for(int i = 0; i < dominantElementIndices.size(); i++) {
            boolean firstClaus = dominantElementIndices.get(i) < (nums.size() - 1);
            boolean leftPart = (2 * (i + 1)) > (dominantElementIndices.get(i) + 1);
            boolean rightpart = (2 * (dominantElementIndices.size() - i - 1)) > (nums.size() - dominantElementIndices.get(i) - 1);
            if(firstClaus && leftPart && rightpart) {
                return dominantElementIndices.get(i);
            }
        }
        return -1;
    }
}
