package leetcode.daily_challenge.september_24.different_ways_to_add_parentheses_19;

import java.util.*;

public class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> results = new ArrayList<>();
        if(expression.length() == 0) {
            return results;
        }
        if(expression.length() == 1) {
            results.add(Integer.parseInt(expression));
            return results;
        }
        if(expression.length() == 2 && Character.isDigit(expression.charAt(0))) {
            results.add(Integer.parseInt(expression));
            return results;
        }
        for(int i = 0; i < expression.length(); i++) {
            if(Character.isDigit(expression.charAt(i))) {
                continue;
            }
            List<Integer> leftResult = diffWaysToCompute(expression.substring(0, i));
            List<Integer> rightResult = diffWaysToCompute(expression.substring(i + 1, expression.length()));
            for(int left : leftResult) {
                for(int right : rightResult) {
                    if(expression.charAt(i) == '+') {
                        results.add(left + right);
                    } else if(expression.charAt(i) == '-') {
                        results.add(left - right);
                    } else if(expression.charAt(i) == '*') {
                        results.add(left * right);
                    }
                }
            }
        }
        return results;
    }
}