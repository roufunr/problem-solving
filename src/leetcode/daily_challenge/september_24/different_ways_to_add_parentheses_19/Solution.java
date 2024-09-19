package leetcode.daily_challenge.september_24.different_ways_to_add_parentheses_19;

import java.util.*;

class Permutations {
    public List<List<Integer>> generatePermutations(List<Integer> nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, new boolean[nums.size()]);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, List<Integer> nums, boolean[] used) {
        if (tempList.size() == nums.size()) {
            result.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < nums.size(); i++) {
                if (used[i])
                    continue;
                used[i] = true;
                tempList.add(nums.get(i));
                backtrack(result, tempList, nums, used);
                used[i] = false;
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}

class Solution {
    private int findAlongsideIdx(List<Integer> pSign, int idx, boolean before) {
        int k = -1;
        for (int i = 0; i < pSign.size(); i++) {
            if (pSign.get(i) == idx) {
                k = i;
                break;
            }
        }
        if (before) {
            return k > 0 ? pSign.get(k - 1) : -1;
        } else {
            return k < pSign.size() - 1 ? pSign.get(k + 1) : pSign.size();
        }

    }

    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> pSign = new ArrayList<>();
        Set<Character> sign = new HashSet<>();
        sign.add('+');
        sign.add('-');
        sign.add('*');
        for (int i = 0; i < expression.length(); i++) {
            if (sign.contains(expression.charAt(i))) {
                pSign.add(i);
            }
        }
        List<List<Integer>> allPerm = new Permutations().generatePermutations(pSign);
        Set<Integer> ans = new HashSet<>();
        for (List<Integer> perm : allPerm) {
            StringBuilder sb = new StringBuilder(expression);
            for (int idx : perm) {
                char s = sb.charAt(idx);
                int beforeIdx = findAlongsideIdx(pSign, idx, true);
                int afterIdx = findAlongsideIdx(pSign, idx, false);
                String left = sb.substring(beforeIdx + 1, idx);
                String right = sb.substring(idx + 1, afterIdx);
                int len = left.length() + right.length() + 1;
                int leftInt = Integer.parseInt(left);
                int rightInt = Integer.parseInt(right);
                String result = "";
                if (s == '+') {
                    result = "" + (leftInt + rightInt);
                } else if (s == '-') {
                    result = "" + (leftInt - rightInt);
                } else if (s == '*') {
                    result = "" + (leftInt * rightInt);
                }
                StringBuilder resultString = new StringBuilder("" + result);
                for (int i = 0; i < (len - result.length()); i++) {
                    resultString.insert(0, "0");
                }
                sb.replace(beforeIdx + 1, afterIdx, resultString.toString());
            }
            ans.add(Integer.parseInt(sb.toString()));
        }
        return new ArrayList<>(ans);
    }
}