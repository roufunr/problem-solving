package leetcode.daily_challenge.september_24.find_the_longest_substring_containing_vowels_in_even_counts_15;

import java.util.Arrays;


public class Solution {
    public int findTheLongestSubstring(String s) {
        int[] map = new int[26];
        map['a' - 'a'] = 1 << 0;
        map['e' - 'a'] = 1 << 1;
        map['i' - 'a'] = 1 << 2;
        map['o' - 'a'] = 1 << 3;
        map['u' - 'a'] = 1 << 4;
        int[] mem = new int[32];
        Arrays.fill(mem, -1);
        int prefixXOR = 0;
        int largestSubstr = 0;
        for(int i = 0; i < s.length(); i++) {
            prefixXOR ^= map[s.charAt(i) - 'a'];
            if(mem[prefixXOR] == -1 && prefixXOR != 0) {
                mem[prefixXOR] = i;
            }
            largestSubstr = Math.max(largestSubstr, i - mem[prefixXOR]);
        }
        return largestSubstr;
    }
}
