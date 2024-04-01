package leetcode.two_thousand_24.recursion.climbing_stairs;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    private Map<Integer, Integer> map;
    
    public Solution() {
        map = new HashMap<>();
    }
    public int climbStairs(int n) {
        if(n == 0 || n == 1) {
            return n;
        }
        if(map.containsKey(n)) {
            return map.get(n);
        }
        int fib_n = climbStairs(n-1) + climbStairs(n-2);
        map.put(n, fib_n);
        return fib_n;
    }
}
