package leetcode.daily_challenge.january_25.check_if_a_parentheses_string_can_be_valid_12;

import java.util.Stack;

public class Solution {
    public boolean canBeValid(String s, String locked) {
        if(s.length() % 2 == 1) {
            return false;
        }
        Stack<Integer> lStack = new Stack<>();
        Stack<Integer> uStack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            if(locked.charAt(i) == '1') { // locked
                if(s.charAt(i) == ')') {
                    if(lStack.isEmpty()) {
                        if(uStack.isEmpty()) {
                            return false;
                        } else {
                            uStack.pop();
                        }
                    } else {
                        lStack.pop();
                    }
                } else {
                    lStack.push(i);
                } 
            } else {
                uStack.push(i);
            }
        }
        while(!lStack.isEmpty()) {
            if(uStack.isEmpty()) {
                return false;
            } else {
                if(uStack.peek() < lStack.peek()) {
                    return false;
                }
            }
            uStack.pop();
            lStack.pop();
        }
        return true;
    }
}