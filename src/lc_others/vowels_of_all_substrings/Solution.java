package lc_others.vowels_of_all_substrings;
import java.util.*;
public class Solution {
    public long countVowels(String word) {
        long totalLen = (long)word.length();
        long substrCount = 0;
        Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        for(long i = 0; i < totalLen; i++) {
            char c = word.charAt((int)i);
            if(set.contains(c)) {
                substrCount += (long)(totalLen - 1 + i * (totalLen - 1 - i) + 1);
            }
        }
        return substrCount;
    }
}