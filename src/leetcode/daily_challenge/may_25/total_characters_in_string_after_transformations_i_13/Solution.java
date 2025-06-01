package leetcode.daily_challenge.may_25.total_characters_in_string_after_transformations_i_13;
import java.util.*;
public class Solution {
    private final int MODULUS = 1000000000 + 7;
    private Map<String, Integer> cache;
    private int calculate(char c, int target) {
        int nextBranch = (int)('z' - c) + 1;
        if(nextBranch > target) {
            return 1;
        } else {
            String key = c + "_" + target;
            if(!cache.containsKey(key)) {
                int val = (calculate('a', target - nextBranch) + calculate('b', target - nextBranch)) % MODULUS;
                cache.put(c + "_" + target, val);
            }
            return cache.get(key);
        }
    }
    public int lengthAfterTransformations(String s, int t) {
        int ans = 0;
        cache = new HashMap<>();
        for(char c : s.toCharArray()) {
            ans += calculate(c, t);
            ans %= MODULUS;
        }
        return ans;
    }
}