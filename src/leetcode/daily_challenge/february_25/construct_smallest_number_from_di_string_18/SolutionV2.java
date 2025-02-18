package leetcode.daily_challenge.february_25.construct_smallest_number_from_di_string_18;

import java.util.Stack;

public class SolutionV2 {
    public String smallestNumber(String pattern) {
        StringBuilder result = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i <= pattern.length(); i++) {
            stack.push(i + 1);
            if (i == pattern.length() || pattern.charAt(i) == 'I') {
                while (!stack.isEmpty()) {
                    result.append(stack.pop());
                }
            }
        }
        
        return result.toString();
    }
}
