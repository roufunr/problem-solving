package lc_others.count_vowel_substrings_of_a_string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public int countVowelSubstrings(String word) {
        Map<Character, Integer> vowels = new HashMap<>();
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        int count = 0;
        for(int i = 0; i < word.length(); i++) {
            Set<Character> tempSet = new HashSet<>();
            for(int j = i; j < word.length(); j++) {
                char c = word.charAt(j);
                if(set.contains(c)) {
                    tempSet.add(c);
                    if(tempSet.size() == 5) {
                        count++;
                    }
                } else {
                    break;
                }

            }
        }
        return count;
    }
}
