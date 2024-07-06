package leetcode.two_thousand_24.recursionII.letter_combination_of_phone_number;

import java.util.*;

public class Solution {
    private String digits;
    private List<String> ans;
    private Map<Character, List<Character>> map;

    public Solution() {
        map = new HashMap<>();
        map.put('2', new ArrayList<>(Arrays.asList('a', 'b', 'c')));
        map.put('3', new ArrayList<>(Arrays.asList('d', 'e', 'f')));
        map.put('4', new ArrayList<>(Arrays.asList('g', 'h', 'i')));
        map.put('5', new ArrayList<>(Arrays.asList('j', 'k', 'l')));
        map.put('6', new ArrayList<>(Arrays.asList('m', 'n', 'o')));
        map.put('7', new ArrayList<>(Arrays.asList('p', 'q', 'r', 's')));
        map.put('8', new ArrayList<>(Arrays.asList('t', 'u', 'v')));
        map.put('9', new ArrayList<>(Arrays.asList('w', 'x', 'y', 'z')));
    }

    private void helper(List<Character> perm) {
        if (perm.size() == digits.length()) {
            StringBuilder sb = new StringBuilder();
            for (Character c : perm) {
                sb.append(c);
            }
            if (perm.size() > 0) {
                ans.add(sb.toString());
            }
            return;
        }
        for (Character c : map.get(digits.charAt(perm.size()))) {
            perm.add(c);
            helper(perm);
            perm.remove(perm.size() - 1);
        }
    }

    public List<String> letterCombinations(String digits) {
        ans = new ArrayList<>();
        this.digits = digits;
        List<Character> perm = new ArrayList<>();
        helper(perm);
        return ans;
    }
}