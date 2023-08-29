package leetcode.two_thousand_23.queue_stack.valid_parenthesis;
import java.util.*;

public class Solution {
    public boolean isValid(String s) {
        char[] arr = s.toCharArray();
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        Stack<Character> stack = new Stack<>();
        for(char c : arr) {
            if(c == '[' || c == '{' || c == '(') {
                stack.push(c);
            } else {
                if(!stack.isEmpty()) {
                    if(!map.get(c).equals(stack.peek())) {
                        return false;
                    } else {
                        stack.pop();
                    }
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
