package leetcode.daily_challenge.august_24.fraction_addition_and_subtraction;

import java.util.*;

public class SolutionII {
    private List<String> split(String expression) {
        List<String> parts = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (char c : expression.toCharArray()) {
            if (c == '+' || c == '-') {
                if (sb.length() > 0)
                    parts.add(sb.toString());
                sb.setLength(0);
            }
            sb.append(c);
        }
        if (sb.length() > 0)
            parts.add(sb.toString());
        return parts;
    }

    private List<Frac> getFrac(List<String> parts) {
        List<Frac> fracs = new ArrayList<>();
        for (String part : parts) {
            String str = new String(part);
            boolean neg = false;
            if (part.charAt(0) == '-') {
                neg = true;
                str = str.replace("-", "");
            } else if (part.charAt(0) == '+') {
                str = str.replace("+", "");
            }
            Frac frac = new Frac(neg, Integer.parseInt(str.split("/")[0]), Integer.parseInt(str.split("/")[1]));
            fracs.add(frac);
        }
        return fracs;
    }

    public String fractionAddition(String expression) {
        List<Frac> fracs = getFrac(split(expression));
        Frac ans = fracs.get(0);
        for (int i = 1; i < fracs.size(); i++) {
            ans.add(fracs.get(i));
        }
        return ans.toString();
    }
}