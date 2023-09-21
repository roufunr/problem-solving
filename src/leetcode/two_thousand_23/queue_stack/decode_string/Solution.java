package leetcode.two_thousand_23.queue_stack.decode_string;

import java.util.Stack;


public class Solution {
    private boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
        } catch (Exception ex) {
            return false;
        }
        return true;
    }
    public String decodeString(String s) {
        String ans = "3[a2[c]]"; 
        // 3 a 2 c
        // 3 a cc
        // 3 acc
        // accaccacc

        Stack<String> stack = new Stack<>();
        
        for(int i = 0; i < s.length();) {
            if(s.charAt(i) == '[') {
                i++;
                continue;
            } else if(s.charAt(i) == ']') {
                String str = stack.pop();
                String str2  = stack.pop();
                Integer number = isNumeric(str2) ? Integer.parseInt(str2) : Integer.parseInt(stack.pop());
                String str3 = isNumeric(str2) ? "" : str2;

                str = str3 + str;

                String target = "";
                for(int j = 0; j < number; j++) {
                    target += str;
                }
                stack.push(target);
                i++;
            } else if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                String str = "" + s.charAt(i);
                int j = i + 1;
                while(s.charAt(j) >= 'a' && s.charAt(j) <= 'z') {
                    str += s.charAt(j);
                    j++;
                }
                stack.push(str);
                i = j;
            } else {
                String numberStr = "" + s.charAt(i);
                int j = i + 1;
                while(s.charAt(j) >= '0' && s.charAt(j) <= '9') {
                    numberStr += s.charAt(j);
                    j++;
                }
                stack.push(numberStr);
                i = j;
            }
        }

        ans = stack.pop();
        return ans;
    }
}