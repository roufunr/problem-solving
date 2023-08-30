package leetcode.two_thousand_23.queue_stack.daily_temperatures;
import java.util.*;

public class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // [73,74,75,71,69,72,76,73]
        // [1,1,4,2,1,1,0,0]
        Stack<Integer> stack = new  Stack<>();
        int[] ans = new int[temperatures.length];
        for(int i =0; i < temperatures.length; i++) {
            while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int j = stack.pop();
                ans[j] = i -j;
            }
            stack.push(i);
        }

        return ans;
    }
}

