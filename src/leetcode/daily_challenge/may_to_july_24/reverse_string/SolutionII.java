package leetcode.daily_challenge.may_to_july_24.reverse_string;

import java.util.Stack;

public class SolutionII {
    public String reverseParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(sb.length());
            } else if (c == ')') {
                int startIdx = stack.pop();
                int endIdx = sb.length() - 1;
                for (int i = 0; i < (endIdx - startIdx + 1) / 2; i++) {
                    char temp = sb.charAt(startIdx + i);
                    sb.setCharAt(startIdx + i, sb.charAt(endIdx - i));
                    sb.setCharAt(endIdx - i, temp);
                }
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
