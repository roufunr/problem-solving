package leetcode.two_thousand_24.recursionII.generate_parenthesis;

import java.util.ArrayList;
import java.util.List;

public class SolutionII {
    // slide better version
    // tracking open and close parenthesis count
    private int n;
    private List<String> ans;

    private void helper(List<Character> parenthesis, int open, int close) {
        if ((n * 2) == (open + close)) {
            StringBuilder stringBuilder = new StringBuilder();
            for (Character c : parenthesis) {
                stringBuilder.append(c);
            }
            ans.add(stringBuilder.toString());
            return;
        }

        if (open < n) {
            parenthesis.add('(');
            helper(parenthesis, open + 1, close);
            parenthesis.remove(parenthesis.size() - 1);
        }

        if (close < open) {
            parenthesis.add(')');
            helper(parenthesis, open, close + 1);
            parenthesis.remove(parenthesis.size() - 1);
        }

    }

    public List<String> generateParenthesis(int n) {
        this.n = n;
        this.ans = new ArrayList<>();
        List<Character> parenthesis = new ArrayList<>();
        helper(parenthesis, 0, 0);
        return ans;
    }

}
