package leetcode.daily_challenge.july_25.valid_word_15;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean isValid(String word) {
        Set<Character> vowels = new HashSet<>();
        Collections.addAll(vowels, 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        if(word.length() < 3) {
            return false;
        }
        int vowelCount = 0;
        int consonantCount = 0;
        for(char c : word.toCharArray()) {
            if(c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z' || c >= '0' && c <= '9') {
                if(c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z') {
                    if(vowels.contains(c)) {
                        vowelCount++;
                    } else {
                        consonantCount++;
                    }
                }
            } else {
                return false;
            }
        }

        if(vowelCount >= 1 && consonantCount >= 1) {
            return true;
        } else {
            return false;
        }
        
    }
}