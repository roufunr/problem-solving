package leetcode.daily_challenge.september_24.different_ways_to_add_parentheses_19;
import java.util.*;
public class SolutionI {
    private List<Integer>[][] cache;
    public List<Integer> diffWaysToCompute(String expression) {
        cache = new ArrayList[expression.length()][expression.length()];
        return dp(expression, 0, expression.length() - 1);
    }
    public List<Integer> dp(String expression, int startIdx, int endIdx) {
        List<Integer> results = new ArrayList<>();
        if(startIdx == endIdx) {
            results.add(Integer.parseInt(expression.substring(startIdx, endIdx + 1)));
            return results;
        }
        if(endIdx - startIdx == 1 && Character.isDigit(expression.charAt(startIdx))) {
            results.add(Integer.parseInt(expression.substring(startIdx, endIdx + 1)));
            return results;
        }
        if(cache[startIdx][endIdx] != null) {
            return cache[startIdx][endIdx];
        }
        for(int i = startIdx; i <= endIdx; i++) {
            if(Character.isDigit(expression.charAt(i))) {
                continue;
            }
            List<Integer> leftResult = dp(expression, startIdx, i - 1);
            List<Integer> rightResult = dp(expression, i + 1, endIdx);
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
        cache[startIdx][endIdx] = results;
        return results;
    }
}