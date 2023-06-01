package leetcode.queue_stack.daily_temperature;

import java.util.Stack;

public class Solution {
    //https://leetcode.com/explore/learn/card/queue-stack/230/usage-stack/1363/
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> stack = new Stack<>();
        int dataSize = temperatures.length;
        int[] ithTemperature = new int[dataSize];
        for(int i = 0; i < dataSize; i++) {
            while(!stack.isEmpty() && stack.peek()[0] < temperatures[i]) {
                ithTemperature[stack.peek()[1]] = i - stack.peek()[1];
                stack.pop();
            }
            stack.push(new int[]{temperatures[i], i});
        }
        return ithTemperature;
    }
}
