package leetcode.daily_challenge.march_25.divide_array_into_equal_pairs_17;
import java.util.*;
public class Solution {

    public boolean divideArray(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if(entry.getValue() % 2 != 0) {
                return false;
            }
        }
        return true;
    }
}