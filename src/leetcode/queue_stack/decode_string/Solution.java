package leetcode.queue_stack.decode_string;

import java.util.Stack;

public class Solution {
    //https://leetcode.com/explore/learn/card/queue-stack/239/conclusion/1379/
    public String decodeString(String s) {
        char[] charArray = s.toCharArray();
        Stack<String> stack = new Stack<>();
        for(char c : charArray) {
            if(c == ']') {
                String seqBuilder = "";
                while(!stack.isEmpty()) {
                    if("[".equals(stack.peek())) {
                        stack.pop();
                      break;
                    } else {
                        seqBuilder = stack.pop() + seqBuilder;
                    }
                }

                String numberStr = "";
                while(!stack.isEmpty()) {
                    char digit = stack.peek().toCharArray()[0];
                    if(digit >= '0' && digit <= '9') {
                        numberStr = stack.pop() + numberStr;
                    } else {
                        break;
                    }
                }

                int times = Integer.parseInt(numberStr);
                String finalString = "";
                for(int i = 0; i < times; i++) {
                    finalString += seqBuilder;
                }

                stack.push(finalString);
            } else {
                stack.push("" + c);
            }
        }
        String ans = "";
        while (!stack.isEmpty()) {
            ans = stack.pop() + ans;
        }
        return ans;
    }
}
