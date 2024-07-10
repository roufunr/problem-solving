package leetcode.daily_challenge.folder_logs_crawler;

import java.util.*;

public class Solution {
    public int minOperations(String[] logs) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < logs.length; i++) {
            if ("../".equals(logs[i])) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!"./".equals(logs[i])) {
                stack.push(logs[i]);
            }
        }
        return stack.size();
    }
}