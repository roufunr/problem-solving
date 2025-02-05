package leetcode.daily_challenge.february_25.check_if_one_string_swap_can_make_strings_equal_05;

import java.util.*;
public class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        Map<Character, List<Integer>> position = new HashMap<>();
        for(int i = 0; i < s2.length(); i++) {
            if(!position.containsKey(s2.charAt(i))) {
                position.put(s2.charAt(i), new ArrayList<>());
            }
            position.get(s2.charAt(i)).add(i);
        }
        for(int i = 0; i < s1.length(); i++) {
            if(position.containsKey(s1.charAt(i))) {
                for(int j : position.get(s1.charAt(i))) {
                    StringBuilder temp = new StringBuilder(s1);
                    temp.setCharAt(j, s1.charAt(i));
                    temp.setCharAt(i, s1.charAt(j));
                    if(temp.toString().equals(s2)) {
                        System.out.println(temp + " -- " + s1 );
                        return true;
                    }
                }
            }
        }
        return false;
    }
}