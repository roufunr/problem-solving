package lc_others.remove_invalid_parentheses;

import java.util.*;

public class Solution {
    private Set<String> validParentheses;
    private int minRemoval;
    private String s;
    public void reset() {
        validParentheses = new HashSet<>();
        minRemoval = Integer.MAX_VALUE;
    }
    private void backTrack(int idx, int leftCount, int rightCount, StringBuilder exp, int remCount) {
        if(idx == s.length()) {
            if(leftCount == rightCount) {
                if(remCount > minRemoval) {
                    return;
                } else if(remCount < minRemoval) {
                    minRemoval = remCount;
                    validParentheses.clear();
                }
                validParentheses.add(exp.toString());
            }
            return; 
        }
        int length = exp.length();
        char currentChar = s.charAt(idx);
        if(currentChar >= 'a' && currentChar <= 'z') {
            exp.append(currentChar);
            backTrack(idx + 1, leftCount, rightCount, exp, remCount);
            exp.deleteCharAt(length);
        } else {
            backTrack(idx + 1, leftCount, rightCount, exp, remCount + 1);
            exp.append(currentChar);
            if(currentChar == '(') {
                backTrack(idx + 1, leftCount + 1, rightCount, exp, remCount);
            } else {
                if(leftCount > rightCount) {
                    backTrack(idx + 1, leftCount, rightCount + 1, exp, remCount);
                }
            }
            exp.deleteCharAt(length);
        }
    }
    public List<String> removeInvalidParentheses(String s) {
        this.s = s;
        this.reset();
        StringBuilder exp = new StringBuilder();
        backTrack(0, 0, 0, exp, 0);
        return new ArrayList<>(validParentheses);
    }
}