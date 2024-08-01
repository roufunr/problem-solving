package leetcode.daily_challenge.may_to_july_24.maximum_score;

import java.util.*;

public class Solution {

    private String removeStr(String given, String target) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < given.length(); i++) {
            char c = given.charAt(i);
            if (c == target.charAt(1) && !stack.isEmpty() && stack.peek() == target.charAt(0)) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    public int maximumGain(String s, int x, int y) {
        int highScore = Math.max(x, y);
        int lowScore = Math.min(x, y);
        String highPriorityTarget = x > y ? "ab" : "ba";
        String lowPriorityTarget = x > y ? "ba" : "ab";
        String remainigString = removeStr(s, highPriorityTarget);
        int ans = ((s.length() - remainigString.length()) / 2) * highScore;
        String remainigString2 = removeStr(remainigString, lowPriorityTarget);
        ans += ((remainigString.length() - remainigString2.length()) / 2) * lowScore;
        return ans;
    }
}