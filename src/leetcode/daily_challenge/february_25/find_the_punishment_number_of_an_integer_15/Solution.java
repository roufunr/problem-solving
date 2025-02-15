package leetcode.daily_challenge.february_25.find_the_punishment_number_of_an_integer_15;

import java.util.*;

public class Solution {
    private List<List<Integer>> allCombination;
    private Set<Integer> punishmentNums;
    public Solution() {
        punishmentNums = new HashSet<>();
        for(int i = 1; i <= 1000; i++) {
            if(isPunishment(i)) {
                punishmentNums.add(i);
            }
        }
    }
    private void combination(List<Integer> list, int idx, int r, Stack<Integer> stack) {
        if(stack.size() == r) {
            List<Integer> ans = new ArrayList<>(stack);
            allCombination.add(ans);
            return;
        }
        for(int i = idx; i < list.size(); i++) {
            stack.push(list.get(i));
            combination(list, i + 1, r, stack);
            stack.pop();
        }
    }

    private boolean isPunishment(int num) {
        if(num == 1) {
            return true;
        }
        int square = num * num;
        String squareStr = ("" + square);
        int maxLen = squareStr.length();
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i <= maxLen; i++) {
            list.add(i);
        }
        allCombination = new ArrayList<>();
        for(int i = 1; i <= maxLen; i++) {
            combination(list, 0, i, new Stack<>());
        }
        for(List<Integer> com : allCombination) {
            int sum = 0;
            int startIdx = 0;
            for(int currentIdx : com) {
                sum += Integer.parseInt(squareStr.substring(startIdx, currentIdx));
                startIdx = currentIdx;
            }
            sum += startIdx < maxLen ? Integer.parseInt(squareStr.substring(startIdx, maxLen)) : 0;
            if(sum == num) {
                return true;
            }
        }
        return false;
    }
    
    public int punishmentNumber(int n) {
        int ans = 0;
        System.out.println(punishmentNums);
        for(int i = 1; i <= n; i++) {
            if(punishmentNums.contains(i)) {
                ans += i*i;
            }
        }
        return ans;
    }
    public int punishmentNumberV2(int n) {
        int[] nums = {1, 964, 9, 10, 909, 657, 82, 918, 792, 91, 414, 990, 991, 99, 675, 36, 100, 999, 1000, 297, 235, 45, 369, 945, 370, 756, 55, 379, 703};
        Set<Integer> punishmentNums = new HashSet<>();
        for(int num : nums) {
            punishmentNums.add(num);
        }
        int ans = 0;
        for(int i = 1; i <= n; i++) {
            if(punishmentNums.contains(i)) {
                ans += i*i;
            }
        }
        return ans;
    }
}