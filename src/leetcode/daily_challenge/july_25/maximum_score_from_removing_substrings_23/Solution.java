package leetcode.daily_challenge.july_25.maximum_score_from_removing_substrings_23;

import java.util.Stack;

public class Solution {
    private int totalScore = 0;
    private String performDeletion(String str, String match, int score) {
        Stack<Character> stack = new Stack<>();
        for(char c : str.toCharArray()) {
            if(c == match.charAt(1) 
                && !stack.isEmpty() 
                && stack.peek() == match.charAt(0)) {
                totalScore += score;
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
    public int maximumGain(String s, int x, int y) {
        performDeletion(performDeletion(s, x > y ? "ab" : "ba", x > y ? x : y), x > y ? "ba" : "ab", x > y ? y : x);
        return this.totalScore;
    }
}