package leetcode.daily_challenge.march_25.count_of_substrings_containing_every_vowel_and_k_consonants_ii_10;

import java.util.*;


public class Solution {
    public long countOfSubstrings(String word, int k) { 
        int[] nextConsonentIdx = new int[word.length()];
        int currentConsonentIdx = word.length();
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        for(int i = word.length() - 1; i >= 0; i--) {
            nextConsonentIdx[i] = currentConsonentIdx;
            if(!vowels.contains(word.charAt(i))) {
                currentConsonentIdx = i;
            }
        }
        Map<Character, Integer> vCount = new HashMap<>();
        long ans = 0;
        int start = 0;
        int end = 0;
        int consonantCount = 0;
        while(end < word.length()) {
            char endChar = word.charAt(end);
            if(vowels.contains(endChar)) {
                vCount.put(endChar, vCount.getOrDefault(endChar, 0) + 1);
            } else {
                consonantCount++;
            }
            

            while(consonantCount > k) {
                char startChar = word.charAt(start);
                if(vowels.contains(startChar)) {
                    vCount.put(startChar, vCount.get(startChar) - 1);
                    if(vCount.get(startChar) == 0) {
                        vCount.remove(startChar);
                    }
                } else {
                    consonantCount--;
                }
                start++;
            }

            while(consonantCount == k && vCount.size() == 5 && start <= end) {
                ans += nextConsonentIdx[end] - end;
                char startChar = word.charAt(start);
                if(vowels.contains(startChar)) {
                    vCount.put(startChar, vCount.get(startChar) - 1);
                    if(vCount.get(startChar) == 0) {
                        vCount.remove(startChar);
                    }
                } else {
                    consonantCount--;
                }
                start++;
            } 
            end++;
        }

        return ans;

    }

}
