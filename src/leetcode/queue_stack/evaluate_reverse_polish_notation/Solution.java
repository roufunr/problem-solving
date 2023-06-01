package leetcode.queue_stack.evaluate_reverse_polish_notation;

import java.util.HashMap;
import java.util.Stack;

public class Solution {
    //https://leetcode.com/explore/learn/card/queue-stack/230/usage-stack/1394/
    private int getCalculation(String operator, int operand1, int operand2) {
        if(operator.equals("+")) {
            return operand1 + operand2;
        } else if(operator.equals("-")) {
            return operand2 - operand1;
        } else if(operator.equals("*")) {
            return operand2 * operand1;
        } else {
            return operand2 / operand1;
        }
    }
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for(String str : tokens) {
            if(str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")) {
                int top = stack.pop();
                int secondTop = stack.pop();
                stack.push(getCalculation(str, top, secondTop));
            } else {
                stack.push(Integer.parseInt(str));
            }
        }
        return stack.peek();
    }
}
