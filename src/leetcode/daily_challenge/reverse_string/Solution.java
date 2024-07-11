package leetcode.daily_challenge.reverse_string;

import java.util.*;

public class Solution {
    public String reverseParentheses(String s) {
        Stack<String> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == ')') {
                StringBuilder sb = new StringBuilder();
                while (!stack.peek().equals("(")) {
                    sb.append(new StringBuilder(stack.pop()).reverse().toString());
                }
                stack.pop();
                stack.push(sb.toString());
            } else {
                stack.push(c + "");
            }
        }
        String ans = "";
        while (!stack.isEmpty()) {
            ans = stack.pop() + ans;
        }
        return ans;
    }
}