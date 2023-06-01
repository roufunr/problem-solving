package leetcode.queue_stack.valid_parenthesis;

import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()) {
            if(c == '('
            || c == '{'
            || c == '[') {
                stack.push(c);
            } else {

                if(c == ')'
                || c == '}'
                || c == ']') {
                    if(stack.isEmpty()) {
                        return false;
                    }
                }

                if(stack.peek() == '(' && c == ')') {
                    stack.pop();
                } else if(stack.peek() == '{' && c == '}') {
                    stack.pop();
                } else if(stack.peek() == '[' && c == ']') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        if(stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}