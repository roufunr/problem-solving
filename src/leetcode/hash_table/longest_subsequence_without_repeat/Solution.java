package leetcode.hash_table.longest_subsequence_without_repeat;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    //https://leetcode.com/explore/learn/card/hash-table/187/conclusion-hash-table/1135/
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> charIndexMap = new HashMap();
        int slowPointer = 0;
        int fastPointer = 0;
        char[] charArray = s.toCharArray();
        int maxSeqCount = Integer.MIN_VALUE;
        for(char c :charArray) {
            if(!charIndexMap.containsKey(c)) {
                charIndexMap.put(c, fastPointer);
            } else {
                int lastOccuredIdx = charIndexMap.get(c);
                slowPointer = lastOccuredIdx >= slowPointer ? lastOccuredIdx + 1 : slowPointer;
                charIndexMap.put(c, fastPointer);
            }
            int seqCurrentLen = fastPointer - slowPointer + 1;
            maxSeqCount = maxSeqCount < seqCurrentLen ? seqCurrentLen : maxSeqCount;
            fastPointer++;
        }
        return maxSeqCount == Integer.MIN_VALUE ? 0 : maxSeqCount;
    }
}
