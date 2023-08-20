package leetcode.two_thousand_23.hash_table.longest_subtsring_without_repetiton;
import java.util.*;

public class Solution {

    //https://leetcode.com/explore/learn/card/hash-table/187/conclusion-hash-table/1135/
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int maxLen = 0;
        Map<Character, Integer> map = new HashMap<>();
        while(right < s.length()) {
            if(map.containsKey(s.charAt(right))) {
                int foundIdx = map.get(s.charAt(right));
                List<Character> deletedItems = new ArrayList<>();
                for(Map.Entry<Character, Integer> entry: map.entrySet()) {
                    if(entry.getValue() <= foundIdx) {
                        deletedItems.add(entry.getKey());
                    }
                }
                for(Character item : deletedItems) {
                    map.remove(item);
                }
                map.put(s.charAt(right), right);
                left = foundIdx + 1;
            } else {
                map.put(s.charAt(right), right);
            }
            int windowSize = right - left + 1;
            maxLen = maxLen < windowSize ? windowSize : maxLen;
            right++;
        }
        return maxLen;
    }
}
