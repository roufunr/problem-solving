package leetcode.daily_challenge.october_24.parsing_a_boolean_expression_20;
import java.util.*;
public class Solution {
    private Character getLogicalOperation(Character op, List<Character> operands) {
        boolean result = operands.get(0) == 'f' ? false : true;
        if(op == '!') {
            return result ? 'f': 't'; 
        }
        for(int i = 1; i < operands.size(); i++) {
            if(op == '&') {
                result &= (operands.get(i) == 'f' ? false : true);
            } else {
                result |= (operands.get(i) == 'f' ? false : true);
            }
        }
        return result ? 't': 'f';
    }
    public boolean parseBoolExpr(String expression) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < expression.length(); i++) {
            if(expression.charAt(i) == '(' || expression.charAt(i) == ',') {
                continue;
            } else if(expression.charAt(i) == ')') {
                List<Character> operands = new ArrayList<>();
                Character operation = '!';
                while(!stack.isEmpty()) {
                    if(stack.peek() == '&' || stack.peek() == '|' || stack.peek() == '!') {
                        operation = stack.pop();
                        break;
                    } else {
                        operands.add(stack.pop());
                    }
                }
                Character result = getLogicalOperation(operation, operands);
                stack.push(result);
            } 
            else {
                stack.push(expression.charAt(i));
            }
        }
        return stack.peek() == 't';
    }
}