package leetcode.daily_challenge.october_24.split_a_string_into_the_max_number_of_unique_substrings_21;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int maxUniqueSplit(String s) {
        int L = s.length() - 1;
        int N = (int)Math.pow(2, L);
        int max = 0;
        for(int i = 0; i < N; i++) {
            String binaryString = Integer.toBinaryString(i);
            binaryString = String.format("%" + L + "s", binaryString).replace(' ', '0');
            int startIdx = 0;
            Set<String> set = new HashSet<>();
            for(int j = 0; j < binaryString.length(); j++) {
                if(binaryString.charAt(j) == '0') {
                    continue;
                } else {
                    set.add(s.substring(startIdx, j+1));
                    startIdx = j + 1;
                }
            }
            if(startIdx < s.length()) {
                set.add(s.substring(startIdx));
            } 
            max = Math.max(max, set.size());
        }
        return max;
    }
}