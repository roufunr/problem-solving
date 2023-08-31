package leetcode.two_thousand_23.queue_stack.daily_temperatures;
import java.util.*;

public class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new  Stack<>();
        int[] ans = new int[temperatures.length];
        stack.push(0);
        for(int i = 1; i < temperatures.length; i++) {
            while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int j = stack.pop();
                ans[j] = i -j;
            }
            stack.push(i);
        }

        return ans;
    }
}

