package leetcode.two_thousand_24.recursion.fibonacci;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    private Map<Integer, Integer> map;
    
    public Solution() {
        map = new HashMap<>();
    }
    public int fib(int n) {
        if(n == 0 || n == 1) {
            return n;
        }
        if(map.containsKey(n)) {
            return map.get(n);
        }
        int fib_n = fib(n-1) + fib(n-2);
        map.put(n, fib_n);
        return fib_n;
    }
}
