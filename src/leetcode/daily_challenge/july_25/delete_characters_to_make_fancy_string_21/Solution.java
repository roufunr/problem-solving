package leetcode.daily_challenge.july_25.delete_characters_to_make_fancy_string_21;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public String makeFancyString(String s) {
        Set<Integer> deletedIdx = new HashSet<>();
        for(int i = 2; i < s.length(); i++) {
            char first = s.charAt(i-2);
            char second = s.charAt(i-1);
            char third = s.charAt(i);
            if(first == second && second == third) {
                deletedIdx.add(i - 2);
            }
        }
        char[] charArray = new char[s.length() - deletedIdx.size()];
        int j = 0;
        for(int i = 0; i < s.length(); i++) {
            if(deletedIdx.contains(i)) {
                continue;
            }
            charArray[j++] = s.charAt(i);
        }
        return new String(charArray);
    }
}