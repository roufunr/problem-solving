package leetcode.daily_challenge.september_25.sort_vowels_in_a_string_11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public String sortVowels(String s) {
        List<Character> vowelsInInput = new ArrayList<>();
        Set<Character> vowels = new HashSet<>(Arrays.asList(new Character[]{'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'}));
        for(char c: s.toCharArray()) {
            if(vowels.contains(c)) {
                vowelsInInput.add(c);
            }
        }
        Collections.sort(vowelsInInput);
        StringBuilder sb = new StringBuilder();
        int k = 0;
        for(int i = 0; i < s.length(); i++) {
            if(vowels.contains(s.charAt(i))) {
                sb.append(vowelsInInput.get(k++));
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}