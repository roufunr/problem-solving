package leetcode.two_thousand_24.recursionII.generate_parenthesis;

import java.util.*;

public class Solution {
    private int n;
    private List<String> ans;
    private boolean isValid(List<Character> parenthesis) {
        Stack<Character> stack = new Stack<>();
        for(Character c : parenthesis) {
            if(c == '(') {
                stack.push('(');
            } else {
                if(stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
    private void helper(List<Character> parenthesis) {
        if ((n * 2) == parenthesis.size()) {
            if (isValid(parenthesis)) {
                StringBuilder stringBuilder = new StringBuilder();
                for (Character c : parenthesis) {
                    stringBuilder.append(c);
                }
                ans.add(stringBuilder.toString());
            }
            return;
        }
        parenthesis.add('(');
        helper(parenthesis);
        parenthesis.remove(parenthesis.size() - 1);
        parenthesis.add(')');
        helper(parenthesis);
        parenthesis.remove(parenthesis.size() - 1);
        
    }
    public List<String> generateParenthesis(int n) {
        this.n = n;
        this.ans = new ArrayList<>();
        List<Character> parenthesis = new ArrayList<>();
        helper(parenthesis);
        return ans;
    }
}